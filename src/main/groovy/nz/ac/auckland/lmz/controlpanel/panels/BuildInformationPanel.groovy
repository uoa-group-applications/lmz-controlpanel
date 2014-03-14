package nz.ac.auckland.lmz.controlpanel.panels

import groovy.transform.CompileStatic
import nz.ac.auckland.common.config.ConfigKey
import nz.ac.auckland.common.stereotypes.UniversityComponent
import nz.ac.auckland.lmz.controlpanel.core.ControlPanel
import nz.ac.auckland.lmz.controlpanel.core.ControlPanelMetadata

/**
 * Author: Marnix
 *
 * A simple panel that contains information about the current build
 */
@UniversityComponent
@CompileStatic
class BuildInformationPanel implements ControlPanel {

	@ConfigKey("Implementation-Version")
	private String buildVersion = 'unknown';

	@ConfigKey("controlpanel.build.skipproperties")
	private String skipProperties = "java.class.path";

	/**
	 * @return the control panel meta data
	 */
	@Override
	ControlPanelMetadata getMetadata() {
		return new ControlPanelMetadata(
				title: "Build",
				description: "An overview of important build metadata",
				uri: "build-info"
			);
	}

	/**
	 * @return the template to render
	 */
	@Override
	String getTemplate() {
		return "/WEB-INF/jsp/controlpanel/panel/buildinfo.jsp";
	}


	protected Map<String, String> getPropertiesMap() {
		Map<String, String> allProperties = System.getProperties().sort() as LinkedHashMap<String, String>;

		// filter out some undesirables
		return allProperties.findAll { Map.Entry<String, String> entry ->

			if (entry.key in bannedProperties) {
				return null
			}
			else if (entry.key.toLowerCase().indexOf("pass") == -1) {

				return entry;
			}
			else {
				return null;
			}

		} as Map<String, String>;
	}

	/**
	 * @return banned properties list
	 */
	protected List<String> getBannedProperties() {
		return this.skipProperties.split(";") as List<String>;
	}

	/**
	 * @return build information
	 */
	@Override
	Map<String, Object> getViewModel() {
		return [
			 info: propertiesMap as HashMap<String, String>
		]
	}
}
