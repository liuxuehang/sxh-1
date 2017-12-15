package cn.lxit.charmon.sevlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.lxit.charmon.ben.Messages;
import cn.lxit.charmon.ben.Users;
import cn.lxit.charmon.sevice.ChatrommSevice;
import cn.lxit.charmon.sevice.UserService;
import cn.lxit.charmon.sevice.SeviceImpl.ChatrommServiceImpl;
import cn.lxit.charmon.sevice.SeviceImpl.UserServiceImpl;

@WebServlet("/ChatroomServlet")
public class ChatroomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private  ChatrommSevice chatrommSevice=new ChatrommServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    System.out.println("进入dopost============================");
		    request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json;charset=utf-8");
			HttpSession  session=request.getSession();
			String oper = request.getParameter("oper");
			PrintWriter out = response.getWriter();
			ObjectMapper map = new ObjectMapper();
			UserService userService=new UserServiceImpl();
			if("insert".equals(oper)){
				System.out.println("增加聊天内容======");
				String message=request.getParameter("message");
				String seler_user=request.getParameter("seler_user");
				
			    String nickname = (String) session.getAttribute("nickname");
			  
			    Messages messages=new Messages();
			    messages.setM_from(nickname);
			    messages.setM_message(message);
			    messages.setM_to(seler_user);
			    boolean bo=chatrommSevice.insertChatrom(messages);
			    
			}else if("select".equals(oper)){
				System.out.println("查询所有聊天记录===================");
				List<Messages> mes=chatrommSevice.getSelect();
				String nickname = (String) session.getAttribute("nickname");
				System.out.println("mingzi========="+nickname);
				Map<String,Object> maipp=new HashMap<String,Object>();
				
			
				maipp.put("nickname", nickname);
				maipp.put("List", mes);
				map.writeValue(out, maipp);
			}
			
		
	}

}
