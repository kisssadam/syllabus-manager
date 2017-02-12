package hu.unideb.inf.search;

import java.util.Collections;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.search.BaseSearcher;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.generic.MatchQuery;
import com.liferay.portal.kernel.search.generic.MultiMatchQuery;
import com.liferay.portal.kernel.search.generic.MultiMatchQuery.Type;
import com.liferay.portal.kernel.util.StringUtil;

import hu.unideb.inf.model.Syllabus;
import hu.unideb.inf.service.SyllabusLocalService;

@Component(
	immediate = true,
	service = SyllabusSearcher.class
)
public class SyllabusSearcher extends BaseSearcher {

	public static final String[] CLASS_NAMES = {
		Syllabus.class.getName()
	};
	
	private SyllabusLocalService syllabusLocalService;

	@Reference(unbind = "-")
	public void setSyllabusLocalService(SyllabusLocalService syllabusLocalService) {
		this.syllabusLocalService = syllabusLocalService;
	}
	
	public SyllabusSearcher() {
		setDefaultSelectedFieldNames(Field.TITLE, Field.CONTENT);
		setFilterSearch(true);
		setPermissionAware(true);
	}

	@Override
	public String[] getSearchClassNames() {
		return CLASS_NAMES;
	}
	
	@Override
	public void postProcessContextBooleanFilter(BooleanFilter contextBooleanFilter, SearchContext searchContext)
			throws Exception {
		super.postProcessContextBooleanFilter(contextBooleanFilter, searchContext);
	}
	
	@Override
	public void postProcessSearchQuery(
			BooleanQuery searchQuery, BooleanFilter fullQueryBooleanFilter,
			SearchContext searchContext)
		throws Exception {

		MultiMatchQuery multiMatchQuery = new MultiMatchQuery(StringUtil.toLowerCase(searchContext.getKeywords()));
		multiMatchQuery.setType(Type.PHRASE);

		searchQuery.add(multiMatchQuery, BooleanClauseOccur.MUST);
	}
	
	@Override
	protected Map<String, Query> addSearchKeywords(BooleanQuery searchQuery, SearchContext searchContext)
			throws Exception {
		return Collections.emptyMap();
	}
	
}
