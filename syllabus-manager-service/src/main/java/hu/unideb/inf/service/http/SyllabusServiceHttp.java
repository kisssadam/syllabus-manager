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

import hu.unideb.inf.service.SyllabusServiceUtil;

/**
 * Provides the HTTP utility for the
 * {@link SyllabusServiceUtil} service utility. The
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
 * @see SyllabusServiceSoap
 * @see HttpPrincipal
 * @see SyllabusServiceUtil
 * @generated
 */
@ProviderType
public class SyllabusServiceHttp {
	public static java.util.List<hu.unideb.inf.model.Syllabus> getSyllabuses(
		HttpPrincipal httpPrincipal) {
		try {
			MethodKey methodKey = new MethodKey(SyllabusServiceUtil.class,
					"getSyllabuses", _getSyllabusesParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<hu.unideb.inf.model.Syllabus>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<hu.unideb.inf.model.Syllabus> getSyllabusesByTimetableCourseId(
		HttpPrincipal httpPrincipal, long timetableCourseId) {
		try {
			MethodKey methodKey = new MethodKey(SyllabusServiceUtil.class,
					"getSyllabusesByTimetableCourseId",
					_getSyllabusesByTimetableCourseIdParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					timetableCourseId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<hu.unideb.inf.model.Syllabus>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<hu.unideb.inf.model.Syllabus> getSyllabusesByTimetableCourseId(
		HttpPrincipal httpPrincipal, long timetableCourseId, int start, int end) {
		try {
			MethodKey methodKey = new MethodKey(SyllabusServiceUtil.class,
					"getSyllabusesByTimetableCourseId",
					_getSyllabusesByTimetableCourseIdParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					timetableCourseId, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<hu.unideb.inf.model.Syllabus>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int getSyllabusesCountByTimetableCourseId(
		HttpPrincipal httpPrincipal, long timetableCourseId) {
		try {
			MethodKey methodKey = new MethodKey(SyllabusServiceUtil.class,
					"getSyllabusesCountByTimetableCourseId",
					_getSyllabusesCountByTimetableCourseIdParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					timetableCourseId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static hu.unideb.inf.model.Syllabus getSyllabus(
		HttpPrincipal httpPrincipal, long syllabusId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(SyllabusServiceUtil.class,
					"getSyllabus", _getSyllabusParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					syllabusId);

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

			return (hu.unideb.inf.model.Syllabus)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static hu.unideb.inf.model.Syllabus addSyllabus(
		HttpPrincipal httpPrincipal, long timetableCourseId,
		java.lang.String competence, java.lang.String ethicalStandards,
		java.lang.String topics, java.lang.String educationalMaterials,
		java.lang.String recommendedLiterature, java.lang.String weeklyTasks,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(SyllabusServiceUtil.class,
					"addSyllabus", _addSyllabusParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					timetableCourseId, competence, ethicalStandards, topics,
					educationalMaterials, recommendedLiterature, weeklyTasks,
					serviceContext);

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

			return (hu.unideb.inf.model.Syllabus)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static hu.unideb.inf.model.Syllabus updateSyllabus(
		HttpPrincipal httpPrincipal, long userId, long syllabusId,
		long timetableCourseId, java.lang.String competence,
		java.lang.String ethicalStandards, java.lang.String topics,
		java.lang.String educationalMaterials,
		java.lang.String recommendedLiterature, java.lang.String weeklyTasks,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(SyllabusServiceUtil.class,
					"updateSyllabus", _updateSyllabusParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId,
					syllabusId, timetableCourseId, competence,
					ethicalStandards, topics, educationalMaterials,
					recommendedLiterature, weeklyTasks, serviceContext);

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

			return (hu.unideb.inf.model.Syllabus)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static hu.unideb.inf.model.Syllabus deleteSyllabus(
		HttpPrincipal httpPrincipal, long syllabusId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(SyllabusServiceUtil.class,
					"deleteSyllabus", _deleteSyllabusParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					syllabusId, serviceContext);

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

			return (hu.unideb.inf.model.Syllabus)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static hu.unideb.inf.model.Syllabus updateStatus(
		HttpPrincipal httpPrincipal, long userId, long classPK, int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		java.util.Map<java.lang.String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(SyllabusServiceUtil.class,
					"updateStatus", _updateStatusParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId,
					classPK, status, serviceContext, workflowContext);

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

			return (hu.unideb.inf.model.Syllabus)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SyllabusServiceHttp.class);
	private static final Class<?>[] _getSyllabusesParameterTypes0 = new Class[] {  };
	private static final Class<?>[] _getSyllabusesByTimetableCourseIdParameterTypes1 =
		new Class[] { long.class };
	private static final Class<?>[] _getSyllabusesByTimetableCourseIdParameterTypes2 =
		new Class[] { long.class, int.class, int.class };
	private static final Class<?>[] _getSyllabusesCountByTimetableCourseIdParameterTypes3 =
		new Class[] { long.class };
	private static final Class<?>[] _getSyllabusParameterTypes4 = new Class[] {
			long.class
		};
	private static final Class<?>[] _addSyllabusParameterTypes5 = new Class[] {
			long.class, java.lang.String.class, java.lang.String.class,
			java.lang.String.class, java.lang.String.class,
			java.lang.String.class, java.lang.String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _updateSyllabusParameterTypes6 = new Class[] {
			long.class, long.class, long.class, java.lang.String.class,
			java.lang.String.class, java.lang.String.class,
			java.lang.String.class, java.lang.String.class,
			java.lang.String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteSyllabusParameterTypes7 = new Class[] {
			long.class, com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _updateStatusParameterTypes8 = new Class[] {
			long.class, long.class, int.class,
			com.liferay.portal.kernel.service.ServiceContext.class,
			java.util.Map.class
		};
}