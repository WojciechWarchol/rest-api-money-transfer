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


