package ru.webdev.controller;

import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.webdev.dto.HelloDto;
import ru.webdev.mapper.HelloMapper;
import ru.webdev.model.HelloModel;
import ru.webdev.service.HelloService;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class HelloControllerTest {
    
    private MockMvc mockMvc;
    
    @Mock
    private HelloService helloService;
    
    @Mock
    private HelloMapper helloMapper;
    
    @InjectMocks
    private HelloController helloController;
    
    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(helloController).build();
    }
    
    
    @Test
    void sayHelloShouldReturnHelloDto() throws Exception {
        UUID uuid = UUID.randomUUID();
        String message = "Test message";
        HelloModel model = new HelloModel(uuid, message);
        HelloDto dto = new HelloDto(uuid, message);
        
        when(helloService.sayHello()).thenReturn(model);
        when(helloMapper.toDto(model)).thenReturn(dto);
        
        org.springframework.test.web.servlet.MvcResult result = mockMvc.perform(get("/hello").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON)).andReturn();
        
        String content = result.getResponse().getContentAsString();
        assertTrue(content.contains(uuid.toString()));
        assertTrue(content.contains(message));
    }
}