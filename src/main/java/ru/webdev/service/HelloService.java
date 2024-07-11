package ru.webdev.service;

import ru.webdev.model.HelloModel;

/**
 * Сервис для генерации сообщений.
 */
public interface HelloService {
    
    /**
     * Генерирует новое приветственное сообщение.
     *
     * @return HelloModel, содержащий новое приветственное сообщение
     */
    public HelloModel sayHello();
}
