package com.adodooo.codequery.test;

import com.dreammore.framework.codegeneration.service.AbstractGeneration;
import com.dreammore.framework.codegeneration.service.HtmlDivGeneration;
import com.dreammore.framework.codegeneration.service.HtmlListGeneration;
import com.dreammore.framework.codegeneration.service.ServiceImplGeneration;
import com.dreammore.framework.codegeneration.service.ServiceIntefaceGeneration;
import com.dreammore.framework.codegeneration.service.SpringmvcControllerGeneration;
import com.dreammore.framework.codegeneration.service.ValidateJsGeneration;

public abstract class Generation {
	
	private static String service_path = "H:/workspace/02/devicesystem/src/main/java/com/dreammore/microcaryum/devicesystem/domain/service/";
	private static String controller_path = "H:/workspace/02/devicesystem/src/main/java/com/dreammore/microcaryum/devicesystem/application/controller/";
	private static String js_path = "";
	private static String vm_path = "";
	
	public abstract Class<?> getTargetClazz();
	
	public void generateServiceInteface() throws Exception{
		AbstractGeneration generation = new ServiceIntefaceGeneration(service_path);
		System.out.println(generation.generate(getTargetClazz()));
//		generation.write(getTargetClazz());
		
	}
	
	public void generateServiceImpl() throws Exception{
		AbstractGeneration  generation = new ServiceImplGeneration(service_path);
		System.out.println(generation.generate(getTargetClazz()));
//		generation.write(getTargetClazz());
		
	}
	
	public void generateSpringmvcController() throws Exception{
		AbstractGeneration generation = new SpringmvcControllerGeneration(controller_path);
	    System.out.println(generation.generate(getTargetClazz()));
//		generation.write(getTargetClazz());
	}
	
	public void generateValidateJs() throws Exception{
		AbstractGeneration  generation = new ValidateJsGeneration(js_path);
		System.out.println(generation.generate(getTargetClazz()));
//		generation.write(getTargetClazz());
	}
	
	public void generateHtmlList() throws Exception{
		AbstractGeneration  generation = new HtmlListGeneration(vm_path);
		System.err.println(generation.generate(getTargetClazz()));
//		generation.write(getTargetClazz());
		
	}
	
	public void generateHtmlDiv() throws Exception{
		AbstractGeneration generation = new HtmlDivGeneration(vm_path);
		System.out.println(generation.generate(getTargetClazz()));
//		generation.write(getTargetClazz());
	}
	
	
	
//  
//  System.out.println("----------------------------------------");
		
		

//  
////  
	
	
	

}
