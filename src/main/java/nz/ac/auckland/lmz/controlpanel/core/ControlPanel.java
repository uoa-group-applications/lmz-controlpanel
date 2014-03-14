package nz.ac.auckland.lmz.controlpanel.core;

import java.util.Map;

/**
 * Author: Marnix
 *
 * An interface that describes a control panel
 */
public interface ControlPanel {

	/**
	 * @return the meta data about this control panel
	 */
	ControlPanelMetadata getMetadata();

	/**
	 * @return the JSP location of the stencil that is to be rendered
	 */
	String getTemplate();

	/**
	 * @return a map with a view model
	 */
	Map<String, Object> getViewModel();


}
