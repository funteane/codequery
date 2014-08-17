package com.adodooo.codequery.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.dreammore.framework.codegeneration.model.Comment;
import com.dreammore.framework.common.model.BaseUidEntity;

@Entity
@Table(name = "AREA")
public class Area extends BaseUidEntity {

	private static final long serialVersionUID = 159035421287516502L;

	@Comment(value = "地域编码", searchable = true)
	@Column(name = "CITY_CODE")
	private String cityCode;

	@Comment(value = "地区编码", searchable = true)
	@Column(name = "AREA_CODE")
	private String areaCode;

	@Column(name = "AREA_NAME")
	private String areaName;

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

}
