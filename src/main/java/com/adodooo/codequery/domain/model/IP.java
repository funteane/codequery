package com.adodooo.codequery.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.dreammore.framework.codegeneration.model.Comment;
import com.dreammore.framework.common.model.BaseIncEntity;

@Entity
@Table(name = "IP")
public class IP extends BaseIncEntity implements Cloneable {

	private static final long serialVersionUID = -5507523127660766243L;
	
//	@Comment(value = "网络地址", searchable = true)
//	private String netAdress;
	
	@Comment(value = "IP地址", searchable = true)
	@Column(name = "ADDRESS")
	private String address;
	
	@Comment(value = "归属省份")
	@Column(name = "AREA")
	private String area;

	@Comment(value = "所属公司")
	@Column(name = "CORPRATION")
	private String corpration;
	
	@Column(name = "REGION")
	private String region;
	
	@Column(name = "PLACE_NAME")
	private String placeName;
	
	
	private static IP instance = new IP();
	
	private IP () {
		
	}

	public static IP getInstance() {
		return instance;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCorpration() {
		return corpration;
	}

	public void setCorpration(String corpration) {
		this.corpration = corpration;
	}
	
	@Override
	public IP clone() throws CloneNotSupportedException {
		return (IP) super.clone();
	}
	
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	@Override
	public String toString() {
		return "IP [address=" + address + ", area=" + area + ", corpration="
				+ corpration + ", region=" + region + "]";
	}

	
}
