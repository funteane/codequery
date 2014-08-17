package com.adodooo.codequery.domain.service;

import java.util.List;

import com.adodooo.codequery.domain.model.Zipcode;
import com.dreammore.framework.common.dao.PageBean;

public interface IZipcodeService {

	public PageBean<Zipcode> getAllZipcodes(PageBean<Zipcode> pageBean,
			Zipcode zipcode, List<Long> ids);

}
