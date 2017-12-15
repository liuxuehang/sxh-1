package cn.lxit.books.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lxit.books.bean.UserInfo;
import cn.lxit.books.service.UserInfoService;
import cn.lxit.books.service.impl.UserInfoServiceImpl;

public class UserInfoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
        doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
		PrintWriter out = response.getWriter();

		UserInfoService us = new UserInfoServiceImpl();
		String oper = request.getParameter("oper");
        
		if("login".equals(oper)){
			String username = request.getParameter("userName");
			String password = request.getParameter("passWord");

			UserInfo ui = new UserInfo(username, password);
			request.getSession().setAttribute("ui", ui);
			if (us.checkuser(ui)) {
				response.sendRedirect("/books/JBEshop/orderlist.jsp");
			} else {
				out.write("用户名或密码有误！");  
				System.out.println("用户名或密码有误！！！");
			}
			
		}else if("reg".equals(oper)){
			String userName = request.getParameter("userName");
			String password = request.getParameter("passWord");
			String email = request.getParameter("email");
			
			UserInfo user = new UserInfo(userName,password,email);
			if(us.insert(user)){
				response.sendRedirect("/books/JBEshop/register_success.jsp");
			}
		}else if("logout".equals(oper)){
			request.getSession().invalidate();
			response.sendRedirect("/books/JBEshop/login.jsp");
		}
		

	}

}
