package com.yunhai.beanutils;

import java.util.Date;

import javax.servlet.ServletException;

import org.apache.commons.beanutils.ConvertUtils;

 
/**
 * Œ¥ µœ÷
 * @author ZhangMin
 *
 */
public class ConvertPlugIn  {
	public   void  destroy() {   
		ConvertUtils.deregister();   
		}   
		/*public   void  init(ActionServlet arg0, ModuleConfig arg1)   
		throws  ServletException {   
		ConvertUtils.register(new  DateConverter(), Date. class );   
		}  
		 */
}
