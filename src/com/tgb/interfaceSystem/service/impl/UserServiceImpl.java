package com.tgb.interfaceSystem.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.util.ResolverUtil.NameEndsWith;
import com.tgb.interfaceSystem.action.bean.QueryResult;
import com.tgb.interfaceSystem.dao.UserInfoDao;
import com.tgb.interfaceSystem.entity.UserInfo;
import com.tgb.interfaceSystem.service.UserService;
import com.tgb.interfaceSystem.util.noPointException;

/**
 * @author 作者: 周超强
 * @version 创建时间：2015年9月26日 下午1:34:27 类说明:
 */

@Service
// @Transactional(isolation=Isolation.READ_UNCOMMITTED,propagation=Propagation.NESTED,rollbackFor=java.lang.Exception.class)
public class UserServiceImpl implements UserService {

	@Resource
	public UserInfoDao userInfoDao;

	/*
	 * 不需要抛出异常，如果抛出异常的话，Spring事务将不再进行事务管理，并且spring事务默认管理的的异常类型是runtimeException
	 */
	@Override
	public void saveObject(Object obj) {

		//---------------------------Hibernate添加操作
//		List<UserInfo> userInfos=new ArrayList<UserInfo>();
//		for (int i = 0; i < 10000; i++) {
//			UserInfo userInfo=new UserInfo();
//			userInfo.setUserName("asdf");
//			userInfos.add(userInfo);
//		}
//		
//			long start=System.currentTimeMillis();
//			
//			userInfoDao.saveOrUpdateAll(userInfos);
//		
//			long end=System.currentTimeMillis();
//			System.out.println((end-start)/1000);
	
		
		
		
	}

}
