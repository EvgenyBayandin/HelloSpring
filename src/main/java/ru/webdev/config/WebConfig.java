package ru.webdev.config;

import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Конфигурационный класс для настройки Spring MVC.
 * Включает поддержку веб-MVC и настраивает конвертеры сообщений.
 */
@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    /**
     * Настраивает конвертеры HTTP-сообщений.
     * Добавляет Jackson конвертер для работы с JSON.
     *
     * @param converters список конвертеров для настройки
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        WebMvcConfigurer.super.configureMessageConverters(converters);
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder()
                .indentOutput(true);
        converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
    }
}
