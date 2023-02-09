package com.yunhai.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.domain.Customer;
import com.itheima.service.PmsItemImportService;

/**
 * ��ӿͻ��Ŀ����� Servlet implementation class SaveCustomer
 */
//@WebServlet("importPmsItemShuLine")
public class ImportPmsItemShuLine  extends HttpServlet {
	
	
	
	public ImportPmsItemShuLine() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ��������Ĳ���
		request.setCharacterEncoding("UTF-8");
		Map<String, String[]> map = request.getParameterMap();
		// ������ݣ�ʹ��BeanUtils���ߣ�����jar��
		Customer c = new Customer();
		try {
			// ���b����
			BeanUtils.populate(c, map);
			// �{�ØI�Ռ�
			new PmsItemImportService().importPmsItem();
			System.out.println("��ӿͻ��ɹ���");  
			request.getRequestDispatcher("./jsp/customer/add.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	

}
