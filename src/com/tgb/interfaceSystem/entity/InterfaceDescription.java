/**     
 * @FileName: InterfaceDescription.java   
 * @Package:com.tgb.interfaceSystem.entity   
 * @Description: TODO  
 * @author: LUCKY    
 * @date:2015年10月6日 下午2:02:40   
 * @version V1.0     
 */
package com.tgb.interfaceSystem.entity;

import java.io.Serializable;

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
 * @ClassName: InterfaceDescription
 * @Description: 接口提出方对自己所需要接口的描述信息
 * @author: LUCKY
 * @date:2015年10月6日 下午2:02:40
 */
@Entity
@Table(name = "t_InterfaceDescription")
public class InterfaceDescription implements Serializable {

	/*
	 * 任务ID
	 */

	private Integer id;
	/*
	 * 所需要的参数描述信息
	 */
	private String name;
	
	/*
	 * 用户实体信息描述
	 */
	private UserInfo userInfo;
	/*
	 * 返回值信息
	 */
	private String returnValue;
	/*
	 * 备注信息
	 */
	private String mark;

	/*
	 * 状态标识
	 */
	private String status;

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
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
