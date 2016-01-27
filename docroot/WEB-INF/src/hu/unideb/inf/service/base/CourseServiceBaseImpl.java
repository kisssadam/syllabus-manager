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

package hu.unideb.inf.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import hu.unideb.inf.model.Course;
import hu.unideb.inf.service.CourseService;
import hu.unideb.inf.service.persistence.CoursePersistence;
import hu.unideb.inf.service.persistence.CourseTypePersistence;
import hu.unideb.inf.service.persistence.CurriculumPersistence;
import hu.unideb.inf.service.persistence.SubjectPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the course remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link hu.unideb.inf.service.impl.CourseServiceImpl}.
 * </p>
 *
 * @author Adam Kiss
 * @see hu.unideb.inf.service.impl.CourseServiceImpl
 * @see hu.unideb.inf.service.CourseServiceUtil
 * @generated
 */
public abstract class CourseServiceBaseImpl extends BaseServiceImpl
	implements CourseService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link hu.unideb.inf.service.CourseServiceUtil} to access the course remote service.
	 */

	/**
	 * Returns the course local service.
	 *
	 * @return the course local service
	 */
	public hu.unideb.inf.service.CourseLocalService getCourseLocalService() {
		return courseLocalService;
	}

	/**
	 * Sets the course local service.
	 *
	 * @param courseLocalService the course local service
	 */
	public void setCourseLocalService(
		hu.unideb.inf.service.CourseLocalService courseLocalService) {
		this.courseLocalService = courseLocalService;
	}

	/**
	 * Returns the course remote service.
	 *
	 * @return the course remote service
	 */
	public hu.unideb.inf.service.CourseService getCourseService() {
		return courseService;
	}

	/**
	 * Sets the course remote service.
	 *
	 * @param courseService the course remote service
	 */
	public void setCourseService(
		hu.unideb.inf.service.CourseService courseService) {
		this.courseService = courseService;
	}

	/**
	 * Returns the course persistence.
	 *
	 * @return the course persistence
	 */
	public CoursePersistence getCoursePersistence() {
		return coursePersistence;
	}

	/**
	 * Sets the course persistence.
	 *
	 * @param coursePersistence the course persistence
	 */
	public void setCoursePersistence(CoursePersistence coursePersistence) {
		this.coursePersistence = coursePersistence;
	}

	/**
	 * Returns the course type local service.
	 *
	 * @return the course type local service
	 */
	public hu.unideb.inf.service.CourseTypeLocalService getCourseTypeLocalService() {
		return courseTypeLocalService;
	}

	/**
	 * Sets the course type local service.
	 *
	 * @param courseTypeLocalService the course type local service
	 */
	public void setCourseTypeLocalService(
		hu.unideb.inf.service.CourseTypeLocalService courseTypeLocalService) {
		this.courseTypeLocalService = courseTypeLocalService;
	}

	/**
	 * Returns the course type remote service.
	 *
	 * @return the course type remote service
	 */
	public hu.unideb.inf.service.CourseTypeService getCourseTypeService() {
		return courseTypeService;
	}

	/**
	 * Sets the course type remote service.
	 *
	 * @param courseTypeService the course type remote service
	 */
	public void setCourseTypeService(
		hu.unideb.inf.service.CourseTypeService courseTypeService) {
		this.courseTypeService = courseTypeService;
	}

	/**
	 * Returns the course type persistence.
	 *
	 * @return the course type persistence
	 */
	public CourseTypePersistence getCourseTypePersistence() {
		return courseTypePersistence;
	}

	/**
	 * Sets the course type persistence.
	 *
	 * @param courseTypePersistence the course type persistence
	 */
	public void setCourseTypePersistence(
		CourseTypePersistence courseTypePersistence) {
		this.courseTypePersistence = courseTypePersistence;
	}

	/**
	 * Returns the curriculum local service.
	 *
	 * @return the curriculum local service
	 */
	public hu.unideb.inf.service.CurriculumLocalService getCurriculumLocalService() {
		return curriculumLocalService;
	}

	/**
	 * Sets the curriculum local service.
	 *
	 * @param curriculumLocalService the curriculum local service
	 */
	public void setCurriculumLocalService(
		hu.unideb.inf.service.CurriculumLocalService curriculumLocalService) {
		this.curriculumLocalService = curriculumLocalService;
	}

	/**
	 * Returns the curriculum remote service.
	 *
	 * @return the curriculum remote service
	 */
	public hu.unideb.inf.service.CurriculumService getCurriculumService() {
		return curriculumService;
	}

	/**
	 * Sets the curriculum remote service.
	 *
	 * @param curriculumService the curriculum remote service
	 */
	public void setCurriculumService(
		hu.unideb.inf.service.CurriculumService curriculumService) {
		this.curriculumService = curriculumService;
	}

	/**
	 * Returns the curriculum persistence.
	 *
	 * @return the curriculum persistence
	 */
	public CurriculumPersistence getCurriculumPersistence() {
		return curriculumPersistence;
	}

	/**
	 * Sets the curriculum persistence.
	 *
	 * @param curriculumPersistence the curriculum persistence
	 */
	public void setCurriculumPersistence(
		CurriculumPersistence curriculumPersistence) {
		this.curriculumPersistence = curriculumPersistence;
	}

	/**
	 * Returns the subject local service.
	 *
	 * @return the subject local service
	 */
	public hu.unideb.inf.service.SubjectLocalService getSubjectLocalService() {
		return subjectLocalService;
	}

	/**
	 * Sets the subject local service.
	 *
	 * @param subjectLocalService the subject local service
	 */
	public void setSubjectLocalService(
		hu.unideb.inf.service.SubjectLocalService subjectLocalService) {
		this.subjectLocalService = subjectLocalService;
	}

	/**
	 * Returns the subject remote service.
	 *
	 * @return the subject remote service
	 */
	public hu.unideb.inf.service.SubjectService getSubjectService() {
		return subjectService;
	}

	/**
	 * Sets the subject remote service.
	 *
	 * @param subjectService the subject remote service
	 */
	public void setSubjectService(
		hu.unideb.inf.service.SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	/**
	 * Returns the subject persistence.
	 *
	 * @return the subject persistence
	 */
	public SubjectPersistence getSubjectPersistence() {
		return subjectPersistence;
	}

	/**
	 * Sets the subject persistence.
	 *
	 * @param subjectPersistence the subject persistence
	 */
	public void setSubjectPersistence(SubjectPersistence subjectPersistence) {
		this.subjectPersistence = subjectPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return Course.class;
	}

	protected String getModelClassName() {
		return Course.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = coursePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = hu.unideb.inf.service.CourseLocalService.class)
	protected hu.unideb.inf.service.CourseLocalService courseLocalService;
	@BeanReference(type = hu.unideb.inf.service.CourseService.class)
	protected hu.unideb.inf.service.CourseService courseService;
	@BeanReference(type = CoursePersistence.class)
	protected CoursePersistence coursePersistence;
	@BeanReference(type = hu.unideb.inf.service.CourseTypeLocalService.class)
	protected hu.unideb.inf.service.CourseTypeLocalService courseTypeLocalService;
	@BeanReference(type = hu.unideb.inf.service.CourseTypeService.class)
	protected hu.unideb.inf.service.CourseTypeService courseTypeService;
	@BeanReference(type = CourseTypePersistence.class)
	protected CourseTypePersistence courseTypePersistence;
	@BeanReference(type = hu.unideb.inf.service.CurriculumLocalService.class)
	protected hu.unideb.inf.service.CurriculumLocalService curriculumLocalService;
	@BeanReference(type = hu.unideb.inf.service.CurriculumService.class)
	protected hu.unideb.inf.service.CurriculumService curriculumService;
	@BeanReference(type = CurriculumPersistence.class)
	protected CurriculumPersistence curriculumPersistence;
	@BeanReference(type = hu.unideb.inf.service.SubjectLocalService.class)
	protected hu.unideb.inf.service.SubjectLocalService subjectLocalService;
	@BeanReference(type = hu.unideb.inf.service.SubjectService.class)
	protected hu.unideb.inf.service.SubjectService subjectService;
	@BeanReference(type = SubjectPersistence.class)
	protected SubjectPersistence subjectPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private CourseServiceClpInvoker _clpInvoker = new CourseServiceClpInvoker();
}