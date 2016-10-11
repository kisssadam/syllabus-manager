package hu.unideb.inf.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import hu.unideb.inf.model.CourseType;
import hu.unideb.inf.service.CourseTypeLocalServiceUtil;

public class CourseTypePermission {

	public static void check(PermissionChecker permissionChecker, long courseTypeId, String actionId)
			throws PortalException, SystemException {

		if (!contains(permissionChecker, courseTypeId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, long courseTypeId, String actionId)
			throws PortalException, SystemException {

		CourseType courseType = CourseTypeLocalServiceUtil.getCourseType(courseTypeId);

		return permissionChecker.hasPermission(courseType.getGroupId(), CourseType.class.getName(),
				courseType.getCourseTypeId(), actionId);
	}

}
