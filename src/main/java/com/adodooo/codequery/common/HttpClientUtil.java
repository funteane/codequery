package com.adodooo.codequery.common;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class HttpClientUtil {
	
    public static final String US_ASCII = "US-ASCII";
    public static final String ISO_8859_1 = "ISO-8859-1";
    public static final String UTF_8 = "UTF-8";
    public static final String UTF_16BE = "UTF-16BE";
    public static final String UTF_16LE = "UTF-16LE";
    public static final String UTF_16 = "UTF-16";
    public static final String GBK = "GBK";
    
    public static final String GB2312 = "GB2312";
	
	public static String[] dispatchGetRequest(String url, String encode) throws Exception {
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(url);
		HttpMethodParams params = method.getParams();
		params.setContentCharset(encode);
		int result = client.executeMethod(method); 
		String resultContent = method.getResponseBodyAsString();
		return new String[]{String.valueOf(result), resultContent};
	}
	
	public static String[] dispatchPostRequest(String url, String encode, String[] names, String[] values) throws Exception {
		HttpClient client = new HttpClient();
		NameValuePair[] nameValuePairs = new NameValuePair[names.length];
		for (int i = 0; i < names.length; i++) {
			nameValuePairs[i] = new NameValuePair(names[i], values[i]);
		}
		PostMethod method = new PostMethod(url);
		method.setRequestBody(nameValuePairs);
		HttpMethodParams params = method.getParams();
		params.setContentCharset(encode);
		int result = client.executeMethod(method); 
		String resultContent = method.getResponseBodyAsString();
		return new String[]{String.valueOf(result), resultContent};
	}

}
