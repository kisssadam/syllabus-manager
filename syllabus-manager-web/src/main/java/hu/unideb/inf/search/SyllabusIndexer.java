package hu.unideb.inf.search;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelper;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import hu.unideb.inf.model.Syllabus;
import hu.unideb.inf.service.SyllabusLocalService;
import hu.unideb.inf.service.permission.SyllabusPermission;
import hu.unideb.inf.util.SyllabusActionKeys;

@Component(
	immediate = true,
	service = Indexer.class
)
public class SyllabusIndexer extends BaseIndexer<Syllabus> {

	public static final String CLASS_NAME = Syllabus.class.getName();
	
	private SyllabusLocalService syllabusLocalService;
	
	private IndexWriterHelper indexWriterHelper;
	
	public SyllabusIndexer() {
		setDefaultSelectedFieldNames(
			Field.ASSET_TAG_NAMES, Field.COMPANY_ID, Field.CONTENT,
			Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK, Field.GROUP_ID,
			Field.MODIFIED_DATE, Field.SCOPE_GROUP_ID, Field.TITLE, Field.UID);
		setFilterSearch(true);
		setPermissionAware(true);
	}
	
	@Reference(unbind = "-")
	public void setSyllabusLocalService(SyllabusLocalService syllabusLocalService) {
		this.syllabusLocalService = syllabusLocalService;
	}
	
	@Reference
	public void setIndexWriterHelper(IndexWriterHelper indexWriterHelper) {
		this.indexWriterHelper = indexWriterHelper;
	}
	
	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public boolean hasPermission(PermissionChecker permissionChecker, String entryClassName, long entryClassPK,
			String actionId) throws Exception {
		Syllabus syllabus = syllabusLocalService.getSyllabus(entryClassPK);
		
		return SyllabusPermission.contains(permissionChecker, syllabus.getSyllabusId(), SyllabusActionKeys.VIEW);
	}
	
	@Override
	public boolean isVisible(long classPK, int status) throws Exception {
		Syllabus syllabus = syllabusLocalService.getSyllabus(classPK);
		
		return isVisible(syllabus.getStatus(), status);
	}
	
	@Override
	protected void doDelete(Syllabus syllabus) throws Exception {
		deleteDocument(syllabus.getCompanyId(), syllabus.getSyllabusId());
	}

	@Override
	protected Document doGetDocument(Syllabus syllabus) throws Exception {
		Document document = getBaseModelDocument(CLASS_NAME, syllabus);
		
		document.addText(Field.DESCRIPTION, "Syllabus description, id: " + syllabus.getSyllabusId());
		
		String title = "Syllabus title, id: " + syllabus.getSyllabusId();
		document.addText(Field.TITLE, title);
		
		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletRequest portletRequest,
			PortletResponse portletResponse) throws Exception {
		Summary summary = createSummary(document, Field.TITLE, Field.CONTENT);
		summary.setMaxContentLength(200);
		return summary;
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		Syllabus syllabus = syllabusLocalService.getSyllabus(classPK);
		doReindex(syllabus);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		// TODO ez nem pont igy volt implementalva a peldaban: https://github.com/liferay/liferay-portal/blob/master/modules/apps/collaboration/wiki/wiki-service/src/main/java/com/liferay/wiki/search/WikiNodeIndexer.java
		for (String id : ids) {
			Syllabus syllabus = syllabusLocalService.getSyllabus(Long.valueOf(id));
			doReindex(syllabus);
		}
	}

	@Override
	protected void doReindex(Syllabus syllabus) throws Exception {
		Document document = getDocument(syllabus);
		
		indexWriterHelper.updateDocument(getSearchEngineId(), syllabus.getCompanyId(), document, isCommitImmediately());
	}

}
