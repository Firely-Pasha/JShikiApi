[//]: # (Created by Firely-Pasha on 02.01.2018)

# Topics

[`net.pagala.JShikiApi`](../../README.md)`.`[`Сore`](../Core.md)`.`[`Topics`](../../src/main/java/net/pagala/JShikiApi/Core/Topics.java)

***Все методы в классе `Topics` - статические.***

Методы:

* [`Topic`](../Items/Topic.md)`get(int id)`
    * **Параметры**:
        * `int id` - идентификатор топика.
    * **Возвращает:** топик.

* `List<`[`Topic`](../Items/Topic.md)`> getList(`[`Forums`](#)` forum, int limit, int page)`
    * **Параметры**:
        * [`Forums`](../Items/Forum.md)` forum` - форум.
        * `int limit` - количество возвращаемых объектов + 1 (`limit >= 0`).
        * `int page` - страница (`page > 0`).
    * **Возвращает:** топики определенного форума.