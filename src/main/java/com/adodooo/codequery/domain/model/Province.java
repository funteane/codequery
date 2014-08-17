package com.adodooo.codequery.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.dreammore.framework.codegeneration.model.Comment;
import com.dreammore.framework.common.model.BaseIncEntity;


@Entity
@Table(name = "PROVINCE")
public class Province extends BaseIncEntity {

	private static final long serialVersionUID = 254903138018725130L;

	@Comment(value = "省份代码", searchable = true)
	@Column(name = "PROVINCE_CODE")
	private String provinceCode;

	@Column(name = "PROVINCE_NAME")
	private String provinceName;

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

}
