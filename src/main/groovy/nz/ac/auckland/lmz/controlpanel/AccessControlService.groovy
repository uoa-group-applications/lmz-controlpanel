package nz.ac.auckland.lmz.controlpanel

import groovy.transform.CompileStatic
import nz.ac.auckland.common.config.ConfigKey
import nz.ac.auckland.common.stereotypes.UniversityComponent
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import javax.inject.Inject
import javax.servlet.http.HttpServletRequest

/**
 * Author: Marnix
 *
 */
@UniversityComponent
@CompileStatic
class AccessControlService {
	private Logger log = LoggerFactory.getLogger(getClass())

	/**
	 * Get the control panel's accessgroup
	 */
	@ConfigKey("controlpanel.accessgroup")
	private String requiredAccessGroup;

	/**
	 * Determine whether the currently logged in person can access
	 * the control panel. 
	 *
	 * @return true if he can access the control panel
	 */
	public boolean canAccessControlPanel(HttpServletRequest request) {

		if (!request.remoteUser) {
			log.warn("Denying anonymous access to controlpanel")
			return false;
		}

		boolean allowed = request.isUserInRole(this.requiredAccessGroup);

		if (!allowed)
			log.warn("Denying access to controlpanel to ${request.remoteUser}")

		return allowed
	}

}
