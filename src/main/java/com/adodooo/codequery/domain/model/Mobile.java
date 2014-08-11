package com.adodooo.codequery.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.dreammore.framework.codegeneration.model.Comment;
import com.dreammore.framework.common.model.BaseIncEntity;

//{"Mobile":"13661368411","QueryResult":"True","TO":"�й��ƶ�","Corp":"�й��ƶ�",
//"Province":"����","City":"����","AreaCode":"010","PostCode":"100000","VNO":"","Card":""}

@Entity
@Table
public class Mobile extends BaseIncEntity implements Cloneable {

	private static final long serialVersionUID = -1989110817025501122L;

	@Comment(value = "�ֻ�����", searchable = true)
	@Transient
	private String phoneCode;

	@Comment(value = "�������", searchable = true)
	@Column(name = "NET_CODE", unique = true)
	private String netCode;

	@Comment(value = "����ʡ��")
	@Column(name = "PRIVINCE")
	private String province;

	@Comment(value = "��������")
	@Column(name = "CITY")
	private String city;

	@Comment(value = "����")
	@Column(name = "AREA_CODE")
	private String areaCode;

	@Comment(value = "��������")
	@Column(name = "POST_CODE")
	private String postCode;

	@Comment(value = "������˾")
	@Column(name = "CORPRATION")
	private String corpration;

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

	@Override
	public Mobile clone() throws CloneNotSupportedException {
		return (Mobile) super.clone();
	}

	@Override
	public String toString() {
		return "Mobile [phoneCode=" + phoneCode + ", netCode=" + netCode
				+ ", province=" + province + ", city=" + city + ", areaCode="
				+ areaCode + ", postCode=" + postCode + ", corpration="
				+ corpration + "]";
	}
	
	

}

