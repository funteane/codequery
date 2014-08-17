package com.adodooo.codequery.application.service;

import org.apache.commons.httpclient.HttpStatus;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.adodooo.codequery.common.HttpClientUtil;
import com.adodooo.codequery.common.StringUtil;
import com.adodooo.codequery.domain.model.Mobile;

@Service("ip138MobileQueryService")
public class Ip138MobileQueryService implements IQueryService<Mobile> {
	
	private final static String QUERYURL = "http://www.ip138.com:8080/search.asp?action=mobile&mobile=";

	@Override
	public Mobile query(String code) throws Exception {

		String[] result = HttpClientUtil.dispatchGetRequest(QUERYURL.concat(code), HttpClientUtil.GB2312);
		if (result[0].equals(String.valueOf(HttpStatus.SC_OK))) {
			Mobile mobile = Mobile.getInstance().clone();
			
			Document document = Jsoup.parse(result[1]);
			Elements tables = document.getElementsByTag("table");
			Element element = tables.last();
			
			Elements tableRows = element.getElementsByTag("tr");
			Element tableCol = null;;
			Elements tableCols = tableRows.get(1).children();
			//电话号码
			tableCol = tableCols.get(1);
			mobile.setNetCode(StringUtil.filter(tableCol.html()).substring(0, 7));
			//地区
			tableCols = tableRows.get(2).children();
			tableCol = tableCols.get(1);
			String[] regions = StringUtil.filter(tableCol.html()).split(" ");
			mobile.setProvince(regions[0]);
			if (regions.length == 2) {
				mobile.setCity(regions[1]);
			}else {
				mobile.setCity(regions[0]);
			}
			//卡类型
			tableCols = tableRows.get(3).children();
			tableCol = tableCols.get(1);
			mobile.setCorpration(StringUtil.filter(tableCol.html()));
			//区号
			tableCols = tableRows.get(4).children();
			tableCol = tableCols.get(1);
			mobile.setAreaCode(StringUtil.filter(tableCol.html()));
			//邮编
			tableCols = tableRows.get(5).children();
			tableCol = tableCols.get(1);
			mobile.setPostCode(StringUtil.filter(tableCol.html()));
			
			mobile.setPhoneCode(code);
			
			return mobile;
		}
		return null;

	}
	
	
	

}
