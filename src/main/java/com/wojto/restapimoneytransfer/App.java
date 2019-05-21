package com.wojto.restapimoneytransfer;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.wojto.restapimoneytransfer.controller.RestController;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        
        Server jettyServer = new Server(8080);
        jettyServer.setHandler(context);
        
        ServletHolder jerseyServlet = context.addServlet(
        		org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);
        
        jerseyServlet.setInitParameter(
        		"jersey.config.server.provider.classnames",
        		RestController.class.getCanonicalName());
        
        
        // In memory accounts for testing
//    	HashSet<Account> accountList = new HashSet<Account>();
//
//    	Account account1 = new Account(1, 500, "password1");
//    	Account account2 = new Account(2, 5000, "password2");
//    	Account account3 = new Account(3, 0, "password3");
//    	Account account4 = new Account(4, 10, "password4");
//    	Account account5 = new Account(5, 2000, "password5");
//    	
//    	accountList.add(account1);
//    	accountList.add(account2);
//    	accountList.add(account3);
//    	accountList.add(account4);
//    	accountList.add(account5);
                
        
        try {
        	jettyServer.start();
        	jettyServer.join();
        } catch(Exception e) {
        	System.out.println("Error, stopping server:" + e);
        	jettyServer.stop();
			jettyServer.destroy();
		}
    }
    

}


