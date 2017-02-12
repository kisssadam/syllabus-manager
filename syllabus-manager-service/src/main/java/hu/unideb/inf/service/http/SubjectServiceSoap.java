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

import hu.unideb.inf.service.SubjectServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link SubjectServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link hu.unideb.inf.model.SubjectSoap}.
 * If the method in the service utility returns a
 * {@link hu.unideb.inf.model.Subject}, that is translated to a
 * {@link hu.unideb.inf.model.SubjectSoap}. Methods that SOAP cannot
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
 * @see SubjectServiceHttp
 * @see hu.unideb.inf.model.SubjectSoap
 * @see SubjectServiceUtil
 * @generated
 */
@ProviderType
public class SubjectServiceSoap {
	public static hu.unideb.inf.model.SubjectSoap getSubject(long subjectId)
		throws RemoteException {
		try {
			hu.unideb.inf.model.Subject returnValue = SubjectServiceUtil.getSubject(subjectId);

			return hu.unideb.inf.model.SubjectSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.SubjectSoap[] getSubjects()
		throws RemoteException {
		try {
			java.util.List<hu.unideb.inf.model.Subject> returnValue = SubjectServiceUtil.getSubjects();

			return hu.unideb.inf.model.SubjectSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.SubjectSoap getSubjectByC_S(
		long curriculumId, java.lang.String subjectCode)
		throws RemoteException {
		try {
			hu.unideb.inf.model.Subject returnValue = SubjectServiceUtil.getSubjectByC_S(curriculumId,
					subjectCode);

			return hu.unideb.inf.model.SubjectSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.SubjectSoap fetchSubjectByC_S(
		long curriculumId, java.lang.String subjectCode)
		throws RemoteException {
		try {
			hu.unideb.inf.model.Subject returnValue = SubjectServiceUtil.fetchSubjectByC_S(curriculumId,
					subjectCode);

			return hu.unideb.inf.model.SubjectSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.SubjectSoap[] getSubjectsByCurriculumId(
		long curriculumId) throws RemoteException {
		try {
			java.util.List<hu.unideb.inf.model.Subject> returnValue = SubjectServiceUtil.getSubjectsByCurriculumId(curriculumId);

			return hu.unideb.inf.model.SubjectSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.SubjectSoap[] getSubjectsByCurriculumId(
		long curriculumId, int start, int end) throws RemoteException {
		try {
			java.util.List<hu.unideb.inf.model.Subject> returnValue = SubjectServiceUtil.getSubjectsByCurriculumId(curriculumId,
					start, end);

			return hu.unideb.inf.model.SubjectSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getSubjectsCountByCurriculumId(long curriculumId)
		throws RemoteException {
		try {
			int returnValue = SubjectServiceUtil.getSubjectsCountByCurriculumId(curriculumId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.SubjectSoap addSubject(
		java.lang.String subjectCode, java.lang.String subjectName, int credit,
		long curriculumId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			hu.unideb.inf.model.Subject returnValue = SubjectServiceUtil.addSubject(subjectCode,
					subjectName, credit, curriculumId, serviceContext);

			return hu.unideb.inf.model.SubjectSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.SubjectSoap deleteSubject(
		long subjectId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			hu.unideb.inf.model.Subject returnValue = SubjectServiceUtil.deleteSubject(subjectId,
					serviceContext);

			return hu.unideb.inf.model.SubjectSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.SubjectSoap updateSubject(long userId,
		long subjectId, java.lang.String subjectCode,
		java.lang.String subjectName, int credit, long curriculumId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			hu.unideb.inf.model.Subject returnValue = SubjectServiceUtil.updateSubject(userId,
					subjectId, subjectCode, subjectName, credit, curriculumId,
					serviceContext);

			return hu.unideb.inf.model.SubjectSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SubjectServiceSoap.class);
}