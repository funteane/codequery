package com.adodooo.codequery.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adodooo.codequery.domain.model.IP;
import com.dreammore.framework.common.dao.ICommonDAO;
import com.dreammore.framework.common.dao.PageBean;
import com.dreammore.framework.common.utils.Tools;

@Service
public class IPServiceImpl implements IIPService {

	@Autowired
	private ICommonDAO commonDAO;

	@Override
	public PageBean<IP> getAllIPs(PageBean<IP> pageBean, IP ip, List<Long> ids) {

		List<String> paramNames = new ArrayList<String>();
		List<Object> paramValues = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer("FROM IP WHERE 1 = 1 ");

		if (!Tools.empty(ip.getAddress())) {
			hql.append("AND address  = :address ");
			paramNames.add("adress");
			paramValues.add(ip.getAddress());
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
	public IP getIp(String address) {
		String hql = "FROM IP WHERE address = ?";
		List<IP> results = commonDAO.findTop(hql, 1, address);
		return Tools.empty(results) ? null : results.get(0);
	}

}