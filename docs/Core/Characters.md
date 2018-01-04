[//]: # (Created by Firely-Pasha on 02.01.2018)

# Characters

[`net.pagala.JShikiApi`](../../README.md)`.`[`Сore`](../Core.md)`.`[`Characters`](../../src/main/java/net/pagala/JShikiApi/Core/Characters.java)

***Все методы в классе `Characters` - статические.***

Методы:

* [`CharacterFull`](../Items/CharacterFull.md)`get(int id)`
    * **Параметры**:
        * `int id` - идентификатор персонажа.
    * **Возвращает:** полную информацию о персонаже.
    
* ` List<`[`Character`](../Items/Character.md)`> getList(String searchString)`
    * **Параметры**:
        * [`Character`](../Items/Character.md)` searchString` - строка поиска.
    * **Возвращает:** список персонажей, имя которых содержит фрагмент из строки поиска.

* ` List<`[`Character`](../Items/Character.md)`> getCharacters(List<`[`Role`](../Items/Role.md)`> roleList)`
    * **Параметры**:
        * `List<`[`Role`](../Items/Role.md)`> roleList` - список ролей аниме.
    * **Возвращает:** список персонажей.

* ` List<`[`Character`](../Items/Character.md)`> getMainCharacters(List<`[`Role`](../Items/Role.md)`> roleList)`
    * **Параметры**:
        * `List<`[`Role`](../Items/Role.md)`> roleList` - список ролей.
    * **Возвращает:** список главных персонажей.

* ` List<`[`Character`](../Items/Character.md)`> getSupportingCharacters(List<`[`Role`](../Items/Role.md)`> roleList)`
    * **Параметры**:
        * `List<`[`Role`](../Items/Role.md)`> roleList` - список ролей.
    * **Возвращает:** список второстепенных персонажей.