package hu.unideb.inf.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import hu.unideb.inf.model.Semester;
import hu.unideb.inf.service.SemesterLocalServiceUtil;

public class SemesterPermission {

	public static void check(PermissionChecker permissionChecker, long semesterId, String actionId)
			throws PortalException, SystemException {

		if (!contains(permissionChecker, semesterId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, long semesterId, String actionId)
			throws PortalException, SystemException {

		Semester semester = SemesterLocalServiceUtil.getSemester(semesterId);

		return permissionChecker.hasPermission(semester.getGroupId(), Semester.class.getName(),
				semester.getSemesterId(), actionId);

	}
}
