package com.tgb.interfaceSystem.Base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	
	//数据引擎服务组件注入
	@Resource
	public RepositoryService repositoryService;

	@Resource
	public  RuntimeService runtimeService;
	
	@Resource
	public TaskService taskService;
	
	@Resource
	public HistoryService historyService;
	
	@Resource
	public IdentityService identityService;
	@Resource
	public ManagementService managementService;
	
	
	
	// =============== ModelDriven的支持 ==================

	protected T model;

	public BaseAction() {
		try {
			// 通过反射获取model的真实类型
			ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
			// 通过反射创建model的实例
			model = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public T getModel() {
		return model;
	}


}
