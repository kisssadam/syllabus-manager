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

package hu.unideb.inf.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import hu.unideb.inf.service.CourseServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link CourseServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link hu.unideb.inf.model.CourseSoap}.
 * If the method in the service utility returns a
 * {@link hu.unideb.inf.model.Course}, that is translated to a
 * {@link hu.unideb.inf.model.CourseSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Adam Kiss
 * @see CourseServiceHttp
 * @see hu.unideb.inf.model.CourseSoap
 * @see CourseServiceUtil
 * @generated
 */
@ProviderType
public class CourseServiceSoap {
	public static hu.unideb.inf.model.CourseSoap getCourse(long courseId)
		throws RemoteException {
		try {
			hu.unideb.inf.model.Course returnValue = CourseServiceUtil.getCourse(courseId);

			return hu.unideb.inf.model.CourseSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.CourseSoap[] getCourses()
		throws RemoteException {
		try {
			java.util.List<hu.unideb.inf.model.Course> returnValue = CourseServiceUtil.getCourses();

			return hu.unideb.inf.model.CourseSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.CourseSoap getCourseByS_CT(
		long subjectId, long courseTypeId) throws RemoteException {
		try {
			hu.unideb.inf.model.Course returnValue = CourseServiceUtil.getCourseByS_CT(subjectId,
					courseTypeId);

			return hu.unideb.inf.model.CourseSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.CourseSoap fetchCourseByS_CT(
		long subjectId, long courseTypeId) throws RemoteException {
		try {
			hu.unideb.inf.model.Course returnValue = CourseServiceUtil.fetchCourseByS_CT(subjectId,
					courseTypeId);

			return hu.unideb.inf.model.CourseSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.CourseSoap[] getCoursesBySubjectId(
		long subjectId) throws RemoteException {
		try {
			java.util.List<hu.unideb.inf.model.Course> returnValue = CourseServiceUtil.getCoursesBySubjectId(subjectId);

			return hu.unideb.inf.model.CourseSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.CourseSoap[] getCoursesBySubjectId(
		long subjectId, int start, int end) throws RemoteException {
		try {
			java.util.List<hu.unideb.inf.model.Course> returnValue = CourseServiceUtil.getCoursesBySubjectId(subjectId,
					start, end);

			return hu.unideb.inf.model.CourseSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getCoursesCountBySubjectId(long subjectId)
		throws RemoteException {
		try {
			int returnValue = CourseServiceUtil.getCoursesCountBySubjectId(subjectId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.CourseSoap[] getCoursesByCourseTypeId(
		long courseTypeId) throws RemoteException {
		try {
			java.util.List<hu.unideb.inf.model.Course> returnValue = CourseServiceUtil.getCoursesByCourseTypeId(courseTypeId);

			return hu.unideb.inf.model.CourseSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.CourseSoap addCourse(long subjectId,
		int hoursPerSemester, int hoursPerWeek, long courseTypeId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			hu.unideb.inf.model.Course returnValue = CourseServiceUtil.addCourse(subjectId,
					hoursPerSemester, hoursPerWeek, courseTypeId, serviceContext);

			return hu.unideb.inf.model.CourseSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.CourseSoap deleteCourse(long courseId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			hu.unideb.inf.model.Course returnValue = CourseServiceUtil.deleteCourse(courseId,
					serviceContext);

			return hu.unideb.inf.model.CourseSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.CourseSoap updateCourse(long userId,
		long courseId, long subjectId, int hoursPerSemester, int hoursPerWeek,
		long courseTypeId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			hu.unideb.inf.model.Course returnValue = CourseServiceUtil.updateCourse(userId,
					courseId, subjectId, hoursPerSemester, hoursPerWeek,
					courseTypeId, serviceContext);

			return hu.unideb.inf.model.CourseSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(CourseServiceSoap.class);
}