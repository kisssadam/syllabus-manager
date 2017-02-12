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

import hu.unideb.inf.service.CourseTypeServiceUtil;

/**
 * Provides the HTTP utility for the
 * {@link CourseTypeServiceUtil} service utility. The
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
 * @see CourseTypeServiceSoap
 * @see HttpPrincipal
 * @see CourseTypeServiceUtil
 * @generated
 */
@ProviderType
public class CourseTypeServiceHttp {
	public static hu.unideb.inf.model.CourseType getCourseType(
		HttpPrincipal httpPrincipal, long courseTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(CourseTypeServiceUtil.class,
					"getCourseType", _getCourseTypeParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					courseTypeId);

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

			return (hu.unideb.inf.model.CourseType)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<hu.unideb.inf.model.CourseType> getCourseTypes(
		HttpPrincipal httpPrincipal)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(CourseTypeServiceUtil.class,
					"getCourseTypes", _getCourseTypesParameterTypes1);

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

			return (java.util.List<hu.unideb.inf.model.CourseType>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static hu.unideb.inf.model.CourseType getCourseTypeByTypeName(
		HttpPrincipal httpPrincipal, java.lang.String typeName)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.exception.NoSuchCourseTypeException {
		try {
			MethodKey methodKey = new MethodKey(CourseTypeServiceUtil.class,
					"getCourseTypeByTypeName",
					_getCourseTypeByTypeNameParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, typeName);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				if (e instanceof hu.unideb.inf.exception.NoSuchCourseTypeException) {
					throw (hu.unideb.inf.exception.NoSuchCourseTypeException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (hu.unideb.inf.model.CourseType)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static hu.unideb.inf.model.CourseType fetchCourseTypeByTypeName(
		HttpPrincipal httpPrincipal, java.lang.String typeName)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(CourseTypeServiceUtil.class,
					"fetchCourseTypeByTypeName",
					_fetchCourseTypeByTypeNameParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, typeName);

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

			return (hu.unideb.inf.model.CourseType)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static hu.unideb.inf.model.CourseType addCourseType(
		HttpPrincipal httpPrincipal, java.lang.String typeName,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(CourseTypeServiceUtil.class,
					"addCourseType", _addCourseTypeParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					typeName, serviceContext);

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

			return (hu.unideb.inf.model.CourseType)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static hu.unideb.inf.model.CourseType deleteCourseType(
		HttpPrincipal httpPrincipal, long courseTypeId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(CourseTypeServiceUtil.class,
					"deleteCourseType", _deleteCourseTypeParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					courseTypeId, serviceContext);

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

			return (hu.unideb.inf.model.CourseType)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static hu.unideb.inf.model.CourseType updateCourseType(
		HttpPrincipal httpPrincipal, long userId, long courseTypeId,
		java.lang.String typeName,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(CourseTypeServiceUtil.class,
					"updateCourseType", _updateCourseTypeParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId,
					courseTypeId, typeName, serviceContext);

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

			return (hu.unideb.inf.model.CourseType)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(CourseTypeServiceHttp.class);
	private static final Class<?>[] _getCourseTypeParameterTypes0 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getCourseTypesParameterTypes1 = new Class[] {
			
		};
	private static final Class<?>[] _getCourseTypeByTypeNameParameterTypes2 = new Class[] {
			java.lang.String.class
		};
	private static final Class<?>[] _fetchCourseTypeByTypeNameParameterTypes3 = new Class[] {
			java.lang.String.class
		};
	private static final Class<?>[] _addCourseTypeParameterTypes4 = new Class[] {
			java.lang.String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteCourseTypeParameterTypes5 = new Class[] {
			long.class, com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _updateCourseTypeParameterTypes6 = new Class[] {
			long.class, long.class, java.lang.String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
}