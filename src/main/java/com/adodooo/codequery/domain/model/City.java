package com.adodooo.codequery.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.dreammore.framework.codegeneration.model.Comment;
import com.dreammore.framework.common.model.BaseUidEntity;

@Entity
@Table(name = "CITY")
public class City extends BaseUidEntity {

	private static final long serialVersionUID = 812220026822758445L;

	@Comment(value = "省份编码", searchable = true)
	@Column(name = "PROVINCE_CODE")
	private String provinceCode;
	
	@Comment(value = "地域编码", searchable = true)
	@Column(name = "CITY_CODE")
	private String cityCode;
	
	@Column(name = "CITY_NAME")
	private String cityName;

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
