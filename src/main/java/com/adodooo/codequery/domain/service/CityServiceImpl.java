package com.adodooo.codequery.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adodooo.codequery.domain.model.City;
import com.dreammore.framework.common.dao.ICommonDAO;
import com.dreammore.framework.common.dao.PageBean;
import com.dreammore.framework.common.utils.Tools;

@Service
public class CityServiceImpl implements ICityService {

	@Autowired
	private ICommonDAO commonDAO;

	@Override
	public PageBean<City> getAllCitys(PageBean<City> pageBean, City city,
			List<Long> ids) {

		List<String> paramNames = new ArrayList<String>();
		List<Object> paramValues = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer("FROM City WHERE 1 = 1 ");

		if (!Tools.empty(city.getProvinceCode())) {
			hql.append("AND provinceCode  = :provinceCode ");
			paramNames.add("provinceCode");
			paramValues.add(city.getProvinceCode());
		}

		if (!Tools.empty(city.getCityCode())) {
			hql.append("AND cityCode  = :cityCode ");
			paramNames.add("cityCode");
			paramValues.add(city.getCityCode());
		}

		if (!Tools.empty(ids)) {
			hql.append("AND id IN (:ids) ");
			paramNames.add("ids");
			paramValues.add(ids);
		}

		hql.append("ORDER BY id DESC");

		String[] names = new String[paramNames.size()];
		Object[] values = new Object[paramValues.size()];
		Tools.list2Array(paramNames, names);
		Tools.list2Array(paramValues, values);

		commonDAO.find(hql.toString(), pageBean, names, values);

		return pageBean;
	}

}
