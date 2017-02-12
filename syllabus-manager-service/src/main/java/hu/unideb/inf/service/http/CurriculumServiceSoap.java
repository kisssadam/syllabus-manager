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

import hu.unideb.inf.service.CurriculumServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link CurriculumServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link hu.unideb.inf.model.CurriculumSoap}.
 * If the method in the service utility returns a
 * {@link hu.unideb.inf.model.Curriculum}, that is translated to a
 * {@link hu.unideb.inf.model.CurriculumSoap}. Methods that SOAP cannot
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
 * @see CurriculumServiceHttp
 * @see hu.unideb.inf.model.CurriculumSoap
 * @see CurriculumServiceUtil
 * @generated
 */
@ProviderType
public class CurriculumServiceSoap {
	public static hu.unideb.inf.model.CurriculumSoap getCurriculum(
		long curriculumId) throws RemoteException {
		try {
			hu.unideb.inf.model.Curriculum returnValue = CurriculumServiceUtil.getCurriculum(curriculumId);

			return hu.unideb.inf.model.CurriculumSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.CurriculumSoap[] getCurriculums()
		throws RemoteException {
		try {
			java.util.List<hu.unideb.inf.model.Curriculum> returnValue = CurriculumServiceUtil.getCurriculums();

			return hu.unideb.inf.model.CurriculumSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.CurriculumSoap getCurriculumByCode(
		java.lang.String curriculumCode) throws RemoteException {
		try {
			hu.unideb.inf.model.Curriculum returnValue = CurriculumServiceUtil.getCurriculumByCode(curriculumCode);

			return hu.unideb.inf.model.CurriculumSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.CurriculumSoap fetchCurriculumByCode(
		java.lang.String curriculumCode) throws RemoteException {
		try {
			hu.unideb.inf.model.Curriculum returnValue = CurriculumServiceUtil.fetchCurriculumByCode(curriculumCode);

			return hu.unideb.inf.model.CurriculumSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.CurriculumSoap addCurriculum(
		java.lang.String curriculumCode, java.lang.String curriculumName,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			hu.unideb.inf.model.Curriculum returnValue = CurriculumServiceUtil.addCurriculum(curriculumCode,
					curriculumName, serviceContext);

			return hu.unideb.inf.model.CurriculumSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.CurriculumSoap deleteCurriculum(
		long curriculumId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			hu.unideb.inf.model.Curriculum returnValue = CurriculumServiceUtil.deleteCurriculum(curriculumId,
					serviceContext);

			return hu.unideb.inf.model.CurriculumSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.CurriculumSoap updateCurriculum(
		long userId, long curriculumId, java.lang.String curriculumCode,
		java.lang.String curriculumName,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			hu.unideb.inf.model.Curriculum returnValue = CurriculumServiceUtil.updateCurriculum(userId,
					curriculumId, curriculumCode, curriculumName, serviceContext);

			return hu.unideb.inf.model.CurriculumSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(CurriculumServiceSoap.class);
}