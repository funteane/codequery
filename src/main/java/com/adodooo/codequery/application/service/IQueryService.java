package com.adodooo.codequery.application.service;



public interface IQueryService <T> {
	
	T query(String code) throws Exception;
	
}
