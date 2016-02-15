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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TimetableCourseLocalService}.
 *
 * @author Adam Kiss
 * @see TimetableCourseLocalService
 * @generated
 */
public class TimetableCourseLocalServiceWrapper
	implements TimetableCourseLocalService,
		ServiceWrapper<TimetableCourseLocalService> {
	public TimetableCourseLocalServiceWrapper(
		TimetableCourseLocalService timetableCourseLocalService) {
		_timetableCourseLocalService = timetableCourseLocalService;
	}

	/**
	* Adds the timetable course to the database. Also notifies the appropriate model listeners.
	*
	* @param timetableCourse the timetable course
	* @return the timetable course that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.unideb.inf.model.TimetableCourse addTimetableCourse(
		hu.unideb.inf.model.TimetableCourse timetableCourse)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.addTimetableCourse(timetableCourse);
	}

	/**
	* Creates a new timetable course with the primary key. Does not add the timetable course to the database.
	*
	* @param timetableCourseId the primary key for the new timetable course
	* @return the new timetable course
	*/
	@Override
	public hu.unideb.inf.model.TimetableCourse createTimetableCourse(
		long timetableCourseId) {
		return _timetableCourseLocalService.createTimetableCourse(timetableCourseId);
	}

	/**
	* Deletes the timetable course with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param timetableCourseId the primary key of the timetable course
	* @return the timetable course that was removed
	* @throws PortalException if a timetable course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.unideb.inf.model.TimetableCourse deleteTimetableCourse(
		long timetableCourseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.deleteTimetableCourse(timetableCourseId);
	}

	/**
	* Deletes the timetable course from the database. Also notifies the appropriate model listeners.
	*
	* @param timetableCourse the timetable course
	* @return the timetable course that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.unideb.inf.model.TimetableCourse deleteTimetableCourse(
		hu.unideb.inf.model.TimetableCourse timetableCourse)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.deleteTimetableCourse(timetableCourse);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _timetableCourseLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public hu.unideb.inf.model.TimetableCourse fetchTimetableCourse(
		long timetableCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.fetchTimetableCourse(timetableCourseId);
	}

	/**
	* Returns the timetable course with the primary key.
	*
	* @param timetableCourseId the primary key of the timetable course
	* @return the timetable course
	* @throws PortalException if a timetable course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.unideb.inf.model.TimetableCourse getTimetableCourse(
		long timetableCourseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.getTimetableCourse(timetableCourseId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCourses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.getTimetableCourses(start, end);
	}

	/**
	* Returns the number of timetable courses.
	*
	* @return the number of timetable courses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTimetableCoursesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.getTimetableCoursesCount();
	}

	/**
	* Updates the timetable course in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param timetableCourse the timetable course
	* @return the timetable course that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.unideb.inf.model.TimetableCourse updateTimetableCourse(
		hu.unideb.inf.model.TimetableCourse timetableCourse)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.updateTimetableCourse(timetableCourse);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addLecturerTimetableCourse(long lecturerId,
		long timetableCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_timetableCourseLocalService.addLecturerTimetableCourse(lecturerId,
			timetableCourseId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addLecturerTimetableCourse(long lecturerId,
		hu.unideb.inf.model.TimetableCourse timetableCourse)
		throws com.liferay.portal.kernel.exception.SystemException {
		_timetableCourseLocalService.addLecturerTimetableCourse(lecturerId,
			timetableCourse);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addLecturerTimetableCourses(long lecturerId,
		long[] timetableCourseIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_timetableCourseLocalService.addLecturerTimetableCourses(lecturerId,
			timetableCourseIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addLecturerTimetableCourses(long lecturerId,
		java.util.List<hu.unideb.inf.model.TimetableCourse> TimetableCourses)
		throws com.liferay.portal.kernel.exception.SystemException {
		_timetableCourseLocalService.addLecturerTimetableCourses(lecturerId,
			TimetableCourses);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void clearLecturerTimetableCourses(long lecturerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_timetableCourseLocalService.clearLecturerTimetableCourses(lecturerId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteLecturerTimetableCourse(long lecturerId,
		long timetableCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_timetableCourseLocalService.deleteLecturerTimetableCourse(lecturerId,
			timetableCourseId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteLecturerTimetableCourse(long lecturerId,
		hu.unideb.inf.model.TimetableCourse timetableCourse)
		throws com.liferay.portal.kernel.exception.SystemException {
		_timetableCourseLocalService.deleteLecturerTimetableCourse(lecturerId,
			timetableCourse);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteLecturerTimetableCourses(long lecturerId,
		long[] timetableCourseIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_timetableCourseLocalService.deleteLecturerTimetableCourses(lecturerId,
			timetableCourseIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteLecturerTimetableCourses(long lecturerId,
		java.util.List<hu.unideb.inf.model.TimetableCourse> TimetableCourses)
		throws com.liferay.portal.kernel.exception.SystemException {
		_timetableCourseLocalService.deleteLecturerTimetableCourses(lecturerId,
			TimetableCourses);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<hu.unideb.inf.model.TimetableCourse> getLecturerTimetableCourses(
		long lecturerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.getLecturerTimetableCourses(lecturerId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<hu.unideb.inf.model.TimetableCourse> getLecturerTimetableCourses(
		long lecturerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.getLecturerTimetableCourses(lecturerId,
			start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<hu.unideb.inf.model.TimetableCourse> getLecturerTimetableCourses(
		long lecturerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.getLecturerTimetableCourses(lecturerId,
			start, end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLecturerTimetableCoursesCount(long lecturerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.getLecturerTimetableCoursesCount(lecturerId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasLecturerTimetableCourse(long lecturerId,
		long timetableCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.hasLecturerTimetableCourse(lecturerId,
			timetableCourseId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasLecturerTimetableCourses(long lecturerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.hasLecturerTimetableCourses(lecturerId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void setLecturerTimetableCourses(long lecturerId,
		long[] timetableCourseIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_timetableCourseLocalService.setLecturerTimetableCourses(lecturerId,
			timetableCourseIds);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _timetableCourseLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_timetableCourseLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _timetableCourseLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCourses()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.getTimetableCourses();
	}

	@Override
	public java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCoursesBySemesterId(
		long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.getTimetableCoursesBySemesterId(semesterId);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCoursesBySemesterId(
		long semesterId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.getTimetableCoursesBySemesterId(semesterId,
			start, end);
	}

	@Override
	public int getTimetableCoursesCountBySemesterId(long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.getTimetableCoursesCountBySemesterId(semesterId);
	}

	@Override
	public hu.unideb.inf.model.TimetableCourse fetchTimetableCourseByC_S_T_S(
		long courseId, long semesterId, java.lang.String timetableCourseCode,
		java.lang.String subjectType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.fetchTimetableCourseByC_S_T_S(courseId,
			semesterId, timetableCourseCode, subjectType);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCoursesByC_S(
		long courseId, long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchTimetableCourseException {
		return _timetableCourseLocalService.getTimetableCoursesByC_S(courseId,
			semesterId);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCoursesByCourseId(
		long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.getTimetableCoursesByCourseId(courseId);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCoursesByCourseId(
		long courseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.getTimetableCoursesByCourseId(courseId,
			start, end);
	}

	@Override
	public int getTimetableCourseCountByCourseId(long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.getTimetableCourseCountByCourseId(courseId);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.Lecturer> getLecutersByTimetableCourseId(
		long timetableCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.getLecutersByTimetableCourseId(timetableCourseId);
	}

	@Override
	public hu.unideb.inf.model.TimetableCourse addTimetableCourse(
		long courseId, long semesterId, java.lang.String timetableCourseCode,
		java.lang.String subjectType, int recommendedTerm, int limit,
		long[] lecturerIds, java.lang.String classScheduleInfo,
		java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.addTimetableCourse(courseId,
			semesterId, timetableCourseCode, subjectType, recommendedTerm,
			limit, lecturerIds, classScheduleInfo, description, serviceContext);
	}

	@Override
	public hu.unideb.inf.model.TimetableCourse updateTimetableCourse(
		long userId, long timetableCourseId, long courseId, long semesterId,
		java.lang.String timetableCourseCode, java.lang.String subjectType,
		int recommendedTerm, int limit, long[] lecturerIds,
		java.lang.String classScheduleInfo, java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.updateTimetableCourse(userId,
			timetableCourseId, courseId, semesterId, timetableCourseCode,
			subjectType, recommendedTerm, limit, lecturerIds,
			classScheduleInfo, description, serviceContext);
	}

	@Override
	public hu.unideb.inf.model.TimetableCourse deleteTimetableCourse(
		long timetableCourseId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.deleteTimetableCourse(timetableCourseId,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TimetableCourseLocalService getWrappedTimetableCourseLocalService() {
		return _timetableCourseLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTimetableCourseLocalService(
		TimetableCourseLocalService timetableCourseLocalService) {
		_timetableCourseLocalService = timetableCourseLocalService;
	}

	@Override
	public TimetableCourseLocalService getWrappedService() {
		return _timetableCourseLocalService;
	}

	@Override
	public void setWrappedService(
		TimetableCourseLocalService timetableCourseLocalService) {
		_timetableCourseLocalService = timetableCourseLocalService;
	}

	private TimetableCourseLocalService _timetableCourseLocalService;
}