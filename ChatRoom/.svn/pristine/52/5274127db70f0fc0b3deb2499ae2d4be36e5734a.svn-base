package cn.lxit.chatroom.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cn.lxit.chatroom.entity.Users;
import cn.lxit.chatroom.service.UsersServiceDao;
import cn.lxit.chatroom.service.impl.UsersServiceDaoimpl;

public class Json_Name extends HttpServlet {
	UsersServiceDao us = new UsersServiceDaoimpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		List<Users> li = us.selectAll();
		JSONArray json = new JSONArray();
		
		for (Users us : li) {
			json.put(us.getU_name());
		}
		out.write(json.toString());
	}
}
