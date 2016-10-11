package hu.unideb.inf.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import hu.unideb.inf.model.Course;
import hu.unideb.inf.service.CourseLocalServiceUtil;

public class CoursePermission {

	public static void check(PermissionChecker permissionChecker, long courseId, String actionId)
			throws PortalException, SystemException {

		if (!contains(permissionChecker, courseId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, long courseId, String actionId)
			throws PortalException, SystemException {

		Course course = CourseLocalServiceUtil.getCourse(courseId);

		return permissionChecker.hasPermission(course.getGroupId(), Course.class.getName(), course.getCourseId(),
				actionId);
	}

}
