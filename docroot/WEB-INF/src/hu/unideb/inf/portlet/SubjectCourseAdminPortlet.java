package hu.unideb.inf.portlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SubjectCourseAdminPortlet
 */
public class SubjectCourseAdminPortlet extends MVCPortlet {

	private final static String fileInputName = "fileupload";

	public void upload(ActionRequest request, ActionResponse response) throws Exception {
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);

		File uploadedFile = uploadRequest.getFile(fileInputName);

		try (BufferedReader br = new BufferedReader(new FileReader(uploadedFile))) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}
	}

}
