package ru.webdev.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.webdev.dto.HelloDto;
import ru.webdev.mapper.HelloMapper;
import ru.webdev.model.HelloModel;
import ru.webdev.service.HelloService;

/**
 * REST контроллер для обработки запросов.
 */
@RestController
@RequiredArgsConstructor
class HelloController {
    
    private final HelloService helloService;
    private final HelloMapper helloMapper;
    
    /**
     * Обрабатывает GET-запросы на /hello и возвращает сообщение в формате JSON.
     *
     * @return ResponseEntity с HelloDto, содержащим приветственное сообщение
     */
    @GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HelloDto> sayHello() {
        HelloModel model = helloService.sayHello();
        HelloDto dto = helloMapper.toDto(model);
        return ResponseEntity.ok(dto);
    }
}
