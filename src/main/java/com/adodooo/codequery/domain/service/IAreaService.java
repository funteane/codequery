package com.adodooo.codequery.domain.service;

import java.util.List;

import com.adodooo.codequery.domain.model.Area;
import com.dreammore.framework.common.dao.PageBean;

public interface IAreaService {

	public PageBean<Area> getAllAreas(PageBean<Area> pageBean, Area area,
			List<Long> ids);

}
