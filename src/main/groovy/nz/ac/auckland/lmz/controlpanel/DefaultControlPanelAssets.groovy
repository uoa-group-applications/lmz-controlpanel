package nz.ac.auckland.lmz.controlpanel

import groovy.transform.CompileStatic
import net.stickycode.stereotype.configured.PostConfigured
import nz.ac.auckland.common.config.ConfigKey
import nz.ac.auckland.common.stereotypes.UniversityComponent
import nz.ac.auckland.lmz.controlpanel.core.ControlPanelAssets
import nz.ac.auckland.stencil.LinkBuilder

import javax.annotation.PostConstruct
import javax.inject.Inject

/**
 * Author: Marnix
 *
 * Default control panel assets that are available to the user
 */
@UniversityComponent
@CompileStatic
class DefaultControlPanelAssets extends ControlPanelAssets {

	@Inject LinkBuilder linkBuilder

	@PostConstruct
	public void init(){
		this.javascripts = [
				linkBuilder.linkTo('app-resources/global.js'),
				linkBuilder.linkTo('app-resources/session.js')
		];
	}


}
