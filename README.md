# Экзаменационное задание Cucumber, maven, Rest Assured, allure
# Добавил тесты с GUI + Cucumber + allure
# Проверяем сайт https://edujira.ifellow.ru/ 

### Запуск тестов через терминал: mvn clean test

## Файл src/main/java/util/Config.java
- Реализована конфигурация системы на использование файла src/test/resources/application.properties

## Файл src/test/java/hooks/WebHooks.java
- Содержит методы BeforeAll и AfterEach Attachment лдля создания скриншота и записи сообщения
- BeforeAll и AfterEach вызываются только при выполнении GUI тестов

# GUI тесты сайта https://edujira.ifellow.ru/

## В пакете src/test/java/objects/elements
- Содержаться файлы с Xpath по страницам сайта https://edujira.ifellow.ru/

## В пакете src/test/java/objects/steps/gui_edu_jira
- Находиться логика выполнения тестов и проверки по GUI тестам сайта https://edujira.ifellow.ru/

### src/test/java/objects/steps/gui_edu_jira/for_all
- Общие методы по GUI тестам сайта https://edujira.ifellow.ru/

## Реализованы тесты:

#### Test OpenUrl
Открываем URL и проверяем body и title.

#### Test Authorization
- Авторизуемся и проверяем соответствие имени полязователя
- Позитивная авторизация с верными логин и пароль
- 2 проверки с неверными логин или паролем

#### Test Go To Project
- Заходим в проект и определяем количество задач в проекте отбражаемое на экране и возвращаем полученное значение.
- Отправляем API запрос  и определяем количество задач в проекте
- Сверяем полученные значения.

#### Test Task Search
Поиск и переход в заданную задачу и проверка статуса и привязки.

#### Test Create Issue And Transition By Statuses
- Создание задачи с типом "Ошибка" и перевод созданной задачи по статусам.
- Проверка не возможности создания задачи без заполнения поля "Тема"

## В пакете src/test/java/objects/steps/api_all_request_respone
- Находятся классы с определением RequestSpecification и получением Response по API тестам

# API тесты сайта https://edujira.ifellow.ru/

## В пакете src/test/java/objects/steps/api_edu_jira
- Реализована логика шагов теста сайта https://edujira.ifellow.ru с использованием Api

### Реализованы тесты:

#### Test OpenUrl
- Открываем URL и проверяем statusCode.

#### Test Authorization
- Авторизуемся и проверяем наличие sessionID.
- Позитивная авторизация с верными логин и пароль
- 2 проверки с неверными логин или паролем

#### Test Go To Project
- Заходим в проект и определяем количество задач в проекте и возвращаем полученное значение.

#### Test Create Issue And Transition By Statuses
- Создание задачи с типом "Ошибка" и перевод созданной задачи по статусам.