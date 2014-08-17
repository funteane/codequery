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

@Service("iP138IpQueryService")
public class IP138IpQueryService implements IQueryService<IP>{
	
	private final static String QUERYURL = "http://ip138.com/ips138.asp?action=2&ip=";

	@Override
	public IP query(String code) throws Exception {
		String[] result = HttpClientUtil.dispatchGetRequest(QUERYURL.concat(code), HttpClientUtil.GB2312);
		if (result[0].equals(String.valueOf(HttpStatus.SC_OK))) {
			IP ip = IP.getInstance().clone();
			
			Document document = Jsoup.parse(result[1]);
			Elements tables = document.getElementsByTag("table");
			Element element = tables.last();
			
			Elements tableRows = element.getElementsByTag("tr");
			Element tableCol = null;;
			Elements tableCols = tableRows.get(2).children();
			//电话号码
			tableCol = tableCols.get(0);
			Elements lies = tableCol.getElementsByTag("li");
			
			String[] contents = StringUtil.filter(lies.first().html()).split(" ");
			ip.setAddress("202.68.241.3");
			ip.setArea(contents[0].substring(6));
			if (contents.length > 1) {
				ip.setCorpration(contents[1]);
			}
			return ip;
			
		}
		return null;
	}
	
	
	public static void main(String[] args) throws Exception {
		String[] result = HttpClientUtil.dispatchGetRequest(QUERYURL.concat("202.68.241.3"), HttpClientUtil.GB2312);
		
		if (result[0].equals(String.valueOf(HttpStatus.SC_OK))) {
			IP ip = IP.getInstance().clone();
			
			Document document = Jsoup.parse(result[1]);
			Elements tables = document.getElementsByTag("table");
			Element element = tables.last();
			
			Elements tableRows = element.getElementsByTag("tr");
			Element tableCol = null;;
			Elements tableCols = tableRows.get(2).children();
			//电话号码
			tableCol = tableCols.get(0);
			Elements lies = tableCol.getElementsByTag("li");
			
			String[] contents = StringUtil.filter(lies.first().html()).split(" ");
			ip.setAddress("202.68.241.3");
			ip.setArea(contents[0].substring(6));
			if (contents.length > 1) {
				ip.setCorpration(contents[1]);
			}
			
			System.out.println(ip);
			
			
		}
	}

}
