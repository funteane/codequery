package com.adodooo.codequery.common;

import com.dreammore.framework.common.utils.Tools;

public final class StringUtil {
	
	public static String filter(String source) {
		if (Tools.empty(source)) {
			return "";
		}
//		source = source.replaceAll("<(\\S*?)[^>]*>.*?</\\1>|<.*? />", "");
		source = source.replaceAll("<(.*)>(.*)<\\/(.*)>|<(.*)\\/>", "");
		source = source.replace("&nbsp;", " ");
		source = source.trim();
		return source;
	}	

}
