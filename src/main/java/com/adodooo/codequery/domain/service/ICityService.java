package com.adodooo.codequery.domain.service;

import java.util.List;

import com.adodooo.codequery.domain.model.City;
import com.dreammore.framework.common.dao.PageBean;

public interface ICityService {

	public PageBean<City> getAllCitys(PageBean<City> pageBean, City city,
			List<Long> ids);

}
