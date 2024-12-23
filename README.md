# ToDoList: перед началом использования

## Описание
ToDoList - приложение для ведения своих задач

## Эндпоинты
### -> GET /tasks - Получить все созданные задачи
### -> POST /tasks - Сохранить новую задачу
тело - json, переменные:
* id - идентификационный номер в формате uuid
* title - название задачи в формате строки
* isCompleted - статус завершенности задачи (true/false)

### -> GET /tasks/{id} - Получить задачу по её id
### -> DELETE /tasks/{id} - Удалить задачу по её id

## Используемые технологии
* Java 17
* Spring Boot 3.4.0:
  * Starter JPA
  * Starter WebFLux
  * MongoDB Reactive
* Lombok 
* JUnit
* Mockito

# Спасибо за внимание!