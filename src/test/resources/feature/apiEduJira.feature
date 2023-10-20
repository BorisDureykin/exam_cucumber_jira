# language: ru
@Api
@ifellowEduJiraTestsApi
Функция: ifellow Edu Jira Tests Api

  @ПроверкаДоступностиСайта
  Сценарий: Открываем URL, проверяем statusCode и сверяем тело ответа
    Когда Открываем "UrlIfellowJira", c endpoint = "/rest/api/2/resolution",  method = "GET" сверяем statusCode = "200" и  pathSchema = "ifellow_edu_jira/schemaOpenUrl.json"

  @АвторизацияПозитивныйКейс
  Сценарий: АвторизацияApi
    Дано Параметры авторизации на сайте:
      | keyUrl          | keyLogin  | keyPassword   | endpoint                      | method | statusCode | keyPathSchema                    |
      | UrlIfellowJira  | login     | password      | /rest/auth/1/session          | POST   | 200        | ifellow_edu_jira/schemaAuth.json |
    Тогда Авторизуемся на сайте

  @АвторизацияНеверныйЛогин
  Сценарий: АвторизацияApi
    Дано Параметры авторизации на сайте:
      | keyUrl          | keyLogin  | keyPassword   | endpoint                      | method | statusCode | keyPathSchema                    |
      | UrlIfellowJira  | AAAAA     | password      | /rest/auth/1/session          | POST   | 401        | нет                              |
    Тогда Авторизуемся на сайте

  @АвторизацияНеверныйПароль
  Сценарий: АвторизацияApi
    Дано Параметры авторизации на сайте:
      | keyUrl          | keyLogin  | keyPassword   | endpoint                      | method | statusCode | keyPathSchema                    |
      | UrlIfellowJira  | login     | QQQQQQQQ      | /rest/auth/1/session          | POST   | 401        | нет                              |
    Тогда Авторизуемся на сайте

  @ПодсчетЗадач
  Сценарий: Открываем прект и получаем количество задач в проекте
    Дано Параметры получения ключа проекта:
     | nameCoToProject  |  endpoint             | method | statusCode | pathSchema                               |
     | TEST             | /rest/api/2/project/  | GET    | 200        | ifellow_edu_jira/schemaGetProjectKey.json|
    Тогда Получаем ключ продукта
    Дано Параметры получения колмчества задач в проекте:
       |  endpoint             | method | statusCode | pathSchema                               |
       | /rest/api/2/search    | GET    | 200        | ifellow_edu_jira/schemaSearch.json       |
    Тогда Получаем количество задач в проекте API


  @СозданиеЗадачи
  Сценарий: Создаем задачу и переводим созданную задачу по статусам
    Дано Параметры создания задачи:
      |  endpoint             | method | statusCode | pathSchema                               |
      | /rest/api/2/issue     | POST   | 201        | ifellow_edu_jira/schemaCreateIssue.json  |
    Когда Создаем задач в проекте
    Затем Переводим созданную задачу по статусам API