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
 * ɾ�����ݺ���ҳ�����ʽչ������
 */
@WebServlet("/deleteCheckedProductPage")
public class DeleteCheckedProductPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 0.���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 1.��ȡ��ƷproductId
		String[] productIds = request.getParameterValues("productId");
		// ��ȡ�ڼ�ҳ
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		// �̶�ÿҳ��ʾ������
		Integer oldPageSize = 5;
		Integer pageSize = 1;
		if (request.getParameter("pageSize") == null) {
			pageSize = 5;
			oldPageSize = pageSize;
			if (request.getSession().getAttribute("pageSize") == null) {
				request.getSession().setAttribute("pageSize", pageSize);
			}
		} else {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			oldPageSize = Integer.parseInt(request.getSession().getAttribute("pageSize").toString());
			if (request.getSession().getAttribute("pageSize") != pageSize) {
				request.getSession().setAttribute("pageSize", pageSize);
			}
		}
		// ���pageSize�ı�󣬵�ǰҳ����ܻ�С��ԭ����ҳ�����ݣ������ת��ת�����ҳ�洦��Ϊ����¼����/�µ�ҳ��¼����ҳ��
		if (currentPage != Math.ceil(currentPage * oldPageSize / pageSize)) {
			currentPage = (int) Math.ceil(currentPage * oldPageSize / pageSize);
		}
		// System.out.println("currentPage"+currentPage);
		if (productIds.length != 0 || productIds != null) {
			// ����Service��ɶ��product��ɾ��
			try {
				new ProductService().deleteCheckedProduct(productIds);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("msg", "��Ʒɾ��ʧ��");
				request.getRequestDispatcher("/msg.jsp").forward(request, response);
			}
		} else {
			System.out.println("δѡ�м�¼��");
		}
		// 3.ҳ���ض��� findAllProduct
		response.sendRedirect(
				request.getContextPath() + "/showProductsByPage?currentPage=" + currentPage + "&pageSize=" + pageSize);
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
