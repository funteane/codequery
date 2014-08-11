package com.adodooo.codequery.application.service;

import org.apache.commons.httpclient.HttpStatus;
import org.springframework.stereotype.Service;

import com.adodooo.codequery.common.HttpClientUtil;
import com.adodooo.codequery.domain.model.Mobile;
import com.mongodb.BasicDBObject;
import com.mongodb.util.JSON;


@Service("showJiQueryService")
public class ShowJiQueryService implements IQueryService<Mobile>{
	
	private final static String QUERYURL = "http://api.showji.com/Locating/www.show.ji.c.o.m.aspx?output=json&callback=&m=";

	@Override
	public Mobile query(String code) throws Exception {
		String[] result = HttpClientUtil.dispatchGetRequest(QUERYURL.concat(code), HttpClientUtil.UTF_8);
		if (result[0].equals(String.valueOf(HttpStatus.SC_OK))) {
			Mobile mobile = Mobile.getInstance().clone();
			BasicDBObject dbObject = (BasicDBObject) JSON.parse(result[1]);
			mobile.setAreaCode(dbObject.getString("AreaCode"));
			mobile.setPhoneCode(dbObject.getString("Mobile"));
			mobile.setProvince(dbObject.getString("Province"));
			mobile.setCity(dbObject.getString("City"));
			mobile.setPostCode(dbObject.getString("PostCode"));
			mobile.setCorpration(dbObject.getString("Corp"));
			return mobile;
		}
		return null;
	}
	
	

}
