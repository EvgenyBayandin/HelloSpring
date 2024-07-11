package ru.webdev.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.webdev.dto.HelloDto;
import ru.webdev.model.HelloModel;

@Mapper
public interface HelloMapper {
    @Mapping(source = "uuid", target = "uuid")
    @Mapping(source = "message", target = "message")
    HelloDto toDto(HelloModel model);
}
