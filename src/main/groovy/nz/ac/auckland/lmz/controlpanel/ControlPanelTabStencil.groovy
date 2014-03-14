package nz.ac.auckland.lmz.controlpanel

import groovy.transform.CompileStatic
import nz.ac.auckland.lmz.controlpanel.core.ControlPanel
import nz.ac.auckland.lmz.controlpanel.core.ControlPanelMetadata
import nz.ac.auckland.stencil.LinkBuilder
import nz.ac.auckland.stencil.Path
import nz.ac.auckland.stencil.Stencil
import nz.ac.auckland.stencil.StencilService

import javax.annotation.PostConstruct
import javax.inject.Inject
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Author: Marnix
 *
 * Control panel tab. Wildcard @Path annotation that will find the control panel it belongs to and
 * renders it.
 */
@Path("/controlpanel/{uri}")
@CompileStatic
class ControlPanelTabStencil implements Stencil {

	/**
	 * All the panels
	 */
	@Inject List<ControlPanel> panels;

	/**
	 * Stencil service
	 */
	@Inject StencilService stencilService;

	/**
	 * Access control
	 */
	@Inject AccessControlService accessControlService;


	@Inject LinkBuilder linkBuilder

	/**
	 * Sort panels after initialization
	 */
	@PostConstruct
	public void sortPanelsByPosition() {

		// sort them by position
		panels.sort { ControlPanel one, ControlPanel other ->
			one.metadata.position <=> other.metadata.position
		};

	}

	/**
	 * Render the stencil for the tab that is being called
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

		// find active panel
		ControlPanel activePanel = this.panels.find { ControlPanel panel ->
			panel.metadata.uri == pathParameters['uri']
		};

		// not any existing panel? 404.
		if (!activePanel) {
			pageNotFound(response);
			return;
		}

		// render panel
		stencilService.renderJsp(
				request,
				response,
				"/WEB-INF/jsp/controlpanel/page.jsp",
				[
					contextPath : this.contextPath,
					activeUri : pathParameters['uri'],
					panels: this.panelMetadata,
					model: activePanel.viewModel,
					template: activePanel.template,
					assets: activePanel.metadata.assets
				]
		);
	}

	/**
	 * @return the application's context path
	 */
	protected String getContextPath() {

		if (linkBuilder.contextPath == '/')
			return ''

		String normalized = linkBuilder.contextPath
		if (!normalized.startsWith('/'))
			normalized = "/$normalized"

		return normalized
	}

	/**
	 * @return a list of all panel metadata (sorted by position)
	 */
	protected List<ControlPanelMetadata> getPanelMetadata() {
		return this.panels.collect { ControlPanel panel -> panel.metadata }
	}

	/**
	 * Set return status
	 *
	 * @param response is the response object to set it in
	 */
	protected void pageNotFound(HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
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
