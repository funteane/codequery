package com.adodooo.codequery.domain.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adodooo.codequery.domain.model.Mobile;
import com.dreammore.framework.common.dao.ICommonDAO;
import com.dreammore.framework.common.dao.PageBean;
import com.dreammore.framework.common.utils.Tools;

@Service
public class MobileServiceImpl implements IMobileService {

	@Autowired
	private ICommonDAO commonDAO;

	@Override
	public PageBean<Mobile> getAllMobiles(PageBean<Mobile> pageBean,
			Mobile mobile, List<Long> ids) {

		List<String> paramNames = new ArrayList<String>();
		List<Object> paramValues = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer("FROM Mobile WHERE 1 = 1 ");

		if (!Tools.empty(mobile.getPhoneCode())) {
			hql.append("AND phoneCode  = :phoneCode ");
			paramNames.add("phoneCode");
			paramValues.add(mobile.getPhoneCode());
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
	
	@Override
	public Mobile getMobile(String phoneCode) {
		String hql = "FROM Mobile WHERE netCode = ? ";
		List<Mobile> results = commonDAO.findTop(hql, 1, phoneCode.substring(0, 7));
		return Tools.empty(results) ? null : results.get(0);
	}
	
	@Override
	public Serializable saveOrUpdate(Mobile mobile) {
		mobile.setNetCode(mobile.getPhoneCode().substring(0, 7));
		commonDAO.saveOrupdate(mobile);
		return mobile.getId();
	}

}