package nz.ac.auckland.lmz.controlpanel.core;

/**
 * Author: Marnix
 *
 * Contains information about a control panel
 */
public class ControlPanelMetadata {

	/**
	 * The human-readable title of this control panel
	 */
	private String title;

	/**
	 * A description of this control panel
	 */
	private String description;

	/**
	 * The URI at which this is found
	 */
	private String uri;

	/**
	 * The position at which the element is found
	 */
	private int position;

	/**
	 * Description of the assets
	 */
	private ControlPanelAssets assets;

	// ------------------------------------------------------------------
	//      Getters and setters
	// ------------------------------------------------------------------

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public ControlPanelAssets getAssets() {
		return assets;
	}

	public void setAssets(ControlPanelAssets assets) {
		this.assets = assets;
	}
}
