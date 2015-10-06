/**     
 * @FileName: TUtils.java   
 * @Package:com.tgb.interfaceSystem.util   
 * @Description: TODO  
 * @author: LUCKY    
 * @date:2015年9月27日 上午10:36:58   
 * @version V1.0     
 */
package com.tgb.interfaceSystem.util;

import java.lang.reflect.ParameterizedType;

/**  
 * @ClassName: TUtils   
 * @Description: 泛型转换类
 * @author: LUCKY  
 * @date:2015年9月27日 上午10:36:58     
 */
public class TUtils {


	/**泛型转换*/
	public static Class getGenericSuperclass(Class entity) {
		/**创建泛型的真实对象，泛型转换，将子类传递的真实对象，通过泛型T在父类中引用*/
		ParameterizedType parameterizedType = (ParameterizedType) entity.getGenericSuperclass();
		Class entityClass = (Class) parameterizedType.getActualTypeArguments()[0];// 获取当前new的对象的 泛型的父类 类型
		return entityClass;
	}
}
