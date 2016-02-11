package hu.unideb.inf.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

import hu.unideb.inf.model.Lecturer;
import hu.unideb.inf.service.LecturerLocalServiceUtil;

public class LecturerPermission {

	public static void check(PermissionChecker permissionChecker, long lecturerId, String actionId)
			throws PortalException, SystemException {

		if (!contains(permissionChecker, lecturerId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, long lecturerId, String actionId)
			throws PortalException, SystemException {

		Lecturer lecturer = LecturerLocalServiceUtil.getLecturer(lecturerId);

		return permissionChecker.hasPermission(lecturer.getGroupId(), Lecturer.class.getName(),
				lecturer.getLecturerId(), actionId);
	}
}
