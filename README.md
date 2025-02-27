# Spring project
## Описание проекта
Данный проект проедставляет собой сервис по поиску преподавателей для Научно-исследователькой работы (НИР). Основная цель проекта - обеспечить удобство всем учатсникам НИР, как преподавателям, так и студентам.
## Основные технологии 
- Java: Основной язык разработки.
- Spring Boot: Построение REST-сервиса.
- PostgreSQL: Работа с базой данных.
- Docker: Контейнеризация базы данных.
- Maven: Автоматическая сборка проекта.
- Swagger: Документация и тестирование API.
- Vue.js: Создание Web-страницы.
## Основные сервисы
1. Request
   - ```GET/request/request/requester/{id}```: Получение списка заявок по ```id``` студента.
   - ```GET/request/reciever/{id}```: Получение списка заявок по ```id``` преподавателя.
   - ```GET/request/{id}```: Получение конкретной заявки по ```id```.
   - ```GET/request/student/{id}```: Получение студента по ```id``` заявки.
   - ```GET/request/teacher/{id}```: Получение преподавателя по ```id``` заявики.
   - ```GET/request/reaction/{id}```: Получение причины отказа по ```id``` заявки.
   - ```GET/request/in-process/teacher/{id}```: Получение ожидающих студентов по ```id``` преподавателя.
   - ```POST/request/student/{studentId}/teacher/{teacherId}```: Создание заявки у студента с ```studentId``` и преподавателя с ```teacherId```.
   - ```PUT/request/accept/{id}```: Подтверждение завявки преподавателем.
   - ```PUT/request/reject/{id}```: Отклонение заявки преподавателем.
   - ```DELETE/request/{id}```: Удаление завки студентом по ```id```.
2. Student
   - ```GET/student/{id}```: Получение студента по его ```id```.
   - ```GET/student/accept/teacher/{id}```: Получние всех принятых студентов по ```id``` преподавателя.
3. Teacher
   - ```GET/teacher```: Получение списка всех преподавателей.
   - ```GET/teacher/link/{id}```: Получение ссылки на личный кабинет преподавателя по его ```id```.
   - ```GET/{id}```: Получение ссылки на преподавателя по его ```id```.
## Дальнейшие планы
- Интеграция с личным кабинетом вуза.
- Добавление системы приоритетов для выбора преподавателей.
- Добавление входного тестирования для студентов путем интегрирования с системой moodle.
- Система фильтраии списка преподавателей и студентов.
- Система поиска преподавателей и студентов.
- Предоставить возможность преподавателю отправлять приглашение студентам.
