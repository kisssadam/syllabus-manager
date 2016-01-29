package hu.unideb.inf.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

import hu.unideb.inf.model.Subject;
import hu.unideb.inf.service.SubjectLocalServiceUtil;

public class SubjectPermission {

	public static void check(PermissionChecker permissionChecker, long subjectId, String actionId)
			throws PortalException, SystemException {

		if (!contains(permissionChecker, subjectId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, long subjectId, String actionId)
			throws PortalException, SystemException {

		Subject subject = SubjectLocalServiceUtil.getSubject(subjectId);

		return permissionChecker.hasPermission(subject.getGroupId(), Subject.class.getName(), subject.getSubjectId(),
				actionId);

	}
}
