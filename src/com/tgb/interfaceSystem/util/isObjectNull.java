/**     
 * @FileName: isNull.java   
 * @Package:com.tgb.interfaceSystem.util   
 * @Description: TODO  
 * @author: LUCKY    
 * @date:2015年9月26日 下午9:37:33   
 * @version V1.0     
 */
package com.tgb.interfaceSystem.util;

import java.util.List;

/**  
 * @ClassName: isNull   
 * @Description: 静态类，用来判断传入的参数是否为null或者为空值 
 * @author: LUCKY  
 * @date:2015年9月26日 下午9:37:33     
 */
public class isObjectNull {
	public static boolean isNull(Object obj){
		boolean isNullFlag=false;
		try {
			if (obj!=null || !obj.equals("")) {
				isNullFlag= true;
			}
		} catch (noPointException e) {
			throw e;
		}
		return isNullFlag;
	}
	
	public static boolean isNull(List list){
		boolean isNullFlag=false;
		try {
			if(list!=null || list.size()!=0){
				isNullFlag=true;
			}
		} catch (noPointException e ) {
			throw e;
		}
		return isNullFlag;
	}
}
