package com.yunhai.pdf.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunhai.service.PdfFileService;

@WebServlet("/image2Pdf")
public class Image2Pdf  extends HttpServlet {

		/**
		 * 
		 */
		private static final long serialVersionUID = -2558075990487346570L;

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub// 先获取请求的参数
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("utf-8");

			String mergeFileName = request.getParameter("mergeFileName");
			//System.out.println("mergeFileName＝" + mergeFileName);
			// 1.文件名称数组
			String[] fileNames = request.getParameterValues("fileName");
			// 2.文件名称数组（带路径）
			String[] paths = request.getParameterValues("path");
			//int num = paths[0].lastIndexOf("\\");
			//String mergeFileNameWithPath=paths[0].substring(0, paths[0].lastIndexOf("\\")+1)+mergeFileName;
			String userFolder=paths[0];
			String savePath = request.getServletContext().getRealPath(userFolder);
			String mergeFileNameWithPath=savePath+ File.separator + mergeFileName;
			for(int i=0;i<fileNames.length;i++) {
				paths[i]=savePath+ File.separator +fileNames[i];
			}
			//System.out.println("mergeFileName＝" + mergeFileName);
			//System.out.println("path="+userFolder+",mergeFileNameWithPath="+mergeFileNameWithPath);
			if (fileNames.length != 0 || fileNames != null) {
				// 调用Service完成多个product的删除
				try {
					new PdfFileService().multiplePdfFileMerge(mergeFileNameWithPath, paths);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					request.setAttribute("msg", "pdf文件合并失败");
					request.getRequestDispatcher("/msg.jsp").forward(request, response);
				}
			} else {
				System.out.println("未选中记录！");
			}

			request.setAttribute("mergeFileName", mergeFileName);
			request.setAttribute("path", userFolder);
			request.getRequestDispatcher("/jsp/pdf/mergedPdfFiles.jsp").forward(request, response);

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
