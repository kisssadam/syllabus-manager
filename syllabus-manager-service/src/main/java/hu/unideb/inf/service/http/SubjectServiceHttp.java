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

import hu.unideb.inf.service.SubjectServiceUtil;

/**
 * Provides the HTTP utility for the
 * {@link SubjectServiceUtil} service utility. The
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
 * @see SubjectServiceSoap
 * @see HttpPrincipal
 * @see SubjectServiceUtil
 * @generated
 */
@ProviderType
public class SubjectServiceHttp {
	public static hu.unideb.inf.model.Subject getSubject(
		HttpPrincipal httpPrincipal, long subjectId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(SubjectServiceUtil.class,
					"getSubject", _getSubjectParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, subjectId);

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

			return (hu.unideb.inf.model.Subject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<hu.unideb.inf.model.Subject> getSubjects(
		HttpPrincipal httpPrincipal)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(SubjectServiceUtil.class,
					"getSubjects", _getSubjectsParameterTypes1);

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

			return (java.util.List<hu.unideb.inf.model.Subject>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static hu.unideb.inf.model.Subject getSubjectByC_S(
		HttpPrincipal httpPrincipal, long curriculumId,
		java.lang.String subjectCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.exception.NoSuchSubjectException {
		try {
			MethodKey methodKey = new MethodKey(SubjectServiceUtil.class,
					"getSubjectByC_S", _getSubjectByC_SParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					curriculumId, subjectCode);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				if (e instanceof hu.unideb.inf.exception.NoSuchSubjectException) {
					throw (hu.unideb.inf.exception.NoSuchSubjectException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (hu.unideb.inf.model.Subject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static hu.unideb.inf.model.Subject fetchSubjectByC_S(
		HttpPrincipal httpPrincipal, long curriculumId,
		java.lang.String subjectCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(SubjectServiceUtil.class,
					"fetchSubjectByC_S", _fetchSubjectByC_SParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					curriculumId, subjectCode);

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

			return (hu.unideb.inf.model.Subject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<hu.unideb.inf.model.Subject> getSubjectsByCurriculumId(
		HttpPrincipal httpPrincipal, long curriculumId)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(SubjectServiceUtil.class,
					"getSubjectsByCurriculumId",
					_getSubjectsByCurriculumIdParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					curriculumId);

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

			return (java.util.List<hu.unideb.inf.model.Subject>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<hu.unideb.inf.model.Subject> getSubjectsByCurriculumId(
		HttpPrincipal httpPrincipal, long curriculumId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(SubjectServiceUtil.class,
					"getSubjectsByCurriculumId",
					_getSubjectsByCurriculumIdParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					curriculumId, start, end);

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

			return (java.util.List<hu.unideb.inf.model.Subject>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int getSubjectsCountByCurriculumId(
		HttpPrincipal httpPrincipal, long curriculumId)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(SubjectServiceUtil.class,
					"getSubjectsCountByCurriculumId",
					_getSubjectsCountByCurriculumIdParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					curriculumId);

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

	public static hu.unideb.inf.model.Subject addSubject(
		HttpPrincipal httpPrincipal, java.lang.String subjectCode,
		java.lang.String subjectName, int credit, long curriculumId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(SubjectServiceUtil.class,
					"addSubject", _addSubjectParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					subjectCode, subjectName, credit, curriculumId,
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

			return (hu.unideb.inf.model.Subject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static hu.unideb.inf.model.Subject deleteSubject(
		HttpPrincipal httpPrincipal, long subjectId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(SubjectServiceUtil.class,
					"deleteSubject", _deleteSubjectParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					subjectId, serviceContext);

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

			return (hu.unideb.inf.model.Subject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static hu.unideb.inf.model.Subject updateSubject(
		HttpPrincipal httpPrincipal, long userId, long subjectId,
		java.lang.String subjectCode, java.lang.String subjectName, int credit,
		long curriculumId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(SubjectServiceUtil.class,
					"updateSubject", _updateSubjectParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId,
					subjectId, subjectCode, subjectName, credit, curriculumId,
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

			return (hu.unideb.inf.model.Subject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SubjectServiceHttp.class);
	private static final Class<?>[] _getSubjectParameterTypes0 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getSubjectsParameterTypes1 = new Class[] {  };
	private static final Class<?>[] _getSubjectByC_SParameterTypes2 = new Class[] {
			long.class, java.lang.String.class
		};
	private static final Class<?>[] _fetchSubjectByC_SParameterTypes3 = new Class[] {
			long.class, java.lang.String.class
		};
	private static final Class<?>[] _getSubjectsByCurriculumIdParameterTypes4 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getSubjectsByCurriculumIdParameterTypes5 = new Class[] {
			long.class, int.class, int.class
		};
	private static final Class<?>[] _getSubjectsCountByCurriculumIdParameterTypes6 =
		new Class[] { long.class };
	private static final Class<?>[] _addSubjectParameterTypes7 = new Class[] {
			java.lang.String.class, java.lang.String.class, int.class,
			long.class, com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteSubjectParameterTypes8 = new Class[] {
			long.class, com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _updateSubjectParameterTypes9 = new Class[] {
			long.class, long.class, java.lang.String.class,
			java.lang.String.class, int.class, long.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
}