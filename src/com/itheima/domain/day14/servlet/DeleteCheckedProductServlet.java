package com.itheima.domain.day14.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.day14.service.ProductService;

/**
 * Servlet implementation class DeleteCheckedProductServlet
 * ɾ�����ѡ����Ʒ
 */
@WebServlet("/deleteCheckedProductServlet")
public class DeleteCheckedProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//1.��ȡ��ƷproductId
		String[] productIds=request.getParameterValues("productId");

		if(productIds.length!=0||productIds!=null) {  
			//����Service��ɶ��product��ɾ��
			try {
				new ProductService().deleteCheckedProduct(productIds);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("msg", "��Ʒɾ��ʧ��");
				request.getRequestDispatcher("/msg.jsp").forward(request, response);
			}
		}else {
			System.out.println("δѡ�м�¼��");
		}
		//3.ҳ���ض��� findAllProduct
		response.sendRedirect(request.getContextPath()+"/findAllProduct");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
