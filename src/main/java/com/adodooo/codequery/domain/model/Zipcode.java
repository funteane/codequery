package com.adodooo.codequery.domain.model;

import javax.persistence.Column;
import javax.persistence.Table;

import javax.persistence.Entity;

import com.dreammore.framework.codegeneration.model.Comment;
import com.dreammore.framework.common.model.BaseIncEntity;

@Entity
@Table(name = "ZIPCODE")
public class Zipcode extends BaseIncEntity {

	private static final long serialVersionUID = 3432768998439408737L;

	@Comment(value = "地域编码", searchable = true)
	@Column(name = "AREA_CODE")
	private String areaCode;

	@Comment(value = "邮政编码", searchable = true)
	@Column(name = "POST_CODE")
	private String postCode;

	@Comment(value = "区号")
	@Column(name = "ZONE_CODE")
	private String zoneCode;

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getZoneCode() {
		return zoneCode;
	}

	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}

}
