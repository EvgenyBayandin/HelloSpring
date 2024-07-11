package ru.webdev.service.impl;

import org.junit.jupiter.api.Test;
import ru.webdev.model.HelloModel;

import static org.junit.jupiter.api.Assertions.*;

class HelloServiceImplTest {
    
    @Test
    void sayHelloShouldReturnHelloModelWithUniqueUuidAndMessage() {
        HelloServiceImpl service = new HelloServiceImpl();
        
        HelloModel result1 = service.sayHello();
        HelloModel result2 = service.sayHello();
        
        assertNotNull(result1.uuid());
        assertNotNull(result2.uuid());
        assertNotEquals(result1.uuid(), result2.uuid());
        assertEquals("Привет мир, это Spring Framework Application 'Hello Spring'", result1.message());
        assertEquals("Привет мир, это Spring Framework Application 'Hello Spring'", result2.message());
    }
}