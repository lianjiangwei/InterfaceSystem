/**     
 * @FileName: OrganizaitonInfo.java   
 * @Package:com.tgb.interfaceSystem.entity   
 * @Description: TODO  
 * @author: LUCKY    
 * @date:2015年10月6日 下午1:52:13   
 * @version V1.0     
 */
package com.tgb.interfaceSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * @ClassName: OrganizaitonInfo
 * @Description: 组织机构的实体描述信息
 * @author: LUCKY
 * @date:2015年10月6日 下午1:52:13
 */
@Entity
@Table(name = "t_OrganizaitonInfo")
public class OrganizaitonInfo {

	/*
	 * 主键ID
	 */

	private Integer id;

	
	/*
	 * 用户信息实体
	 */

	private UserInfo userInfo;
	/*
	 * 机构名称
	 */
	private String organizationName;

	/*
	 * 机构的父级ID
	 */
	private Integer parentId;

	/*
	 * 企业号
	 */
	private String organizationNumber;

	/*
	 * 备注
	 */
	private String mark;

	/*
	 * 版本字段
	 */

	private Integer version;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column
	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	@Column
	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	@Column
	public String getOrganizationNumber() {
		return organizationNumber;
	}

	public void setOrganizationNumber(String organizationNumber) {
		this.organizationNumber = organizationNumber;
	}
	@Column
	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}
	@Column
	@Version
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	@ManyToOne
	@JoinColumn
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	
	
	
}
