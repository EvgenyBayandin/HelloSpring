package ru.webdev.dto;

import java.util.UUID;

/**
 * Data Transfer Object для передачи приветственного сообщения.
 *
 * @param uuid уникальный идентификатор сообщения
 * @param message текст сообщения
 */
public record HelloDto(UUID uuid, String message) {
}
