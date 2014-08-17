package com.adodooo.codequery.test;

import com.adodooo.codequery.domain.model.City;


public class CityGeneration extends Generation {
	
	@Override
	public Class<?> getTargetClazz() {
		return City.class;
	}
	
	public static void main(String[] args) throws Exception {
		Generation generation = new CityGeneration();
		generation.generateServiceInteface();
		generation.generateServiceImpl();
	}

}
