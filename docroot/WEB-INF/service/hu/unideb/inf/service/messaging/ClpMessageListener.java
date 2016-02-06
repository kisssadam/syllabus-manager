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

package hu.unideb.inf.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import hu.unideb.inf.service.ClpSerializer;
import hu.unideb.inf.service.CourseLocalServiceUtil;
import hu.unideb.inf.service.CourseServiceUtil;
import hu.unideb.inf.service.CourseTypeLocalServiceUtil;
import hu.unideb.inf.service.CourseTypeServiceUtil;
import hu.unideb.inf.service.CurriculumLocalServiceUtil;
import hu.unideb.inf.service.CurriculumServiceUtil;
import hu.unideb.inf.service.SemesterLocalServiceUtil;
import hu.unideb.inf.service.SemesterServiceUtil;
import hu.unideb.inf.service.SubjectLocalServiceUtil;
import hu.unideb.inf.service.SubjectServiceUtil;

/**
 * @author Adam Kiss
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			CourseLocalServiceUtil.clearService();

			CourseServiceUtil.clearService();
			CourseTypeLocalServiceUtil.clearService();

			CourseTypeServiceUtil.clearService();
			CurriculumLocalServiceUtil.clearService();

			CurriculumServiceUtil.clearService();
			SemesterLocalServiceUtil.clearService();

			SemesterServiceUtil.clearService();
			SubjectLocalServiceUtil.clearService();

			SubjectServiceUtil.clearService();
		}
	}
}