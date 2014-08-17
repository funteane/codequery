package com.adodooo.codequery.application.service;

import org.apache.commons.httpclient.HttpStatus;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.adodooo.codequery.common.HttpClientUtil;
import com.adodooo.codequery.common.StringUtil;
import com.adodooo.codequery.domain.model.IP;


@Service("chinazIpQueryService")
public class ChinazIpQueryService implements IQueryService<IP> {

	private final static String QUERYURL = "http://ip.chinaz.com/?IP=";

	@Override
	public IP query(String code) throws Exception {
		String[] result = HttpClientUtil.dispatchGetRequest(	QUERYURL.concat(code), HttpClientUtil.GB2312);
		if (result[0].equals(String.valueOf(HttpStatus.SC_OK))) {
			IP ip = IP.getInstance().clone();

			Document document = Jsoup.parse(result[1]);
			Element element = document.getElementById("status");
			String[] contents = StringUtil.filter(element.select(".red").html()).split(" "); 
			ip.setAddress(code);
			ip.setArea(contents[5]);
			if (contents.length > 6) {
				ip.setCorpration(contents[6]);
			}
			
			return ip;
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		String[] result = HttpClientUtil.dispatchGetRequest(	QUERYURL.concat("60.21.160.2"), HttpClientUtil.GB2312);
		if (result[0].equals(String.valueOf(HttpStatus.SC_OK))) {
			IP ip = IP.getInstance().clone();

			Document document = Jsoup.parse(result[1]);
			Element element = document.getElementById("status");
			String[] contents = StringUtil.filter(element.select(".red").html()).split(" "); 
			ip.setAddress("60.21.160.2");
			ip.setArea(contents[contents.length -2]);
			ip.setCorpration(contents[contents.length -1]);
			System.err.println(ip);
		}
	}

}
