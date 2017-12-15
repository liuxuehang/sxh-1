package cn.lxit.chatroom.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import cn.lxit.chatroom.entity.Users;
import cn.lxit.chatroom.service.UsersServiceDao;
import cn.lxit.chatroom.service.impl.UsersServiceDaoimpl;

public class Ajax_Login extends HttpServlet {
	UsersServiceDao us = new UsersServiceDaoimpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		if (request.getParameter("userName") != null) {
			String username = request.getParameter("userName");
			String u_name = us.selectName(username);
			if (u_name != null && u_name.equals(username)) {
				response.getWriter().write("用户名已存在！");
			} else {
				response.getWriter().write(" ");
			}
		}
		if (request.getParameter("yzm") != null) {
			String yzm = request.getParameter("yzm");
			String rand = (String) request.getSession().getAttribute("rand");
			if (yzm.equals(rand)) {
				response.getWriter().write(" ");
			} else {
				response.getWriter().write("输入的验证码不正确!");
			}
		}

	}
}
