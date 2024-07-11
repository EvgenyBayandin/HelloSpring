# HelloSpring

HelloSpring - это простое веб-приложение на Java, использующее Spring Framework для демонстрации базовой структуры Spring MVC проекта.

## Технологии

- Java 17
- Spring Framework (context, webmvc, test)
- Jakarta Servlet
- Maven
- Lombok
- Jackson
- MapStruct
- JUnit 5
- Mockito

## Структура проекта

- `src/main/java/ru/webdev/config`: Конфигурационные классы Spring
- `src/main/java/ru/webdev/controller`: REST контроллеры
- `src/main/java/ru/webdev/dto`: Data Transfer Objects
- `src/main/java/ru/webdev/mapper`: MapStruct маппер
- `src/main/java/ru/webdev/model`: Модели данных
- `src/main/java/ru/webdev/service`: Сервисный слой

## Сборка проекта

Для сборки проекта используйте Maven:<br>
`mvn clean package`

Это создаст WAR-файл в директории `target`.

## Развертывание

1. Скопируйте созданный WAR-файл в директорию `webapps` вашего Tomcat сервера.
2. Запустите Tomcat.

Для получения приветственного сообщения в формате JSON, обратитесь к эндпоинту:<br>http://localhost:8080/hellospring/hello
<br>
ответ:<br>
{<br>
    "uuid": "5445199f-347d-4107-b946-02d0e7b52241",<br>
    "message": "Привет мир, это Spring Framework Application 'Hello Spring'"<br>
}

## Разработка

Проект использует Lombok для уменьшения шаблонного кода.

## Тестирование

Проект включает модульные тесты для сервисного слоя и интеграционные тесты для контроллера. Тесты используют JUnit 5 и Mockito.

## Дополнительная информация

Каждый класс-пример содержит подробные комментарии, объясняющие его функциональность и особенности использования.