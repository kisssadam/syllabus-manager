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

import hu.unideb.inf.service.TimetableCourseServiceUtil;

/**
 * Provides the HTTP utility for the
 * {@link TimetableCourseServiceUtil} service utility. The
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
 * @see TimetableCourseServiceSoap
 * @see HttpPrincipal
 * @see TimetableCourseServiceUtil
 * @generated
 */
@ProviderType
public class TimetableCourseServiceHttp {
	public static hu.unideb.inf.model.TimetableCourse getTimetableCourse(
		HttpPrincipal httpPrincipal, long timetableCourseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(TimetableCourseServiceUtil.class,
					"getTimetableCourse", _getTimetableCourseParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					timetableCourseId);

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

			return (hu.unideb.inf.model.TimetableCourse)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCourses(
		HttpPrincipal httpPrincipal)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(TimetableCourseServiceUtil.class,
					"getTimetableCourses", _getTimetableCoursesParameterTypes1);

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

			return (java.util.List<hu.unideb.inf.model.TimetableCourse>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCoursesBySemesterId(
		HttpPrincipal httpPrincipal, long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(TimetableCourseServiceUtil.class,
					"getTimetableCoursesBySemesterId",
					_getTimetableCoursesBySemesterIdParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					semesterId);

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

			return (java.util.List<hu.unideb.inf.model.TimetableCourse>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCoursesBySemesterId(
		HttpPrincipal httpPrincipal, long semesterId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(TimetableCourseServiceUtil.class,
					"getTimetableCoursesBySemesterId",
					_getTimetableCoursesBySemesterIdParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					semesterId, start, end);

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

			return (java.util.List<hu.unideb.inf.model.TimetableCourse>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int getTimetableCoursesCountBySemesterId(
		HttpPrincipal httpPrincipal, long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(TimetableCourseServiceUtil.class,
					"getTimetableCoursesCountBySemesterId",
					_getTimetableCoursesCountBySemesterIdParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					semesterId);

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

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static hu.unideb.inf.model.TimetableCourse fetchTimetableCourseByC_S_T_S(
		HttpPrincipal httpPrincipal, long courseId, long semesterId,
		java.lang.String timetableCourseCode, java.lang.String subjectType)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(TimetableCourseServiceUtil.class,
					"fetchTimetableCourseByC_S_T_S",
					_fetchTimetableCourseByC_S_T_SParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					courseId, semesterId, timetableCourseCode, subjectType);

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

			return (hu.unideb.inf.model.TimetableCourse)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCoursesByC_S(
		HttpPrincipal httpPrincipal, long courseId, long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.exception.NoSuchTimetableCourseException {
		try {
			MethodKey methodKey = new MethodKey(TimetableCourseServiceUtil.class,
					"getTimetableCoursesByC_S",
					_getTimetableCoursesByC_SParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					courseId, semesterId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				if (e instanceof hu.unideb.inf.exception.NoSuchTimetableCourseException) {
					throw (hu.unideb.inf.exception.NoSuchTimetableCourseException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<hu.unideb.inf.model.TimetableCourse>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCoursesByCourseId(
		HttpPrincipal httpPrincipal, long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(TimetableCourseServiceUtil.class,
					"getTimetableCoursesByCourseId",
					_getTimetableCoursesByCourseIdParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(methodKey, courseId);

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

			return (java.util.List<hu.unideb.inf.model.TimetableCourse>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCoursesByCourseId(
		HttpPrincipal httpPrincipal, long courseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(TimetableCourseServiceUtil.class,
					"getTimetableCoursesByCourseId",
					_getTimetableCoursesByCourseIdParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					courseId, start, end);

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

			return (java.util.List<hu.unideb.inf.model.TimetableCourse>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int getTimetableCourseCountByCourseId(
		HttpPrincipal httpPrincipal, long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(TimetableCourseServiceUtil.class,
					"getTimetableCourseCountByCourseId",
					_getTimetableCourseCountByCourseIdParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(methodKey, courseId);

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

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<hu.unideb.inf.model.Lecturer> getLecutersByTimetableCourseId(
		HttpPrincipal httpPrincipal, long timetableCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(TimetableCourseServiceUtil.class,
					"getLecutersByTimetableCourseId",
					_getLecutersByTimetableCourseIdParameterTypes10);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					timetableCourseId);

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

			return (java.util.List<hu.unideb.inf.model.Lecturer>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static hu.unideb.inf.model.TimetableCourse addTimetableCourse(
		HttpPrincipal httpPrincipal, long courseId, long semesterId,
		java.lang.String timetableCourseCode, java.lang.String subjectType,
		int recommendedTerm, int limit, long[] lecturerIds,
		java.lang.String classScheduleInfo, java.lang.String description,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(TimetableCourseServiceUtil.class,
					"addTimetableCourse", _addTimetableCourseParameterTypes11);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					courseId, semesterId, timetableCourseCode, subjectType,
					recommendedTerm, limit, lecturerIds, classScheduleInfo,
					description, serviceContext);

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

			return (hu.unideb.inf.model.TimetableCourse)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static hu.unideb.inf.model.TimetableCourse updateTimetableCourse(
		HttpPrincipal httpPrincipal, long userId, long timetableCourseId,
		long courseId, long semesterId, java.lang.String timetableCourseCode,
		java.lang.String subjectType, int recommendedTerm, int limit,
		long[] lecturerIds, java.lang.String classScheduleInfo,
		java.lang.String description,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(TimetableCourseServiceUtil.class,
					"updateTimetableCourse",
					_updateTimetableCourseParameterTypes12);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId,
					timetableCourseId, courseId, semesterId,
					timetableCourseCode, subjectType, recommendedTerm, limit,
					lecturerIds, classScheduleInfo, description, serviceContext);

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

			return (hu.unideb.inf.model.TimetableCourse)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static hu.unideb.inf.model.TimetableCourse deleteTimetableCourse(
		HttpPrincipal httpPrincipal, long timetableCourseId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(TimetableCourseServiceUtil.class,
					"deleteTimetableCourse",
					_deleteTimetableCourseParameterTypes13);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					timetableCourseId, serviceContext);

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

			return (hu.unideb.inf.model.TimetableCourse)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(TimetableCourseServiceHttp.class);
	private static final Class<?>[] _getTimetableCourseParameterTypes0 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getTimetableCoursesParameterTypes1 = new Class[] {
			
		};
	private static final Class<?>[] _getTimetableCoursesBySemesterIdParameterTypes2 =
		new Class[] { long.class };
	private static final Class<?>[] _getTimetableCoursesBySemesterIdParameterTypes3 =
		new Class[] { long.class, int.class, int.class };
	private static final Class<?>[] _getTimetableCoursesCountBySemesterIdParameterTypes4 =
		new Class[] { long.class };
	private static final Class<?>[] _fetchTimetableCourseByC_S_T_SParameterTypes5 =
		new Class[] {
			long.class, long.class, java.lang.String.class,
			java.lang.String.class
		};
	private static final Class<?>[] _getTimetableCoursesByC_SParameterTypes6 = new Class[] {
			long.class, long.class
		};
	private static final Class<?>[] _getTimetableCoursesByCourseIdParameterTypes7 =
		new Class[] { long.class };
	private static final Class<?>[] _getTimetableCoursesByCourseIdParameterTypes8 =
		new Class[] { long.class, int.class, int.class };
	private static final Class<?>[] _getTimetableCourseCountByCourseIdParameterTypes9 =
		new Class[] { long.class };
	private static final Class<?>[] _getLecutersByTimetableCourseIdParameterTypes10 =
		new Class[] { long.class };
	private static final Class<?>[] _addTimetableCourseParameterTypes11 = new Class[] {
			long.class, long.class, java.lang.String.class,
			java.lang.String.class, int.class, int.class, long[].class,
			java.lang.String.class, java.lang.String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _updateTimetableCourseParameterTypes12 = new Class[] {
			long.class, long.class, long.class, long.class,
			java.lang.String.class, java.lang.String.class, int.class, int.class,
			long[].class, java.lang.String.class, java.lang.String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteTimetableCourseParameterTypes13 = new Class[] {
			long.class, com.liferay.portal.kernel.service.ServiceContext.class
		};
}