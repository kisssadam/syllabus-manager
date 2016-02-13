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
 * Provides the local service utility for TimetableCourse. This utility wraps
 * {@link hu.unideb.inf.service.impl.TimetableCourseLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Adam Kiss
 * @see TimetableCourseLocalService
 * @see hu.unideb.inf.service.base.TimetableCourseLocalServiceBaseImpl
 * @see hu.unideb.inf.service.impl.TimetableCourseLocalServiceImpl
 * @generated
 */
public class TimetableCourseLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link hu.unideb.inf.service.impl.TimetableCourseLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the timetable course to the database. Also notifies the appropriate model listeners.
	*
	* @param timetableCourse the timetable course
	* @return the timetable course that was added
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.TimetableCourse addTimetableCourse(
		hu.unideb.inf.model.TimetableCourse timetableCourse)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addTimetableCourse(timetableCourse);
	}

	/**
	* Creates a new timetable course with the primary key. Does not add the timetable course to the database.
	*
	* @param timetableCourseId the primary key for the new timetable course
	* @return the new timetable course
	*/
	public static hu.unideb.inf.model.TimetableCourse createTimetableCourse(
		long timetableCourseId) {
		return getService().createTimetableCourse(timetableCourseId);
	}

	/**
	* Deletes the timetable course with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param timetableCourseId the primary key of the timetable course
	* @return the timetable course that was removed
	* @throws PortalException if a timetable course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.TimetableCourse deleteTimetableCourse(
		long timetableCourseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTimetableCourse(timetableCourseId);
	}

	/**
	* Deletes the timetable course from the database. Also notifies the appropriate model listeners.
	*
	* @param timetableCourse the timetable course
	* @return the timetable course that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.TimetableCourse deleteTimetableCourse(
		hu.unideb.inf.model.TimetableCourse timetableCourse)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTimetableCourse(timetableCourse);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static hu.unideb.inf.model.TimetableCourse fetchTimetableCourse(
		long timetableCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchTimetableCourse(timetableCourseId);
	}

	/**
	* Returns the timetable course with the primary key.
	*
	* @param timetableCourseId the primary key of the timetable course
	* @return the timetable course
	* @throws PortalException if a timetable course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.TimetableCourse getTimetableCourse(
		long timetableCourseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTimetableCourse(timetableCourseId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the timetable courses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of timetable courses
	* @param end the upper bound of the range of timetable courses (not inclusive)
	* @return the range of timetable courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCourses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTimetableCourses(start, end);
	}

	/**
	* Returns the number of timetable courses.
	*
	* @return the number of timetable courses
	* @throws SystemException if a system exception occurred
	*/
	public static int getTimetableCoursesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTimetableCoursesCount();
	}

	/**
	* Updates the timetable course in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param timetableCourse the timetable course
	* @return the timetable course that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.TimetableCourse updateTimetableCourse(
		hu.unideb.inf.model.TimetableCourse timetableCourse)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTimetableCourse(timetableCourse);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addLecturerTimetableCourse(long lecturerId,
		long timetableCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addLecturerTimetableCourse(lecturerId, timetableCourseId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addLecturerTimetableCourse(long lecturerId,
		hu.unideb.inf.model.TimetableCourse timetableCourse)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addLecturerTimetableCourse(lecturerId, timetableCourse);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addLecturerTimetableCourses(long lecturerId,
		long[] timetableCourseIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addLecturerTimetableCourses(lecturerId, timetableCourseIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addLecturerTimetableCourses(long lecturerId,
		java.util.List<hu.unideb.inf.model.TimetableCourse> TimetableCourses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addLecturerTimetableCourses(lecturerId, TimetableCourses);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void clearLecturerTimetableCourses(long lecturerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().clearLecturerTimetableCourses(lecturerId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLecturerTimetableCourse(long lecturerId,
		long timetableCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteLecturerTimetableCourse(lecturerId, timetableCourseId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLecturerTimetableCourse(long lecturerId,
		hu.unideb.inf.model.TimetableCourse timetableCourse)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteLecturerTimetableCourse(lecturerId, timetableCourse);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLecturerTimetableCourses(long lecturerId,
		long[] timetableCourseIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteLecturerTimetableCourses(lecturerId, timetableCourseIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLecturerTimetableCourses(long lecturerId,
		java.util.List<hu.unideb.inf.model.TimetableCourse> TimetableCourses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteLecturerTimetableCourses(lecturerId, TimetableCourses);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getLecturerTimetableCourses(
		long lecturerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLecturerTimetableCourses(lecturerId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getLecturerTimetableCourses(
		long lecturerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLecturerTimetableCourses(lecturerId, start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getLecturerTimetableCourses(
		long lecturerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getLecturerTimetableCourses(lecturerId, start, end,
			orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static int getLecturerTimetableCoursesCount(long lecturerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLecturerTimetableCoursesCount(lecturerId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasLecturerTimetableCourse(long lecturerId,
		long timetableCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .hasLecturerTimetableCourse(lecturerId, timetableCourseId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasLecturerTimetableCourses(long lecturerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasLecturerTimetableCourses(lecturerId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void setLecturerTimetableCourses(long lecturerId,
		long[] timetableCourseIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().setLecturerTimetableCourses(lecturerId, timetableCourseIds);
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

	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCourses()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTimetableCourses();
	}

	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCoursesBySemesterId(
		long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTimetableCoursesBySemesterId(semesterId);
	}

	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCoursesBySemesterId(
		long semesterId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getTimetableCoursesBySemesterId(semesterId, start, end);
	}

	public static int getTimetableCoursesCountBySemesterId(long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTimetableCoursesCountBySemesterId(semesterId);
	}

	public static hu.unideb.inf.model.TimetableCourse findTimetableCourseByTimetableCourseCode(
		java.lang.String timetableCourseCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchTimetableCourseException {
		return getService()
				   .findTimetableCourseByTimetableCourseCode(timetableCourseCode);
	}

	public static hu.unideb.inf.model.TimetableCourse fetchTimetableCourseByTimetableCourseCode(
		java.lang.String timetableCourseCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchTimetableCourseByTimetableCourseCode(timetableCourseCode);
	}

	public static hu.unideb.inf.model.TimetableCourse getTimetableCourseByC_S(
		long courseId, long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchTimetableCourseException {
		return getService().getTimetableCourseByC_S(courseId, semesterId);
	}

	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCourseByCourseId(
		long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTimetableCourseByCourseId(courseId);
	}

	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCourseByCourseId(
		long courseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTimetableCourseByCourseId(courseId, start, end);
	}

	public static int getTimetableCourseByCourseIdCount(long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTimetableCourseByCourseIdCount(courseId);
	}

	public static java.util.List<hu.unideb.inf.model.Lecturer> getLecutersByTimetableCourseId(
		long timetableCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLecutersByTimetableCourseId(timetableCourseId);
	}

	public static hu.unideb.inf.model.TimetableCourse addTimetableCourse(
		long courseId, long semesterId, java.lang.String timetableCourseCode,
		java.lang.String subjectType, int recommendedTerm, int limit,
		long[] lecturerIds, java.lang.String classScheduleInfo,
		java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addTimetableCourse(courseId, semesterId,
			timetableCourseCode, subjectType, recommendedTerm, limit,
			lecturerIds, classScheduleInfo, description, serviceContext);
	}

	public static hu.unideb.inf.model.TimetableCourse updateTimetableCourse(
		long userId, long timetableCourseId, long courseId, long semesterId,
		java.lang.String timetableCourseCode, java.lang.String subjectType,
		int recommendedTerm, int limit, long[] lecturerIds,
		java.lang.String classScheduleInfo, java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateTimetableCourse(userId, timetableCourseId, courseId,
			semesterId, timetableCourseCode, subjectType, recommendedTerm,
			limit, lecturerIds, classScheduleInfo, description, serviceContext);
	}

	public static hu.unideb.inf.model.TimetableCourse deleteTimetableCourse(
		long timetableCourseId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteTimetableCourse(timetableCourseId, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static TimetableCourseLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TimetableCourseLocalService.class.getName());

			if (invokableLocalService instanceof TimetableCourseLocalService) {
				_service = (TimetableCourseLocalService)invokableLocalService;
			}
			else {
				_service = new TimetableCourseLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(TimetableCourseLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(TimetableCourseLocalService service) {
	}

	private static TimetableCourseLocalService _service;
}