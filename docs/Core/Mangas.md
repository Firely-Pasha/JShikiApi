[//]: # (Created by Firely-Pasha on 02.01.2018)

# Mangas

[`net.pagala.JShikiApi`](../../README.md)`.`[`Сore`](../Core.md)`.`[`Mangas`](../../src/main/java/net/pagala/JShikiApi/Core/Mangas.java)

***Все методы в классе `Mangas` - статические.***

Методы:
* [`MangaFull`](../Items/MangaFull.md)`get(int id)`
    * **Параметры**:
        * `int id` - идентификатор манги.
    * **Возвращает:** полную информацию о манге.

* ` List<`[`Manga`](../Items/Manga.md)`> getList(`[`MangaSearchFilter`](../Filters/SearchFilter/MangaSearchFilter.md)` mangaSearchFilter)`
    * **Параметры**:
        * [`MangaSearchFilter`](../Filters/SearchFilter/MangaSearchFilter.md)` mangaSearchFilter` - критерии выбора манги.
    * **Возвращает:** список манг(?), которые соответствуют заданным критериям.

* `List<`[`Role`](../Items/Role.md)`> getRoles(int id)`
    * **Параметры**:
        * `int id` - идентификатор манги.
    * **Возвращает:** список ролей в манге.

* `List<`[`Relation`](../Items/Relation.md)`> getRelations(int id)`
    * **Параметры**:
        * `int id` - идентификатор манги.
    * **Возвращает:** список связей с другими мангами.

* `List<`[`Manga`](../Manga.md)`> getSimilar(int id)`
    * **Параметры**:
        * `int id` - идентификатор манги.
    * **Возвращает:** список похожих манг.

* [`Franchise`](../Items/Franchise.md)` getFranchise(int id)`
    * **Параметры**:
        * `int id` - идентификатор манги.
    * **Возвращает:** франшизу, в которую входит манга.

* `List<`[`ExternalLink`](../Items/ExternalLink.md)`> getExternalLinks(int id)`
    * **Параметры**:
        * `int id` - идентификатор манги.
    * **Возвращает:** список ссылок на внешние ресурсы.