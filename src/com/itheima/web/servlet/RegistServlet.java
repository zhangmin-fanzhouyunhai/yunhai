package com.itheima.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import com.itheima.service.UserService;
import com.itheima.user.orm.YunhaiUser;
import com.yunhai.util.DateFormatUtil;
/**
 * Servlet implementation class RegistServlet
 * �û�ע��
 */
@WebServlet("/registServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//0.���ñ���
		request.setCharacterEncoding("utf-8");
		
		//1.�������
		//����һ��YunhaiUser������YunhaiUser.setXxx()һ������װ�����Ƽ�
		//ʹ��beanUtils��װ����
		YunhaiUser user= new YunhaiUser();
		try {
			 ConvertUtils.register(new Converter() {
	                @Override
	                public Object convert(Class type, Object value) {
	                if(null == value){
	                        return null;
	                    }
	                String strValue = (String) value;
	                if(strValue.trim().equals("")){
	                    return null;
	                }
	                //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	                //com.yunhai.util.DateFormatUtil,�Ҵ��������������ַ���ת����java.util.Date�ķ�����
	                return DateFormatUtil.parseDate(strValue);
	                 
	                }
	            }, Date.class);
			BeanUtils.populate(user, request.getParameterMap());

			//2.����userService . regist(user) ����ֵ��int
			int i=new UserService().regist(user);
			//3.�ж� int ����Ϣ�����͵� msgServlet
			if(i==1) {
				request.setAttribute("msg", "��ӳɹ�(Successful)");
				request.getRequestDispatcher("/msg").forward(request, response);;
			}if(i==2) {
				request.setAttribute("msg", "�˺Ŵ���,(Account Exists)");
				request.getRequestDispatcher("/msg").forward(request, response);;
			}else {
				request.setAttribute("msg", "���ʧ��(Fault)"); 
				request.getRequestDispatcher("/msg").forward(request, response);;
			} 
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
