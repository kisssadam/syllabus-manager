package hu.unideb.inf.web.util;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

public class SyllabusCSVUtil {

	public static String encode(Object obj) {
		Class<?> clazz = obj.getClass();

		if (!clazz.isArray()) {
			return encode(String.valueOf(obj));
		}

		Object[] array = (Object[]) obj;

		return encode(StringUtil.merge(array));
	}

	public static String encode(Integer n) {
		return encode(n == null ? StringPool.BLANK : String.valueOf(n));
	}

	public static String encode(Long n) {
		return encode(n == null ? StringPool.BLANK : String.valueOf(n));
	}

	public static String encode(String s) {
		if (s == null) {
			return StringPool.BLANK;
		}
		return s;
	}

	public static String decode(String s) {
		if (s == null) {
			return null;
		}
		return s;
	}

}
