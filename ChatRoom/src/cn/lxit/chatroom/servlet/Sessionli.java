package cn.lxit.chatroom.servlet;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import cn.lxit.chatroom.service.UsersServiceDao;
import cn.lxit.chatroom.service.impl.UsersServiceDaoimpl;

/**
 * Application Lifecycle Listener implementation class Sessionli
 *
 */
@WebListener
public class Sessionli implements HttpSessionListener {
	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         System.out.println("Session======Æô¶¯");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	 System.out.println("Session======Ïú»Ù");	
    	 arg0.getSession().setMaxInactiveInterval(10);
    	 UsersServiceDao us=new UsersServiceDaoimpl();
    	 us.updateOne();
    }
	
}
