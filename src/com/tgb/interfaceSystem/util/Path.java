/**     
 * @FileName: Path.java   
 * @Package:com.tgb.interfaceSystem.util   
 * @Description: TODO  
 * @author: LUCKY    
 * @date:2015年9月28日 上午11:36:14   
 * @version V1.0     
 */
package com.tgb.interfaceSystem.util;

import java.io.File;

/**  
 * @ClassName: Path   
 * @Description: 获取web项目中的路径公共类操作
 * @author: LUCKY  
 * @date:2015年9月28日 上午11:36:14     
 */


	public class Path {

	    private static String root = null;

	    public Path()
	    {
	    }

	    public static String getRoot()
	    {
	        if(root == null)
	        {
	            String path = (new Path()).getClass().getProtectionDomain().getCodeSource().getLocation().getFile();
	            String absolutePath = (new File(path)).getAbsolutePath();
	            //System.out.println(absolutePath);
	            
	            if(absolutePath.indexOf("WEB-INF")!=-1){
	            	root = absolutePath.substring(0, absolutePath.indexOf("WEB-INF"));
	            }
	            
	            if(absolutePath.indexOf("webapps") != -1){
	                root = absolutePath.substring(0, absolutePath.indexOf("webapps"));
	                root= root +"webapps"+File.separator+"electric"+File.separator; 
	                }
	            

	        }
	        //System.out.println(root);
	        return root;
	    }
	    

	    
	   

	    public static void main(String [] args){
	    	
	    	
	    	Path.getRoot();
	    	System.out.println(Path.root);
	    }
}

