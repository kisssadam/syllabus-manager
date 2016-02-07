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

package hu.unideb.inf.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import hu.unideb.inf.model.CourseClp;
import hu.unideb.inf.model.CourseTypeClp;
import hu.unideb.inf.model.CurriculumClp;
import hu.unideb.inf.model.LecturerClp;
import hu.unideb.inf.model.SemesterClp;
import hu.unideb.inf.model.SubjectClp;
import hu.unideb.inf.model.TimetableCourseClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Adam Kiss
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"unideb-syllabus-manager-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"unideb-syllabus-manager-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "unideb-syllabus-manager-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(CourseClp.class.getName())) {
			return translateInputCourse(oldModel);
		}

		if (oldModelClassName.equals(CourseTypeClp.class.getName())) {
			return translateInputCourseType(oldModel);
		}

		if (oldModelClassName.equals(CurriculumClp.class.getName())) {
			return translateInputCurriculum(oldModel);
		}

		if (oldModelClassName.equals(LecturerClp.class.getName())) {
			return translateInputLecturer(oldModel);
		}

		if (oldModelClassName.equals(SemesterClp.class.getName())) {
			return translateInputSemester(oldModel);
		}

		if (oldModelClassName.equals(SubjectClp.class.getName())) {
			return translateInputSubject(oldModel);
		}

		if (oldModelClassName.equals(TimetableCourseClp.class.getName())) {
			return translateInputTimetableCourse(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputCourse(BaseModel<?> oldModel) {
		CourseClp oldClpModel = (CourseClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCourseRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCourseType(BaseModel<?> oldModel) {
		CourseTypeClp oldClpModel = (CourseTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCourseTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCurriculum(BaseModel<?> oldModel) {
		CurriculumClp oldClpModel = (CurriculumClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCurriculumRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLecturer(BaseModel<?> oldModel) {
		LecturerClp oldClpModel = (LecturerClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLecturerRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSemester(BaseModel<?> oldModel) {
		SemesterClp oldClpModel = (SemesterClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSemesterRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSubject(BaseModel<?> oldModel) {
		SubjectClp oldClpModel = (SubjectClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSubjectRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputTimetableCourse(BaseModel<?> oldModel) {
		TimetableCourseClp oldClpModel = (TimetableCourseClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getTimetableCourseRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals("hu.unideb.inf.model.impl.CourseImpl")) {
			return translateOutputCourse(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("hu.unideb.inf.model.impl.CourseTypeImpl")) {
			return translateOutputCourseType(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("hu.unideb.inf.model.impl.CurriculumImpl")) {
			return translateOutputCurriculum(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("hu.unideb.inf.model.impl.LecturerImpl")) {
			return translateOutputLecturer(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("hu.unideb.inf.model.impl.SemesterImpl")) {
			return translateOutputSemester(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("hu.unideb.inf.model.impl.SubjectImpl")) {
			return translateOutputSubject(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"hu.unideb.inf.model.impl.TimetableCourseImpl")) {
			return translateOutputTimetableCourse(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("hu.unideb.inf.CourseHoursException")) {
			return new hu.unideb.inf.CourseHoursException();
		}

		if (className.equals("hu.unideb.inf.CourseTypeException")) {
			return new hu.unideb.inf.CourseTypeException();
		}

		if (className.equals("hu.unideb.inf.CurriculumCodeException")) {
			return new hu.unideb.inf.CurriculumCodeException();
		}

		if (className.equals("hu.unideb.inf.CurriculumNameException")) {
			return new hu.unideb.inf.CurriculumNameException();
		}

		if (className.equals("hu.unideb.inf.DuplicateCourseException")) {
			return new hu.unideb.inf.DuplicateCourseException();
		}

		if (className.equals("hu.unideb.inf.DuplicateCourseTypeException")) {
			return new hu.unideb.inf.DuplicateCourseTypeException();
		}

		if (className.equals("hu.unideb.inf.DuplicateCurriculumException")) {
			return new hu.unideb.inf.DuplicateCurriculumException();
		}

		if (className.equals("hu.unideb.inf.DuplicateSemesterException")) {
			return new hu.unideb.inf.DuplicateSemesterException();
		}

		if (className.equals("hu.unideb.inf.DuplicateSubjectException")) {
			return new hu.unideb.inf.DuplicateSubjectException();
		}

		if (className.equals("hu.unideb.inf.SemesterDivisionException")) {
			return new hu.unideb.inf.SemesterDivisionException();
		}

		if (className.equals("hu.unideb.inf.SemesterYearDifferenceException")) {
			return new hu.unideb.inf.SemesterYearDifferenceException();
		}

		if (className.equals("hu.unideb.inf.SemesterYearOverlapException")) {
			return new hu.unideb.inf.SemesterYearOverlapException();
		}

		if (className.equals("hu.unideb.inf.SemesterYearsAreEqualException")) {
			return new hu.unideb.inf.SemesterYearsAreEqualException();
		}

		if (className.equals("hu.unideb.inf.SubjectCodeException")) {
			return new hu.unideb.inf.SubjectCodeException();
		}

		if (className.equals("hu.unideb.inf.SubjectCreditException")) {
			return new hu.unideb.inf.SubjectCreditException();
		}

		if (className.equals("hu.unideb.inf.SubjectNameException")) {
			return new hu.unideb.inf.SubjectNameException();
		}

		if (className.equals("hu.unideb.inf.NoSuchCourseException")) {
			return new hu.unideb.inf.NoSuchCourseException();
		}

		if (className.equals("hu.unideb.inf.NoSuchCourseTypeException")) {
			return new hu.unideb.inf.NoSuchCourseTypeException();
		}

		if (className.equals("hu.unideb.inf.NoSuchCurriculumException")) {
			return new hu.unideb.inf.NoSuchCurriculumException();
		}

		if (className.equals("hu.unideb.inf.NoSuchLecturerException")) {
			return new hu.unideb.inf.NoSuchLecturerException();
		}

		if (className.equals("hu.unideb.inf.NoSuchSemesterException")) {
			return new hu.unideb.inf.NoSuchSemesterException();
		}

		if (className.equals("hu.unideb.inf.NoSuchSubjectException")) {
			return new hu.unideb.inf.NoSuchSubjectException();
		}

		if (className.equals("hu.unideb.inf.NoSuchTimetableCourseException")) {
			return new hu.unideb.inf.NoSuchTimetableCourseException();
		}

		return throwable;
	}

	public static Object translateOutputCourse(BaseModel<?> oldModel) {
		CourseClp newModel = new CourseClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCourseRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCourseType(BaseModel<?> oldModel) {
		CourseTypeClp newModel = new CourseTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCourseTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCurriculum(BaseModel<?> oldModel) {
		CurriculumClp newModel = new CurriculumClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCurriculumRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLecturer(BaseModel<?> oldModel) {
		LecturerClp newModel = new LecturerClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLecturerRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSemester(BaseModel<?> oldModel) {
		SemesterClp newModel = new SemesterClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSemesterRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSubject(BaseModel<?> oldModel) {
		SubjectClp newModel = new SubjectClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSubjectRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputTimetableCourse(BaseModel<?> oldModel) {
		TimetableCourseClp newModel = new TimetableCourseClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setTimetableCourseRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}