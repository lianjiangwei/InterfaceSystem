/**     
 * @FileName: ParameterInfo.java   
 * @Package:com.tgb.interfaceSystem.entity   
 * @Description: TODO  
 * @author: LUCKY    
 * @date:2015年10月6日 下午2:00:26   
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
 * @ClassName: ParameterInfo
 * @Description: 每个接口的参数表实体信息
 * @author: LUCKY
 * @date:2015年10月6日 下午2:00:26
 */

@Entity
@Table(name = "t_ParameterInfo")
public class ParameterInfo {
	/*
	 * 主键ID
	 */

	private Integer id;

	/*
	 * 参数类型
	 */
	private String Type;
	
	private InterfaceInfo interfaceInfo;

	/*
	 * 参数名称
	 */
	private String name;

	/*
	 * 参数描述信息
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
	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}
	@Column
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column
	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	
	@Version
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	
	@ManyToOne
	@JoinColumn
	public InterfaceInfo getInterfaceInfo() {
		return interfaceInfo;
	}

	public void setInterfaceInfo(InterfaceInfo interfaceInfo) {
		this.interfaceInfo = interfaceInfo;
	}
	
	
	
}
