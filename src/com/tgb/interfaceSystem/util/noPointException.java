/**     
 * @FileName: nullPointException.java   
 * @Package:com.tgb.interfaceSystem.util   
 * @Description: TODO  
 * @author: LUCKY    
 * @date:2015年9月26日 下午9:32:13   
 * @version V1.0     
 */
package com.tgb.interfaceSystem.util;

/**  
 * @ClassName: nullPointException   
 * @Description: 自定义的一个关于空指针异常的封装类操作  
 * @author: LUCKY  
 * @date:2015年9月26日 下午9:32:13     
 */
public class noPointException extends NullPointerException {
	public  noPointException(){}
	
	public noPointException(String msg){
		super("出现空指针异常,参数不能为null"+msg);
	}
}
