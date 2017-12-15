package cn.lxit.chatroom.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cn.lxit.chatroom.entity.Messages;
import cn.lxit.chatroom.entity.Users;
import cn.lxit.chatroom.service.MessagesServiceDao;
import cn.lxit.chatroom.service.UsersServiceDao;
import cn.lxit.chatroom.service.impl.MessagesServiceDaoimpl;
import cn.lxit.chatroom.service.impl.UsersServiceDaoimpl;
import javafx.print.JobSettings;

public class Login extends HttpServlet{
	UsersServiceDao us=new UsersServiceDaoimpl();
	MessagesServiceDao ms=new MessagesServiceDaoimpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=UTF-8");
		String oper=request.getParameter("oper");
		
		if(oper.equals("login")){
			String name=request.getParameter("userName");
			String pwd=request.getParameter("pwd");
			String yzm=request.getParameter("yzm");
			String rand=(String) request.getSession().getAttribute("rand");
			Users u = us.select(name, pwd);
			if(u!=null&&name.equals(u.getU_name())&&pwd.equals(u.getU_pass())){
				if(yzm.equals(rand)){
					System.out.println("µÇÂ¼³É¹¦£¡");
					us.update(u.getU_name());
					int Sum=us.selectOne();
					Date date=new Date();
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String time=sdf.format(date);
					request.getSession().setAttribute("sum", Sum);
					request.getSession().setAttribute("name", name);
					request.getSession().setAttribute("time", time);
					response.sendRedirect("ChatRoom.jsp");
				}else{		
					response.sendRedirect("Login.jsp");
				}
			}else{
				System.out.println("µÇÂ¼Ê§°Ü£¬ÃÜÂë»òÓÃ»§Ãû´íÎó£¡");
				response.sendRedirect("Login.jsp");
			}

		}else if(oper.equals("reg")){
			String name=request.getParameter("userName");
			String pwd=request.getParameter("pwd");
			String nickname=request.getParameter("nickName");
			String yzm=request.getParameter("yzm");
			Users u=new Users();
			u.setU_name(name);
			u.setU_pass(pwd);
			u.setU_nickName(nickname);
			String rand=(String) request.getSession().getAttribute("rand");
			if(yzm.equals(rand)){
				boolean index=us.insert(u);
				if(index){
					response.sendRedirect("Login.jsp");
				}else{
					response.sendRedirect("Register.jsp");
				}
			}else{
				response.sendRedirect("Register.jsp");
			}
		}else if("mes".equals(oper)){
			String text=request.getParameter("text");
			String userName=request.getParameter("userName");
			String sel=request.getParameter("sel");
			Messages mm=new Messages();
			mm.setM_from(userName);
			mm.setM_message(text);
			mm.setM_to(sel);
			boolean index=ms.insert(mm);
			if(index){
				response.sendRedirect("ChatRoom.jsp");
				System.out.println("·¢ËÍ³É¹¦£¡");
			}
		}else if("roo".equals(oper)){
			String time=request.getParameter("time");
			String userName=request.getParameter("userName");
			String sel=request.getParameter("sel");
			Messages mm=new Messages();
			mm.setM_from(userName);
			mm.setM_addtime(time);
			List<Messages> li=ms.select(mm);
			if(li!=null){
				PrintWriter out=response.getWriter();
				JSONArray jsonArr=new JSONArray();
				System.out.println("----------"+time);
				for(Messages mess:li){
					System.out.println("------"+mess.getM_from()+"===="+mess.getM_message()+"----"+mess.getM_to());
					JSONObject jsonobj=new JSONObject();			
					try {
						jsonobj.put("m_from",mess.getM_from());
						jsonobj.put("m_message",mess.getM_message());
						jsonobj.put("m_to",mess.getM_to());
						jsonobj.put("m_addtime",mess.getM_addtime());
						System.out.println("------"+mess.getM_from()+"===="+mess.getM_message());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					jsonArr.put(jsonobj.toString());
				}
				out.write(jsonArr.toString());
			}
			
		}else if(oper.equals("zhuxiao")){
			String userName=request.getParameter("userName");	
			boolean index =  us.updateTwo(userName);
			if(index){
				System.out.println("------"+userName+"--===="+index);
			}
			
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
