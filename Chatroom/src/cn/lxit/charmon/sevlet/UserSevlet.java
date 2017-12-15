package cn.lxit.charmon.sevlet;

import java.io.IOException;
import java.io.PrintWriter;
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

import cn.lxit.charmon.ben.Users;
import cn.lxit.charmon.sevice.UserService;
import cn.lxit.charmon.sevice.SeviceImpl.UserServiceImpl;

@WebServlet("/UserSevlet")
public class UserSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("post������");

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		HttpSession session = request.getSession();
		String oper = request.getParameter("oper");
		PrintWriter out = response.getWriter();
		ObjectMapper map = new ObjectMapper();
		if ("Checkusername".equals(oper)) {
			String username = request.getParameter("username");
			
				Users users = userService.getUserName(username);

				if (users != null) {
					System.out.println("�û����Ѵ���");
					response.getWriter().write("false");
				} else if(username!="") {
					System.out.println("�û���������");
					response.getWriter().write("true");
				}
			
			
		} else if ("add".equals(oper)) {
			System.out.println("�����û�========================");
			String u_name = request.getParameter("username");
			String validata = request.getParameter("validata");
			String rand = (String) request.getSession().getAttribute("rand");
			System.out.println("=-=-=-=-=--0==-" + rand);
			Users users = new Users();
			users.setU_name(u_name);

			users.setU_pass(request.getParameter("pwd"));
			users.setU_nickName(request.getParameter("nickname"));
			// ��֤��
			if (validata.equals(rand)) {
				if (userService.inserUser(users)) {
					session.setAttribute("u_name", u_name);
					request.getRequestDispatcher("login.jsp").forward(request, response);
					System.out.println("�����û�========================" + u_name);
					System.out.println("ע��ɹ�");
					
				} else {
					response.sendRedirect("register.jsp");
					System.out.println("ע��ʧ��");
				}

			} else {
				System.out.println("��֤����");
				request.setAttribute("mark", "true");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}

		} else if ("login".equals(oper)) {
			System.out.println("login==================");
			String username = request.getParameter("username");
			String pwd = request.getParameter("pwd");
			Users users = userService.getLogin(username, pwd);
			String validata = request.getParameter("validata");
			String rand = (String) request.getSession().getAttribute("rand");
			// ��֤��
			if (validata.equals(rand)) {
				if (users != null && users.getU_name().equals(username) && users.getU_pass().equals(pwd)) {
					if (users.getU_status() == 0) {
						// ��¼ʱ״̬Ϊ��¼
						userService.getChckstatus(username, 1);

						session.setAttribute("users", users);
						session.setAttribute("username", username);
						session.setAttribute("nickname", users.getU_nickName());
						System.out.println("��¼�û�========================" + username);
						request.getRequestDispatcher("chatroom.jsp").forward(request, response);

						System.out.println("��¼�ɹ���");
					}else{
						request.setAttribute("count","true");
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}

				} else {
					out.print("<script>alert('�û������������');location='login.jsp';</script>");
				}
			} else {
				System.out.println("��֤����");
				request.setAttribute("mark", "true");
				request.getRequestDispatcher("login.jsp").forward(request, response);

			}

		} else if ("signOut".equals(oper)) {
			String username = (String) request.getSession().getAttribute("username");
			System.out.println("ע��=====" + username);
			userService.getChckstatus(username, 0);
			// ���session
			session.invalidate();
			response.sendRedirect("login.jsp");
		} else if ("listUsers".equals(oper)) {
			System.out.println("����listusers==========");

			List<Users> users = userService.getUser(1);
			System.out.println("uuuuu===========" + users);
			String nickName = (String) session.getAttribute("nickname");

			Map<String, Object> maap = new HashMap<String, Object>();
			maap.put("nickName", nickName);
			maap.put("List", users);
			map.writeValue(out, maap);

		}
	}
}
