package hu.unideb.inf.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import hu.unideb.inf.model.TimetableCourse;
import hu.unideb.inf.service.TimetableCourseLocalServiceUtil;

public class TimetableCoursePermission {

	public static void check(PermissionChecker permissionChecker, long timetableCourseId, String actionId)
			throws PortalException, SystemException {

		if (!contains(permissionChecker, timetableCourseId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, long timetableCourseId, String actionId)
			throws PortalException, SystemException {

		TimetableCourse timetableCourse = TimetableCourseLocalServiceUtil.getTimetableCourse(timetableCourseId);

		return permissionChecker.hasPermission(timetableCourse.getGroupId(), TimetableCourse.class.getName(),
				timetableCourse.getTimetableCourseId(), actionId);
	}

}
