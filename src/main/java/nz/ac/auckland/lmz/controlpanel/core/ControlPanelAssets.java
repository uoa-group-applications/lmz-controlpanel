package nz.ac.auckland.lmz.controlpanel.core;

import java.util.List;

/**
 * Author: Marnix
 */
public class ControlPanelAssets {

	/**
	 * A list of embedded control panel assets that are to be loaded before these
	 * (non-recursive).
	 */
	private List<ControlPanelAssets> embeds;

	/**
	 * A list of stylesheets that should be loaded
	 */
	private List<String> stylesheets;

	/**
	 * A list of javascripts that should be loaded
	 */
	private List<String> javascripts;

	// -------------------------------------------------------------------------------------
	//      Getters and setters
	// -------------------------------------------------------------------------------------

	public List<ControlPanelAssets> getEmbeds() {
		return embeds;
	}

	public void setEmbeds(List<ControlPanelAssets> embeds) {
		this.embeds = embeds;
	}

	public List<String> getStylesheets() {
		return stylesheets;
	}

	public void setStylesheets(List<String> stylesheets) {
		this.stylesheets = stylesheets;
	}

	public List<String> getJavascripts() {
		return javascripts;
	}

	public void setJavascripts(List<String> javascripts) {
		this.javascripts = javascripts;
	}
}
