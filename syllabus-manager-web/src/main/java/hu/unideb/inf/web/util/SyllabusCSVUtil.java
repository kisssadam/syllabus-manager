package hu.unideb.inf.web.util;

import com.liferay.portal.kernel.util.CSVUtil;
import com.liferay.portal.kernel.util.StringPool;

public class SyllabusCSVUtil extends CSVUtil {

	public static String encode(Object obj) {
		return CSVUtil.encode(obj);
	}

	public static String encode(Integer n) {
		return encode(n == null ? StringPool.BLANK : String.valueOf(n));
	}

	public static String encode(Long n) {
		return encode(n == null ? StringPool.BLANK : String.valueOf(n));
	}

	public static String encode(String s) {
		return s == null ? StringPool.BLANK : CSVUtil.encode(s);
	}

}
