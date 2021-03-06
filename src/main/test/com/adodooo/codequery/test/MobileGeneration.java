package com.adodooo.codequery.test;

import com.adodooo.codequery.domain.model.Mobile;
import com.adodooo.codequery.test.Generation;


public class MobileGeneration extends Generation{

	@Override
	public Class<?> getTargetClazz() {
		return Mobile.class;
	}
	
	public static void main(String[] args) throws Exception {
		Generation generation = new MobileGeneration();
		generation.generateServiceInteface();
		generation.generateServiceImpl();
	}


}
