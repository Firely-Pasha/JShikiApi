[//]: # (Created by Firely-Pasha on 02.01.2018)

# Clubs

[`net.pagala.JShikiApi`](../../README.md)`.`[`Сore`](../Core.md)`.`[`Clubs`](../../src/main/java/net/pagala/JShikiApi/Core/Clubs.java)

### Документация неполная!

***Все методы в классе `Clubs` - статические.***

Методы:

* [`ClubFull`](ClubFull.md)`get(int id)`
    * **Параметры**:
        * `int id` - идентификатор клуба.
    * **Возвращает:** полную информацию о клубе


* `List<`[`Club`](Club.md)`> getList(int limit, int page)`
    * **Параметры**:
        * `int limit` - количество возвращаемых объектов + 1 (`limit >= 0`).
        * `int page` - страница (`page > 0`).
    * **Возвращает:** список клубов.

* `List<`[`Club`](Club.md)`> getList(int limit, int page, String searchString)`
    * **Параметры**:
        * `int limit` - количество возвращаемых объектов + 1 (`limit >= 0`).
        * `int page` - страница (`page > 0`).
        * `String searchString` - строка поиска.
    * **Возвращает:** список клубов, название которых содержит фрагмент из строки поиска.