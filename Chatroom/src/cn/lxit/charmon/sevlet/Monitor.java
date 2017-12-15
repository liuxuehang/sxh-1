package cn.lxit.charmon.sevlet;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import cn.lxit.charmon.ben.Users;
import cn.lxit.charmon.sevice.UserService;
import cn.lxit.charmon.sevice.SeviceImpl.UserServiceImpl;


@WebListener
public class Monitor implements HttpSessionListener {
      private UserService userService=new UserServiceImpl();
  
    public void sessionCreated(HttpSessionEvent arg0)  { 
         System.out.println("创建监听器============");
         arg0.getSession().setMaxInactiveInterval(120);
    }

    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	System.out.println("sessionDestroyed销毁！");
    	String username=(String) arg0.getSession().getAttribute("username");
    
    	 userService.getChckstatus(username,0);
    	 arg0.getSession().removeAttribute(username);
    	System.out.println("销毁结束================================");
    }
	
}
