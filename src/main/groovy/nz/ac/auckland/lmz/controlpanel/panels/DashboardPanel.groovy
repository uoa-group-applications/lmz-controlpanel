package nz.ac.auckland.lmz.controlpanel.panels

import groovy.transform.CompileStatic
import nz.ac.auckland.common.stereotypes.UniversityComponent
import nz.ac.auckland.lmz.controlpanel.core.ControlPanel
import nz.ac.auckland.lmz.controlpanel.core.ControlPanelMetadata
import nz.ac.auckland.stencil.StencilService
import org.springframework.beans.factory.annotation.Autowired

import javax.annotation.PostConstruct
import javax.inject.Inject

/**
 * Author: Marnix
 *
 * The dashboard is the standard control panel that
 */
@UniversityComponent
@CompileStatic
class DashboardPanel implements ControlPanel {


	/**
	 * All the panels
	 */
	@Autowired(required = false)
	List<ControlPanel> panels;

	/**
	 * Sort panels after initialization
	 */
	@PostConstruct
	public void sortPanelsByPosition() {

		// sort them by position
		panels?.sort { ControlPanel one, ControlPanel other ->
			one.metadata.position <=> other.metadata.position
		};

	}

	/**
	 * @return the dashboard template
	 */
	@Override
	String getTemplate() {
		return "/WEB-INF/jsp/controlpanel/panel/dashboard.jsp"
	}

	/**
	 * @return a view model
	 */
	@Override
	Map<String, Object> getViewModel() {
		return [
			panels : this.panels.collect { ControlPanel panel -> panel.metadata }
		];
	}

	/**
	 * @return the information about this component
	 */
	@Override
	ControlPanelMetadata getMetadata() {
		return new ControlPanelMetadata(
				uri: "dashboard",
				title: "Dashboard",
				position: Integer.MIN_VALUE
		)
	}
}
