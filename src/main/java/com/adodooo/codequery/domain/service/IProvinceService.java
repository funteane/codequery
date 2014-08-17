package com.adodooo.codequery.domain.service;

import java.util.List;

import com.adodooo.codequery.domain.model.Province;
import com.dreammore.framework.common.dao.PageBean;

public interface IProvinceService {

	public PageBean<Province> getAllProvinces(PageBean<Province> pageBean,
			Province province, List<Long> ids);

}
