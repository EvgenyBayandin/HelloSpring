package ru.webdev.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.webdev.dto.HelloDto;
import ru.webdev.model.HelloModel;

/**
 * Интерфейс для преобразования между HelloModel и HelloDto.
 * Реализация будет сгенерирована MapStruct.
 */
@Mapper(componentModel = "spring")
public interface HelloMapper {
    
    /**
     * Преобразует HelloModel в HelloDto.
     *
     * @param model модель для преобразования
     * @return соответствующий HelloDto
     */
    @Mapping(source = "uuid", target = "uuid")
    @Mapping(source = "message", target = "message")
    HelloDto toDto(HelloModel model);
}
