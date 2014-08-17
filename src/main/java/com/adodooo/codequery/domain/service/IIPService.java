package com.adodooo.codequery.domain.service;

import java.util.List;

import com.adodooo.codequery.domain.model.IP;
import com.dreammore.framework.common.dao.PageBean;

public interface IIPService {

	public PageBean<IP> getAllIPs(PageBean<IP> pageBean, IP ip, List<Long> ids);
	
	public IP getIp(String address);

}
