package com.tgb.interfaceSystem.dao.impl; 

import org.springframework.stereotype.Service;

import com.tgb.interfaceSystem.Base.BaseJDBCDao;
import com.tgb.interfaceSystem.dao.UserInfoDao;
import com.tgb.interfaceSystem.entity.UserInfo;

/** 
 * @author 作者: 周超强
 * @version 创建时间：2015年9月26日 下午1:31:17 
 * 类说明:
 */

@Service
public class UserDaoImpl extends BaseJDBCDao<UserInfo> implements UserInfoDao{
	
}
 