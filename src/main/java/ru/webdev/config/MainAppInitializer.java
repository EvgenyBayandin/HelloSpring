package ru.webdev.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Инициализатор веб-приложения Spring MVC.
 * Этот класс настраивает ServletContext программно, без использования web.xml.
 */
public class MainAppInitializer implements WebApplicationInitializer {
    
    /**
     * Вызывается при запуске приложения для настройки ServletContext.
     *
     * @param servletContext контекст сервлета для настройки
     * @throws ServletException если происходит ошибка при настройке сервлета
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.scan("ru.webdev");
        servletContext.addListener(new ContextLoaderListener(context));
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("mvc", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/*");
    }
}
