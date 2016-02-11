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
 * Provides the local service utility for Lecturer. This utility wraps
 * {@link hu.unideb.inf.service.impl.LecturerLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Adam Kiss
 * @see LecturerLocalService
 * @see hu.unideb.inf.service.base.LecturerLocalServiceBaseImpl
 * @see hu.unideb.inf.service.impl.LecturerLocalServiceImpl
 * @generated
 */
public class LecturerLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link hu.unideb.inf.service.impl.LecturerLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the lecturer to the database. Also notifies the appropriate model listeners.
	*
	* @param lecturer the lecturer
	* @return the lecturer that was added
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Lecturer addLecturer(
		hu.unideb.inf.model.Lecturer lecturer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLecturer(lecturer);
	}

	/**
	* Creates a new lecturer with the primary key. Does not add the lecturer to the database.
	*
	* @param lecturerId the primary key for the new lecturer
	* @return the new lecturer
	*/
	public static hu.unideb.inf.model.Lecturer createLecturer(long lecturerId) {
		return getService().createLecturer(lecturerId);
	}

	/**
	* Deletes the lecturer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lecturerId the primary key of the lecturer
	* @return the lecturer that was removed
	* @throws PortalException if a lecturer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Lecturer deleteLecturer(long lecturerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLecturer(lecturerId);
	}

	/**
	* Deletes the lecturer from the database. Also notifies the appropriate model listeners.
	*
	* @param lecturer the lecturer
	* @return the lecturer that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Lecturer deleteLecturer(
		hu.unideb.inf.model.Lecturer lecturer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLecturer(lecturer);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.LecturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.LecturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static hu.unideb.inf.model.Lecturer fetchLecturer(long lecturerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLecturer(lecturerId);
	}

	/**
	* Returns the lecturer with the primary key.
	*
	* @param lecturerId the primary key of the lecturer
	* @return the lecturer
	* @throws PortalException if a lecturer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Lecturer getLecturer(long lecturerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLecturer(lecturerId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the lecturers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.LecturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lecturers
	* @param end the upper bound of the range of lecturers (not inclusive)
	* @return the range of lecturers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.Lecturer> getLecturers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLecturers(start, end);
	}

	/**
	* Returns the number of lecturers.
	*
	* @return the number of lecturers
	* @throws SystemException if a system exception occurred
	*/
	public static int getLecturersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLecturersCount();
	}

	/**
	* Updates the lecturer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lecturer the lecturer
	* @return the lecturer that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Lecturer updateLecturer(
		hu.unideb.inf.model.Lecturer lecturer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLecturer(lecturer);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addTimetableCourseLecturer(long timetableCourseId,
		long lecturerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addTimetableCourseLecturer(timetableCourseId, lecturerId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addTimetableCourseLecturer(long timetableCourseId,
		hu.unideb.inf.model.Lecturer lecturer)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addTimetableCourseLecturer(timetableCourseId, lecturer);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addTimetableCourseLecturers(long timetableCourseId,
		long[] lecturerIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addTimetableCourseLecturers(timetableCourseId, lecturerIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addTimetableCourseLecturers(long timetableCourseId,
		java.util.List<hu.unideb.inf.model.Lecturer> Lecturers)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addTimetableCourseLecturers(timetableCourseId, Lecturers);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void clearTimetableCourseLecturers(long timetableCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().clearTimetableCourseLecturers(timetableCourseId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteTimetableCourseLecturer(long timetableCourseId,
		long lecturerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTimetableCourseLecturer(timetableCourseId, lecturerId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteTimetableCourseLecturer(long timetableCourseId,
		hu.unideb.inf.model.Lecturer lecturer)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTimetableCourseLecturer(timetableCourseId, lecturer);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteTimetableCourseLecturers(long timetableCourseId,
		long[] lecturerIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteTimetableCourseLecturers(timetableCourseId, lecturerIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteTimetableCourseLecturers(long timetableCourseId,
		java.util.List<hu.unideb.inf.model.Lecturer> Lecturers)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTimetableCourseLecturers(timetableCourseId, Lecturers);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.Lecturer> getTimetableCourseLecturers(
		long timetableCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTimetableCourseLecturers(timetableCourseId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.Lecturer> getTimetableCourseLecturers(
		long timetableCourseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getTimetableCourseLecturers(timetableCourseId, start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.Lecturer> getTimetableCourseLecturers(
		long timetableCourseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getTimetableCourseLecturers(timetableCourseId, start, end,
			orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static int getTimetableCourseLecturersCount(long timetableCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTimetableCourseLecturersCount(timetableCourseId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasTimetableCourseLecturer(long timetableCourseId,
		long lecturerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .hasTimetableCourseLecturer(timetableCourseId, lecturerId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasTimetableCourseLecturers(long timetableCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasTimetableCourseLecturers(timetableCourseId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void setTimetableCourseLecturers(long timetableCourseId,
		long[] lecturerIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().setTimetableCourseLecturers(timetableCourseId, lecturerIds);
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

	public static java.util.List<hu.unideb.inf.model.Lecturer> getLecturers()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLecturers();
	}

	public static java.util.List<hu.unideb.inf.model.Lecturer> getLecturersByIds(
		long[] lecturerIds)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchLecturerException {
		return getService().getLecturersByIds(lecturerIds);
	}

	public static hu.unideb.inf.model.Lecturer getLecturerByName(
		java.lang.String lecturerName)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchLecturerException {
		return getService().getLecturerByName(lecturerName);
	}

	public static hu.unideb.inf.model.Lecturer fetchLecturerByName(
		java.lang.String lecturerName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLecturerByName(lecturerName);
	}

	public static boolean isLecturerExists(java.lang.String lecturerName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().isLecturerExists(lecturerName);
	}

	public static hu.unideb.inf.model.Lecturer addLecturer(
		java.lang.String lecturerName, long lecturerUserId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addLecturer(lecturerName, lecturerUserId, serviceContext);
	}

	public static hu.unideb.inf.model.Lecturer deleteLecturer(long lecturerId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLecturer(lecturerId, serviceContext);
	}

	public static hu.unideb.inf.model.Lecturer updateLecturer(long userId,
		long lecturerId, java.lang.String lecturerName, long lecturerUserId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateLecturer(userId, lecturerId, lecturerName,
			lecturerUserId, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static LecturerLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LecturerLocalService.class.getName());

			if (invokableLocalService instanceof LecturerLocalService) {
				_service = (LecturerLocalService)invokableLocalService;
			}
			else {
				_service = new LecturerLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(LecturerLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(LecturerLocalService service) {
	}

	private static LecturerLocalService _service;
}