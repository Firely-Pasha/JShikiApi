[//]: # (Created by Firely-Pasha on 02.01.2018)

# People

[`net.pagala.JShikiApi`](../../README.md)`.`[`Сore`](../Core.md)`.`[`People`](../../src/main/java/net/pagala/JShikiApi/Core/People.java)

***Все методы в классе `People` - статические.***

Методы:

* [`CharacterFull`](../Items/CharacterFull.md)`get(int id)`
    * **Параметры**:
        * `int id` - идентификатор человека.
    * **Возвращает:** полную информацию о человеке.
    
* ` List<`[`Character`](../Items/Character.md)`> getList(String searchString)`
    * **Параметры**:
        * [`Character`](../Items/Character.md)` searchString` - строка поиска.
    * **Возвращает:** людей, имя которых содержит фрагмент из строки поиска.

* ` List<`[`Role`](../Items/Role.md)`> getPersons(List<`[`Role`](../Items/Role.md)`> roleList)`
    * **Параметры**:
        * `List<`[`Role`](../Items/Role.md)`> roleList` - список ролей.
    * **Возвращает:** список персон c ролями.

* ` List<`[`Character`](../Items/Character.md)`> getPersons(List<`[`Role`](../Items/Role.md)`> roleList, String... roleTypes)`
    * **Параметры**:
        * `List<`[`Role`](../Items/Role.md)`> roleList` - список ролей.
        * `String... roleTypes` - список нужных ролей.
    * **Возвращает:** список персон с нужными ролями.