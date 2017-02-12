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

import hu.unideb.inf.service.SyllabusServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link SyllabusServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link hu.unideb.inf.model.SyllabusSoap}.
 * If the method in the service utility returns a
 * {@link hu.unideb.inf.model.Syllabus}, that is translated to a
 * {@link hu.unideb.inf.model.SyllabusSoap}. Methods that SOAP cannot
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
 * @see SyllabusServiceHttp
 * @see hu.unideb.inf.model.SyllabusSoap
 * @see SyllabusServiceUtil
 * @generated
 */
@ProviderType
public class SyllabusServiceSoap {
	public static hu.unideb.inf.model.SyllabusSoap[] getSyllabuses()
		throws RemoteException {
		try {
			java.util.List<hu.unideb.inf.model.Syllabus> returnValue = SyllabusServiceUtil.getSyllabuses();

			return hu.unideb.inf.model.SyllabusSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.SyllabusSoap[] getSyllabusesByTimetableCourseId(
		long timetableCourseId) throws RemoteException {
		try {
			java.util.List<hu.unideb.inf.model.Syllabus> returnValue = SyllabusServiceUtil.getSyllabusesByTimetableCourseId(timetableCourseId);

			return hu.unideb.inf.model.SyllabusSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.SyllabusSoap[] getSyllabusesByTimetableCourseId(
		long timetableCourseId, int start, int end) throws RemoteException {
		try {
			java.util.List<hu.unideb.inf.model.Syllabus> returnValue = SyllabusServiceUtil.getSyllabusesByTimetableCourseId(timetableCourseId,
					start, end);

			return hu.unideb.inf.model.SyllabusSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getSyllabusesCountByTimetableCourseId(
		long timetableCourseId) throws RemoteException {
		try {
			int returnValue = SyllabusServiceUtil.getSyllabusesCountByTimetableCourseId(timetableCourseId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.SyllabusSoap getSyllabus(long syllabusId)
		throws RemoteException {
		try {
			hu.unideb.inf.model.Syllabus returnValue = SyllabusServiceUtil.getSyllabus(syllabusId);

			return hu.unideb.inf.model.SyllabusSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.SyllabusSoap addSyllabus(
		long timetableCourseId, java.lang.String competence,
		java.lang.String ethicalStandards, java.lang.String topics,
		java.lang.String educationalMaterials,
		java.lang.String recommendedLiterature, java.lang.String weeklyTasks,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			hu.unideb.inf.model.Syllabus returnValue = SyllabusServiceUtil.addSyllabus(timetableCourseId,
					competence, ethicalStandards, topics, educationalMaterials,
					recommendedLiterature, weeklyTasks, serviceContext);

			return hu.unideb.inf.model.SyllabusSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.SyllabusSoap updateSyllabus(long userId,
		long syllabusId, long timetableCourseId, java.lang.String competence,
		java.lang.String ethicalStandards, java.lang.String topics,
		java.lang.String educationalMaterials,
		java.lang.String recommendedLiterature, java.lang.String weeklyTasks,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			hu.unideb.inf.model.Syllabus returnValue = SyllabusServiceUtil.updateSyllabus(userId,
					syllabusId, timetableCourseId, competence,
					ethicalStandards, topics, educationalMaterials,
					recommendedLiterature, weeklyTasks, serviceContext);

			return hu.unideb.inf.model.SyllabusSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.SyllabusSoap deleteSyllabus(
		long syllabusId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			hu.unideb.inf.model.Syllabus returnValue = SyllabusServiceUtil.deleteSyllabus(syllabusId,
					serviceContext);

			return hu.unideb.inf.model.SyllabusSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SyllabusServiceSoap.class);
}