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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import hu.unideb.inf.service.CurriculumServiceUtil;

/**
 * Provides the HTTP utility for the
 * {@link CurriculumServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Adam Kiss
 * @see CurriculumServiceSoap
 * @see HttpPrincipal
 * @see CurriculumServiceUtil
 * @generated
 */
@ProviderType
public class CurriculumServiceHttp {
	public static hu.unideb.inf.model.Curriculum getCurriculum(
		HttpPrincipal httpPrincipal, long curriculumId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(CurriculumServiceUtil.class,
					"getCurriculum", _getCurriculumParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					curriculumId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (hu.unideb.inf.model.Curriculum)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<hu.unideb.inf.model.Curriculum> getCurriculums(
		HttpPrincipal httpPrincipal)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(CurriculumServiceUtil.class,
					"getCurriculums", _getCurriculumsParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<hu.unideb.inf.model.Curriculum>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static hu.unideb.inf.model.Curriculum getCurriculumByCode(
		HttpPrincipal httpPrincipal, java.lang.String curriculumCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.exception.NoSuchCurriculumException {
		try {
			MethodKey methodKey = new MethodKey(CurriculumServiceUtil.class,
					"getCurriculumByCode", _getCurriculumByCodeParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					curriculumCode);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				if (e instanceof hu.unideb.inf.exception.NoSuchCurriculumException) {
					throw (hu.unideb.inf.exception.NoSuchCurriculumException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (hu.unideb.inf.model.Curriculum)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static hu.unideb.inf.model.Curriculum fetchCurriculumByCode(
		HttpPrincipal httpPrincipal, java.lang.String curriculumCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(CurriculumServiceUtil.class,
					"fetchCurriculumByCode",
					_fetchCurriculumByCodeParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					curriculumCode);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (hu.unideb.inf.model.Curriculum)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static hu.unideb.inf.model.Curriculum addCurriculum(
		HttpPrincipal httpPrincipal, java.lang.String curriculumCode,
		java.lang.String curriculumName,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(CurriculumServiceUtil.class,
					"addCurriculum", _addCurriculumParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					curriculumCode, curriculumName, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (hu.unideb.inf.model.Curriculum)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static hu.unideb.inf.model.Curriculum deleteCurriculum(
		HttpPrincipal httpPrincipal, long curriculumId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(CurriculumServiceUtil.class,
					"deleteCurriculum", _deleteCurriculumParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					curriculumId, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (hu.unideb.inf.model.Curriculum)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static hu.unideb.inf.model.Curriculum updateCurriculum(
		HttpPrincipal httpPrincipal, long userId, long curriculumId,
		java.lang.String curriculumCode, java.lang.String curriculumName,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(CurriculumServiceUtil.class,
					"updateCurriculum", _updateCurriculumParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId,
					curriculumId, curriculumCode, curriculumName, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (hu.unideb.inf.model.Curriculum)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(CurriculumServiceHttp.class);
	private static final Class<?>[] _getCurriculumParameterTypes0 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getCurriculumsParameterTypes1 = new Class[] {
			
		};
	private static final Class<?>[] _getCurriculumByCodeParameterTypes2 = new Class[] {
			java.lang.String.class
		};
	private static final Class<?>[] _fetchCurriculumByCodeParameterTypes3 = new Class[] {
			java.lang.String.class
		};
	private static final Class<?>[] _addCurriculumParameterTypes4 = new Class[] {
			java.lang.String.class, java.lang.String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteCurriculumParameterTypes5 = new Class[] {
			long.class, com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _updateCurriculumParameterTypes6 = new Class[] {
			long.class, long.class, java.lang.String.class,
			java.lang.String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
}