package hu.unideb.inf.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import hu.unideb.inf.model.Syllabus;
import hu.unideb.inf.service.SyllabusLocalServiceUtil;

public class SyllabusPermission {

	public static void check(PermissionChecker permissionChecker, long syllabusId, String actionId)
			throws PortalException, SystemException {

		if (!contains(permissionChecker, syllabusId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, long syllabusId, String actionId)
			throws PortalException, SystemException {

		Syllabus syllabus = SyllabusLocalServiceUtil.getSyllabus(syllabusId);

		return permissionChecker.hasPermission(syllabus.getGroupId(), Syllabus.class.getName(),
				syllabus.getSyllabusId(), actionId);
	}

}
