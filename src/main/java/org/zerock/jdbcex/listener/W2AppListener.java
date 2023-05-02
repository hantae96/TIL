package org.zerock.jdbcex.listener;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
@Log4j2
public class W2AppListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sec){
        log.info("========================================");
        log.info("=============시작========================");
        log.info("========================================");

        ServletContext servletContext = sec.getServletContext();
        servletContext.setAttribute("appName","W2");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("========================================");
        log.info("=============종료========================");
        log.info("========================================");
    }
}
