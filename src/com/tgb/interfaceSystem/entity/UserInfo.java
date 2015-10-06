package com.tgb.interfaceSystem.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * @author 作者: 周超强
 * @version 创建时间：2015年9月26日 下午1:29:21 类说明:
 */
@Entity
@Table(name = "t_UserInfo")
public class UserInfo {

	private Integer id;

	
    private String userName;
    private String account;
    private String password;
    private String telephoneNumber;
    private String email;
    private String role;
    private String mark;
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
public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}
@Column
public String getAccount() {
	return account;
}

public void setAccount(String account) {
	this.account = account;
}
@Column
public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}
@Column
public String getTelephoneNumber() {
	return telephoneNumber;
}

public void setTelephoneNumber(String telephoneNumber) {
	this.telephoneNumber = telephoneNumber;
}
@Column
public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
@Column
public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
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

 
 
}
