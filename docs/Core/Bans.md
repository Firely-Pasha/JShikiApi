[//]: # (Created by Firely-Pasha on 02.01.2018)

# Bans

[`net.pagala.JShikiApi`](../../README.md)`.`[`Сore`](../Core.md)`.`[`Bans`](../../src/main/java/net/pagala/JShikiApi/Core/Bans.java)

***Все методы в классе `Bans` - статические.***

Методы:
* `List<`[`Ban`](../Items/Ban.md)`> getList(int limit, int page)`
    * **Параметры**:
        * `int limit` - количество возвращаемых объектов + 1 (`limit >= 0`).
        * `int page` - страница (`page > 0`).
    * **Возвращает:** список последних банов пользователей.