# Shikimori

[`net.pagala.JShikiApi`](../../README.md)`.`[`Сore`](../Core.md)`.`[`Shikimori`](../../src/main/java/net/pagala/JShikiApi/Core/Shikimori.java)

***Все поля и методы в классе `Shikimori` - статические.***

Методы:

* `boolean logIn(String nickname, String password)`
    * **Параметры**:
        * `String nickname` - никнейм.
        * `String password` - пароль.
    * **Возвращает:** результат авторизации.
    * **Описание:** авторизация.
    
* `String getNickname()`
    * **Возвращает:** никнейм.

* `int getUserId()`
    * **Возвращает:** идентификатор пользователя.

* [`ObjectMapper`](https://fasterxml.github.io/jackson-databind/javadoc/2.5/com/fasterxml/jackson/databind/ObjectMapper.html)`getObjectMapper()`
    * **Возвращает:**  [`ObjectMapper`](https://fasterxml.github.io/jackson-databind/javadoc/2.5/com/fasterxml/jackson/databind/ObjectMapper.html).

Поля:
* `final String SITE_DOMAIN` - домен сайта.
* `final String API_DOMAIN` - адрес API.