/**     
 * @FileName: InterfaceInfo.java   
 * @Package:com.tgb.interfaceSystem.entity   
 * @Description: TODO  
 * @author: LUCKY    
 * @date:2015年10月6日 下午1:56:43   
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
 * @ClassName: InterfaceInfo
 * @Description: 入库的接口信息
 * @author: LUCKY
 * @date:2015年10月6日 下午1:56:43
 */
@Entity
@Table(name = "t_InterfaceInfo")
public class InterfaceInfo {

	/*
	 * 主键id
	 */

	private Integer id;
	/*
	 * 接口的优先级
	 */
	private Integer Priority;

	/*
	 * 接口的提出方
	 */
	private String Provider;

	/*
	 * 用户实体关联
	 */
	private UserInfo userInfo;
	
	
	/*
	 * 方法名称
	 */
	private String methodName;

	/*
	 * 返回值
	 */
	private String returnValue;

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
	public Integer getPriority() {
		return Priority;
	}

	public void setPriority(Integer priority) {
		Priority = priority;
	}
	@Column
	public String getProvider() {
		return Provider;
	}

	public void setProvider(String provider) {
		Provider = provider;
	}
	@Column
	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	@Column
	public String getReturnValue() {
		return returnValue;
	}

	public void setReturnValue(String returnValue) {
		this.returnValue = returnValue;
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
