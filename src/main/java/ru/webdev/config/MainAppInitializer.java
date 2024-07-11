package ru.webdev.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MainAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("ru.webdev");
        servletContext.addListener(new ContextLoaderListener((WebApplicationContext) context));
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("mvc", new DispatcherServlet((WebApplicationContext) context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/*");
    }
}
