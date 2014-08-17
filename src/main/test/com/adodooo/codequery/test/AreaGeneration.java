package com.adodooo.codequery.test;

import com.adodooo.codequery.domain.model.Area;

public class AreaGeneration extends Generation {
	
	@Override
	public Class<?> getTargetClazz() {
		return Area.class;
	}
	
	public static void main(String[] args) throws Exception {
		Generation generation = new AreaGeneration();
		generation.generateServiceInteface();
		generation.generateServiceImpl();
	}

}
