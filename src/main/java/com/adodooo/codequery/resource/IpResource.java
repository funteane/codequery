package com.adodooo.codequery.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.adodooo.codequery.application.service.IQueryService;
import com.adodooo.codequery.common.RegionUtil;
import com.adodooo.codequery.domain.model.IP;
import com.adodooo.codequery.domain.service.IIPService;
import com.dreammore.framework.common.ServiceFactory;
import com.dreammore.framework.common.service.ICommonService;
import com.dreammore.framework.common.utils.Tools;


@Path("ip/{ipCode}")
public class IpResource extends Resource{
	
	@Autowired
	private IIPService ipService;
	@Autowired
	private ICommonService commonService;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIp(@PathParam("ipCode") String ipCode) {
		IP ip = null;
		try {
			logger.info("first, query from db");
			ip = ipService.getIp(ipCode);
			
			if (!Tools.empty(ip)) {
				return ip.getRegion();
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		IQueryService<IP> queryService = null;
		try {
			logger.info("second, query from chinaz.com");
			queryService = (IQueryService<IP>) ServiceFactory.getBean("chinazIpQueryService");
			ip = queryService.query(ipCode);
			if (!Tools.empty(ip) && !Tools.empty(ip.getArea())) {
				//查询到region与place
				String place = RegionUtil.getRegion(ip.getArea());
				ip.setPlaceName(place);
				ip.setRegion(RegionUtil.PLACE_MAP.get(place));
				commonService.saveOrupdate(ip);
				return ip.getRegion();
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		try {
			logger.info("third, query from ip138.com");
			queryService = (IQueryService<IP>) ServiceFactory.getBean("iP138IpQueryService");
			ip = queryService.query(ipCode);
			if (!Tools.empty(ip) && !Tools.empty(ip.getArea())) {
				String place = RegionUtil.getRegion(ip.getArea());
				ip.setPlaceName(place);
				ip.setRegion(RegionUtil.PLACE_MAP.get(place));
				commonService.saveOrupdate(ip);
				return ip.getRegion();
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		  
		return null;
	}
	
	

}
