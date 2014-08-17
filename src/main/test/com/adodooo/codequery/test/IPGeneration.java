package com.adodooo.codequery.test;

import com.adodooo.codequery.domain.model.IP;

public class IPGeneration extends Generation{

	@Override
	public Class<?> getTargetClazz() {
		return IP.class;
	}
	
	
	public static void main(String[] args) throws Exception {
		Generation generation = new IPGeneration();
		generation.generateServiceInteface();
		generation.generateServiceImpl();
	}
	

}
