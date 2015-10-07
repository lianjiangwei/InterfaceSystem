
package com.tgb.interfaceSystem.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tgb.interfaceSystem.Base.BaseAction;
import com.tgb.interfaceSystem.entity.UserInfo;
import com.tgb.interfaceSystem.service.UserService;


/**  
 * @ClassName: package-info   
 * @Description: TODO  
 * @author: LUCKY  
 * @date:2015年9月26日 下午1:37:44     
 */

@Controller("UserAction")
@Scope("prototype")
public class UserAction extends BaseAction<UserInfo>{
	
	@Resource
	public UserService userService;
	
	
	//需要在action层进行异常拦截
	public String add(){
		
		
		try {
			UserInfo user=new UserInfo();
			
			user.setUserName("王五");
			userService.saveObject(user);
		} catch (Exception e) {
			 System.out.println(e.getMessage());
		}
		
		
		return "success";
	}
	//登陆页面的action
	public String login()
	{
		return "login";
	}
	//注册页面的action
	public String register()
	{
		return "register";
	}
	//注册成功页面的action	
	public String registersuccess()
	{
		return "registersuccess";
	}
	//系统管理页面的action
	public String systemmanage()
	{
		return "systemmanage";
	}
}