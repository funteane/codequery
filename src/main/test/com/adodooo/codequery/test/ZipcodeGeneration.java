package com.adodooo.codequery.test;

import com.adodooo.codequery.domain.model.Zipcode;

public class ZipcodeGeneration extends Generation {
	
	@Override
	public Class<?> getTargetClazz() {
		return Zipcode.class;
	}
	
	public static void main(String[] args) throws Exception {
		Generation generation = new ZipcodeGeneration();
		generation.generateServiceInteface();
		generation.generateServiceImpl();
	}

}
