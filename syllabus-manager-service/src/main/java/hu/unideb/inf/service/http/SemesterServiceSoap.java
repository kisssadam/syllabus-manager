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

import hu.unideb.inf.service.SemesterServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link SemesterServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link hu.unideb.inf.model.SemesterSoap}.
 * If the method in the service utility returns a
 * {@link hu.unideb.inf.model.Semester}, that is translated to a
 * {@link hu.unideb.inf.model.SemesterSoap}. Methods that SOAP cannot
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
 * @see SemesterServiceHttp
 * @see hu.unideb.inf.model.SemesterSoap
 * @see SemesterServiceUtil
 * @generated
 */
@ProviderType
public class SemesterServiceSoap {
	public static hu.unideb.inf.model.SemesterSoap getSemester(long semesterId)
		throws RemoteException {
		try {
			hu.unideb.inf.model.Semester returnValue = SemesterServiceUtil.getSemester(semesterId);

			return hu.unideb.inf.model.SemesterSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.SemesterSoap[] getSemesters()
		throws RemoteException {
		try {
			java.util.List<hu.unideb.inf.model.Semester> returnValue = SemesterServiceUtil.getSemesters();

			return hu.unideb.inf.model.SemesterSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.SemesterSoap getSemesterByB_E_D(
		int beginYear, int endYear, int division) throws RemoteException {
		try {
			hu.unideb.inf.model.Semester returnValue = SemesterServiceUtil.getSemesterByB_E_D(beginYear,
					endYear, division);

			return hu.unideb.inf.model.SemesterSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.SemesterSoap getLatestSemester()
		throws RemoteException {
		try {
			hu.unideb.inf.model.Semester returnValue = SemesterServiceUtil.getLatestSemester();

			return hu.unideb.inf.model.SemesterSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.SemesterSoap addNextSemester(
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			hu.unideb.inf.model.Semester returnValue = SemesterServiceUtil.addNextSemester(serviceContext);

			return hu.unideb.inf.model.SemesterSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.SemesterSoap addCurrentSemester(
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			hu.unideb.inf.model.Semester returnValue = SemesterServiceUtil.addCurrentSemester(serviceContext);

			return hu.unideb.inf.model.SemesterSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.SemesterSoap addSemester(int beginYear,
		int endYear, int division,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			hu.unideb.inf.model.Semester returnValue = SemesterServiceUtil.addSemester(beginYear,
					endYear, division, serviceContext);

			return hu.unideb.inf.model.SemesterSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.SemesterSoap deleteSemester(
		long semesterId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			hu.unideb.inf.model.Semester returnValue = SemesterServiceUtil.deleteSemester(semesterId,
					serviceContext);

			return hu.unideb.inf.model.SemesterSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.SemesterSoap updateSemester(long userId,
		long semesterId, int beginYear, int endYear, int division,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			hu.unideb.inf.model.Semester returnValue = SemesterServiceUtil.updateSemester(userId,
					semesterId, beginYear, endYear, division, serviceContext);

			return hu.unideb.inf.model.SemesterSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SemesterServiceSoap.class);
}