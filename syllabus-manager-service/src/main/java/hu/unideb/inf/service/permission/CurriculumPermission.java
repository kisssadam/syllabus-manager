package hu.unideb.inf.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import hu.unideb.inf.model.Curriculum;
import hu.unideb.inf.service.CurriculumLocalServiceUtil;

public class CurriculumPermission {

	public static void check(PermissionChecker permissionChecker, long curriculumId, String actionId)
			throws PortalException, SystemException {

		if (!contains(permissionChecker, curriculumId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, long curriculumId, String actionId)
			throws PortalException, SystemException {

		Curriculum curriculum = CurriculumLocalServiceUtil.getCurriculum(curriculumId);

		return permissionChecker.hasPermission(curriculum.getGroupId(), Curriculum.class.getName(),
				curriculum.getCurriculumId(), actionId);

	}
}
