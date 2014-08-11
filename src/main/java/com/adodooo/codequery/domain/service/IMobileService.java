package com.adodooo.codequery.domain.service;

import java.io.Serializable;
import java.util.List;

import com.adodooo.codequery.domain.model.Mobile;
import com.dreammore.framework.common.dao.PageBean;

public interface IMobileService {

	public PageBean<Mobile> getAllMobiles(PageBean<Mobile> pageBean,
			Mobile mobile, List<Long> ids);
	
	public Mobile getMobile(String phoneCode);
	
	public Serializable saveOrUpdate(Mobile mobile);

}
