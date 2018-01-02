[//]: # (Created by Firely-Pasha on 02.01.2018)

# Users

[`net.pagala.JShikiApi`](../../README.md)`.`[`Сore`](../Core.md)`.`[`Users`](../../src/main/java/net/pagala/JShikiApi/Core/Users.java)

### Документация неполная!

***Все методы в классе `Users` - статические.***

Методы:

* [`UserFull`](../Items/UserFull.md)`get(int id)`
    * **Параметры**:
        * `int id` - идентификатор пользователя.
    * **Возвращает:** полную информацию о пользователе.
    
* `List<`[`User`](../Items/User.md)`> getList(int limit, int page)`
    * **Параметры**:
        * `int limit` - количество возвращаемых объектов + 1.
        * `int page` - страница.
    * **Возвращает:** список пользователей.

* [`UserInfo`](../Items/UserFull.md)`whoAmI()`
    * **Возвращает:** информацию об авторизированном пользователе.
