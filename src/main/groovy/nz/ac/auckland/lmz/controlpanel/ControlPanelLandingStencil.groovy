package nz.ac.auckland.lmz.controlpanel

import groovy.transform.CompileStatic
import nz.ac.auckland.lmz.controlpanel.core.ControlPanel
import nz.ac.auckland.stencil.Path
import nz.ac.auckland.stencil.Stencil

import javax.annotation.PostConstruct
import javax.inject.Inject
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Author: Marnix
 *
 */
@Path("/controlpanel")
@CompileStatic
class ControlPanelLandingStencil implements Stencil {

	/**
	 * All the panels
	 */
	@Inject List<ControlPanel> panels;

	/**
	 * Access control
	 */
	@Inject AccessControlService accessControlService;

	/**
	 * First panel
	 */
	ControlPanel homePanel;


	/**
	 * To redirect to
	 */
	@Inject ControlPanelTabStencil tabStencil;

	@PostConstruct
	public void getHomePanel() {

		// sort them by priority
		panels.sort { ControlPanel one, ControlPanel other ->
			one.metadata.position <=> other.metadata.position
		};

		homePanel = panels.first();

	}

	/**
	 * Just calls the tab stencil render method with the URI of the very first panel
	 *
	 * @param request
	 * @param response
	 * @param pathParameters
	 */
	@Override
	void render(HttpServletRequest request, HttpServletResponse response, Map<String, String> pathParameters) {

		if (!accessControlService.canAccessControlPanel(request)) {
			accessDenied(response);
			return;
		}

		// forward to other stencil
		tabStencil.render(request, response, ['uri' : homePanel.metadata.uri]);
	}

	/**
	 * Set the response to forbidden
	 *
	 * @param response is the response instance to set the status code on
	 */
	protected void accessDenied(HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
	}

}
