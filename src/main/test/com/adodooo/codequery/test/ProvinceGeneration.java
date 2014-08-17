package com.adodooo.codequery.test;

import com.adodooo.codequery.domain.model.Province;

public class ProvinceGeneration extends Generation{
	
	@Override
	public Class<?> getTargetClazz() {
		return Province.class;
	}
	
	public static void main(String[] args) throws Exception {
		Generation generation = new ProvinceGeneration();
		generation.generateServiceInteface();
		generation.generateServiceImpl();
	}

}
