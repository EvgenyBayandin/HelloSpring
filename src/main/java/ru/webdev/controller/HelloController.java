package ru.webdev.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import ru.webdev.mapper.HelloMapper;
import ru.webdev.service.HelloService;

@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
class HelloController {
    private final HelloService helloService;
    private final HelloMapper helloMapper;
    
    @org.springframework.web.bind.annotation.GetMapping(value = "/hello", produces = "application/json")
    public ResponseEntity<ru.webdev.dto.HelloDto> sayHello() {
        ru.webdev.model.HelloModel model = helloService.sayHello();
        ru.webdev.dto.HelloDto dto = helloMapper.toDto(model);
        return ResponseEntity.ok(dto);
    }
}
