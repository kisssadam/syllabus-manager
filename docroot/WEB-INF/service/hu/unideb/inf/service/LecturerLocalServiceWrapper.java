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
 * Provides a wrapper for {@link LecturerLocalService}.
 *
 * @author Adam Kiss
 * @see LecturerLocalService
 * @generated
 */
public class LecturerLocalServiceWrapper implements LecturerLocalService,
	ServiceWrapper<LecturerLocalService> {
	public LecturerLocalServiceWrapper(
		LecturerLocalService lecturerLocalService) {
		_lecturerLocalService = lecturerLocalService;
	}

	/**
	* Adds the lecturer to the database. Also notifies the appropriate model listeners.
	*
	* @param lecturer the lecturer
	* @return the lecturer that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.unideb.inf.model.Lecturer addLecturer(
		hu.unideb.inf.model.Lecturer lecturer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lecturerLocalService.addLecturer(lecturer);
	}

	/**
	* Creates a new lecturer with the primary key. Does not add the lecturer to the database.
	*
	* @param lecturerId the primary key for the new lecturer
	* @return the new lecturer
	*/
	@Override
	public hu.unideb.inf.model.Lecturer createLecturer(long lecturerId) {
		return _lecturerLocalService.createLecturer(lecturerId);
	}

	/**
	* Deletes the lecturer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lecturerId the primary key of the lecturer
	* @return the lecturer that was removed
	* @throws PortalException if a lecturer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.unideb.inf.model.Lecturer deleteLecturer(long lecturerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lecturerLocalService.deleteLecturer(lecturerId);
	}

	/**
	* Deletes the lecturer from the database. Also notifies the appropriate model listeners.
	*
	* @param lecturer the lecturer
	* @return the lecturer that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.unideb.inf.model.Lecturer deleteLecturer(
		hu.unideb.inf.model.Lecturer lecturer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lecturerLocalService.deleteLecturer(lecturer);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _lecturerLocalService.dynamicQuery();
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
		return _lecturerLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _lecturerLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lecturerLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _lecturerLocalService.dynamicQueryCount(dynamicQuery);
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
		return _lecturerLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public hu.unideb.inf.model.Lecturer fetchLecturer(long lecturerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lecturerLocalService.fetchLecturer(lecturerId);
	}

	/**
	* Returns the lecturer with the primary key.
	*
	* @param lecturerId the primary key of the lecturer
	* @return the lecturer
	* @throws PortalException if a lecturer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.unideb.inf.model.Lecturer getLecturer(long lecturerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lecturerLocalService.getLecturer(lecturerId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lecturerLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<hu.unideb.inf.model.Lecturer> getLecturers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lecturerLocalService.getLecturers(start, end);
	}

	/**
	* Returns the number of lecturers.
	*
	* @return the number of lecturers
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLecturersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lecturerLocalService.getLecturersCount();
	}

	/**
	* Updates the lecturer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lecturer the lecturer
	* @return the lecturer that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.unideb.inf.model.Lecturer updateLecturer(
		hu.unideb.inf.model.Lecturer lecturer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lecturerLocalService.updateLecturer(lecturer);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addTimetableCourseLecturer(long timetableCourseId,
		long lecturerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_lecturerLocalService.addTimetableCourseLecturer(timetableCourseId,
			lecturerId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addTimetableCourseLecturer(long timetableCourseId,
		hu.unideb.inf.model.Lecturer lecturer)
		throws com.liferay.portal.kernel.exception.SystemException {
		_lecturerLocalService.addTimetableCourseLecturer(timetableCourseId,
			lecturer);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addTimetableCourseLecturers(long timetableCourseId,
		long[] lecturerIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_lecturerLocalService.addTimetableCourseLecturers(timetableCourseId,
			lecturerIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addTimetableCourseLecturers(long timetableCourseId,
		java.util.List<hu.unideb.inf.model.Lecturer> Lecturers)
		throws com.liferay.portal.kernel.exception.SystemException {
		_lecturerLocalService.addTimetableCourseLecturers(timetableCourseId,
			Lecturers);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void clearTimetableCourseLecturers(long timetableCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_lecturerLocalService.clearTimetableCourseLecturers(timetableCourseId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteTimetableCourseLecturer(long timetableCourseId,
		long lecturerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_lecturerLocalService.deleteTimetableCourseLecturer(timetableCourseId,
			lecturerId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteTimetableCourseLecturer(long timetableCourseId,
		hu.unideb.inf.model.Lecturer lecturer)
		throws com.liferay.portal.kernel.exception.SystemException {
		_lecturerLocalService.deleteTimetableCourseLecturer(timetableCourseId,
			lecturer);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteTimetableCourseLecturers(long timetableCourseId,
		long[] lecturerIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_lecturerLocalService.deleteTimetableCourseLecturers(timetableCourseId,
			lecturerIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteTimetableCourseLecturers(long timetableCourseId,
		java.util.List<hu.unideb.inf.model.Lecturer> Lecturers)
		throws com.liferay.portal.kernel.exception.SystemException {
		_lecturerLocalService.deleteTimetableCourseLecturers(timetableCourseId,
			Lecturers);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<hu.unideb.inf.model.Lecturer> getTimetableCourseLecturers(
		long timetableCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lecturerLocalService.getTimetableCourseLecturers(timetableCourseId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<hu.unideb.inf.model.Lecturer> getTimetableCourseLecturers(
		long timetableCourseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lecturerLocalService.getTimetableCourseLecturers(timetableCourseId,
			start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<hu.unideb.inf.model.Lecturer> getTimetableCourseLecturers(
		long timetableCourseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lecturerLocalService.getTimetableCourseLecturers(timetableCourseId,
			start, end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTimetableCourseLecturersCount(long timetableCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lecturerLocalService.getTimetableCourseLecturersCount(timetableCourseId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasTimetableCourseLecturer(long timetableCourseId,
		long lecturerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lecturerLocalService.hasTimetableCourseLecturer(timetableCourseId,
			lecturerId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasTimetableCourseLecturers(long timetableCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lecturerLocalService.hasTimetableCourseLecturers(timetableCourseId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void setTimetableCourseLecturers(long timetableCourseId,
		long[] lecturerIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_lecturerLocalService.setTimetableCourseLecturers(timetableCourseId,
			lecturerIds);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _lecturerLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_lecturerLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _lecturerLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LecturerLocalService getWrappedLecturerLocalService() {
		return _lecturerLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLecturerLocalService(
		LecturerLocalService lecturerLocalService) {
		_lecturerLocalService = lecturerLocalService;
	}

	@Override
	public LecturerLocalService getWrappedService() {
		return _lecturerLocalService;
	}

	@Override
	public void setWrappedService(LecturerLocalService lecturerLocalService) {
		_lecturerLocalService = lecturerLocalService;
	}

	private LecturerLocalService _lecturerLocalService;
}