package com.adodooo.codequery.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.dreammore.framework.codegeneration.model.Comment;
import com.dreammore.framework.common.model.BaseIncEntity;

//{"Mobile":"13661368411","QueryResult":"True","TO":"中国移动","Corp":"中国移动",
//"Province":"北京","City":"北京","AreaCode":"010","PostCode":"100000","VNO":"","Card":""}

@Entity
@Table
public class Mobile extends BaseIncEntity implements Cloneable {

	private static final long serialVersionUID = -1989110817025501122L;

	@Comment(value = "手机号码", searchable = true)
	@Transient
	private String phoneCode;

	@Comment(value = "网络号码", searchable = true)
	@Column(name = "NET_CODE", unique = true)
	private String netCode;

	@Comment(value = "归属省份")
	@Column(name = "PRIVINCE")
	private String province;

	@Comment(value = "归属地市")
	@Column(name = "CITY")
	private String city;

	@Comment(value = "区号")
	@Column(name = "AREA_CODE")
	private String areaCode;

	@Comment(value = "邮政编码")
	@Column(name = "POST_CODE")
	private String postCode;

	@Comment(value = "所属公司")
	@Column(name = "CORPRATION")
	private String corpration;
	
	@Column(name = "REGION")
	private String region;
	
	@Column(name = "PLACE_NAME")
	private String placeName;

	private static Mobile instance = new Mobile();

	private Mobile() {

	}

	public static Mobile getInstance() {
		return instance;
	}

	public String getPhoneCode() {
		return phoneCode;
	}

	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

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

	public String getCorpration() {
		return corpration;
	}

	public void setCorpration(String corpration) {
		this.corpration = corpration;
	}

	public String getNetCode() {
		return netCode;
	}

	public void setNetCode(String netCode) {
		this.netCode = netCode;
	}
	
	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public Mobile clone() throws CloneNotSupportedException {
		return (Mobile) super.clone();
	}

	@Override
	public String toString() {
		return "Mobile [phoneCode=" + phoneCode + ", netCode=" + netCode
				+ ", province=" + province + ", city=" + city + ", areaCode="
				+ areaCode + ", postCode=" + postCode + ", corpration="
				+ corpration + ", region=" + region + "]";
	}

	
	
}
