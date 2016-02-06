/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package hu.unideb.inf.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Semester. This utility wraps
 * {@link hu.unideb.inf.service.impl.SemesterLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Adam Kiss
 * @see SemesterLocalService
 * @see hu.unideb.inf.service.base.SemesterLocalServiceBaseImpl
 * @see hu.unideb.inf.service.impl.SemesterLocalServiceImpl
 * @generated
 */
public class SemesterLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link hu.unideb.inf.service.impl.SemesterLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the semester to the database. Also notifies the appropriate model listeners.
	*
	* @param semester the semester
	* @return the semester that was added
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Semester addSemester(
		hu.unideb.inf.model.Semester semester)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSemester(semester);
	}

	/**
	* Creates a new semester with the primary key. Does not add the semester to the database.
	*
	* @param semesterId the primary key for the new semester
	* @return the new semester
	*/
	public static hu.unideb.inf.model.Semester createSemester(long semesterId) {
		return getService().createSemester(semesterId);
	}

	/**
	* Deletes the semester with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param semesterId the primary key of the semester
	* @return the semester that was removed
	* @throws PortalException if a semester with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Semester deleteSemester(long semesterId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSemester(semesterId);
	}

	/**
	* Deletes the semester from the database. Also notifies the appropriate model listeners.
	*
	* @param semester the semester
	* @return the semester that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Semester deleteSemester(
		hu.unideb.inf.model.Semester semester)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSemester(semester);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.SemesterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.SemesterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static hu.unideb.inf.model.Semester fetchSemester(long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSemester(semesterId);
	}

	/**
	* Returns the semester with the primary key.
	*
	* @param semesterId the primary key of the semester
	* @return the semester
	* @throws PortalException if a semester with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Semester getSemester(long semesterId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSemester(semesterId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the semesters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.SemesterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of semesters
	* @param end the upper bound of the range of semesters (not inclusive)
	* @return the range of semesters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.Semester> getSemesters(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSemesters(start, end);
	}

	/**
	* Returns the number of semesters.
	*
	* @return the number of semesters
	* @throws SystemException if a system exception occurred
	*/
	public static int getSemestersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSemestersCount();
	}

	/**
	* Updates the semester in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param semester the semester
	* @return the semester that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Semester updateSemester(
		hu.unideb.inf.model.Semester semester)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSemester(semester);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<hu.unideb.inf.model.Semester> getSemesters()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSemesters();
	}

	public static hu.unideb.inf.model.Semester getSemesterByB_E_D(
		int beginYear, int endYear, int division)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchSemesterException {
		return getService().getSemesterByB_E_D(beginYear, endYear, division);
	}

	public static hu.unideb.inf.model.Semester getLatestSemester()
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchSemesterException {
		return getService().getLatestSemester();
	}

	public static hu.unideb.inf.model.Semester addNextSemester(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addNextSemester(serviceContext);
	}

	public static hu.unideb.inf.model.Semester addCurrentSemester(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addCurrentSemester(serviceContext);
	}

	public static hu.unideb.inf.model.Semester addSemester(int beginYear,
		int endYear, int division,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addSemester(beginYear, endYear, division, serviceContext);
	}

	public static hu.unideb.inf.model.Semester deleteSemester(long semesterId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSemester(semesterId, serviceContext);
	}

	public static hu.unideb.inf.model.Semester updateSemester(long userId,
		long semesterId, int beginYear, int endYear, int division,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateSemester(userId, semesterId, beginYear, endYear,
			division, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static SemesterLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SemesterLocalService.class.getName());

			if (invokableLocalService instanceof SemesterLocalService) {
				_service = (SemesterLocalService)invokableLocalService;
			}
			else {
				_service = new SemesterLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SemesterLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SemesterLocalService service) {
	}

	private static SemesterLocalService _service;
}