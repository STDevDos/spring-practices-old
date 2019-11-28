package com.froyo.listeners;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@Log4j2
@WebListener
public class HomeInfoListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("ServletContextEvent initialized.");
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("user", "[USUARIO]");
        sc.setAttribute("name", "[NOMBRE DEL USUARIO]");
        sc.setAttribute("dato", "éste dato es obtenido desde la clase @WebListener (HomeInfoListener) ");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        sc.removeAttribute("user");
        sc.removeAttribute("name");
        sc.removeAttribute("dato");
        log.info("ServletContextEvent destroyed.");
    }
}
