package com.adodooo.codequery.resource;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.adodooo.codequery.application.service.IQueryService;
import com.adodooo.codequery.common.JSONSimpler;
import com.adodooo.codequery.common.RegionUtil;
import com.adodooo.codequery.domain.model.Mobile;
import com.adodooo.codequery.domain.service.IMobileService;
import com.dreammore.framework.common.ServiceFactory;
import com.dreammore.framework.common.utils.Tools;

//@Component
@Path("mobiles/{phoneCode}")
public class MobilesResource {
	
	private Logger logger = Logger.getLogger(getClass());
	
	private final static String EMPTY_ELEMENT = "{}";
	
//	@Autowired
//	private IQueryService<Mobile> showJiQueryService;
//	@Resource
//	private IQueryService<Mobile> ip138MobileQueryService;
	@Autowired
	private IMobileService mobileService;
	
	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getMobileInfo(@PathParam("phoneCode") String phoneCode) {
		Mobile mobile = null;
		try {
			logger.info("first, query from db");
			mobile = mobileService.getMobile(phoneCode);
			mobile.setPhoneCode(phoneCode);
			if (!Tools.empty(mobile)) {
				return JSONSimpler.toJson(mobile);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		IQueryService<Mobile> queryService = null;
		try {
			logger.info("second, query from ip138.com");
			queryService = (IQueryService<Mobile>) ServiceFactory.getBean("ip138MobileQueryService");
			mobile = queryService.query(phoneCode);
			if (!Tools.empty(mobile) && !Tools.empty(mobile.getProvince())) {
				String place = RegionUtil.getRegion(mobile.getProvince());
				mobile.setPlaceName(place);
				mobile.setRegion(RegionUtil.PLACE_MAP.get(place));
				mobileService.saveOrUpdate(mobile);
				return JSONSimpler.toJson(mobile);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		try {
			logger.info("second, query from showji.com");
			queryService = (IQueryService<Mobile>) ServiceFactory.getBean("showJiQueryService");
			mobile = queryService.query(phoneCode);
			if (!Tools.empty(mobile) && !Tools.empty(mobile.getProvince())) {
				String place = RegionUtil.getRegion(mobile.getProvince());
				mobile.setPlaceName(place);
				mobile.setRegion(RegionUtil.PLACE_MAP.get(place));
				mobileService.saveOrUpdate(mobile);
				mobileService.saveOrUpdate(mobile);
				return JSONSimpler.toJson(mobile);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		
		return EMPTY_ELEMENT;
		
		
		
		
	}
	

}
