package ru.webdev.service.impl;

import java.util.UUID;
import org.springframework.stereotype.Service;
import ru.webdev.model.HelloModel;
import ru.webdev.service.HelloService;

/**
 * Реализация HelloService.
 */
@Service
public class HelloServiceImpl implements HelloService {
    
    /**
     * Генерирует новое приветственное сообщение с уникальным ID.
     *
     * @return HelloModel с новым UUID и приветственным текстом
     */
    @Override
    public HelloModel sayHello() {
        return new HelloModel(UUID.randomUUID(), "Привет мир, это Spring Framework Application 'Hello Spring'");
    }
}
