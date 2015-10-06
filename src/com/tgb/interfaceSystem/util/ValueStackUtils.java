package com.tgb.interfaceSystem.util;

import org.apache.struts2.ServletActionContext;

public class ValueStackUtils {

	/**将新的对象压入栈顶，并删除之前的栈顶对象*/
	public static void setValueStack(Object entity) {
		ServletActionContext.getContext().getValueStack().pop();
		ServletActionContext.getContext().getValueStack().push(entity);
	}

}
