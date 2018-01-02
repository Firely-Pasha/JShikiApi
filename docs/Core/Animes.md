[//]: # (Created by Firely-Pasha on 02.01.2018)

# Animes

[`net.pagala.JShikiApi`](../../README.md)`.`[`Сore`](../Core.md)`.`[`Animes`](../../src/main/java/net/pagala/JShikiApi/Core/Animes.java)

***Все методы в классе `Animes` - статические.***

Методы:
* [`AnimeFull`](../Items/AnimeFull.md)`get(int id)`
    * **Параметры**:
        * `int id` - идентификатор аниме.
    * **Возвращает:** полную информацию об аниме.
    
* ` List<`[`Anime`](../Items/Anime.md)`> getList(`[`AnimeSearchFilter`](../Filters/SearchFilter/AnimeSearchFilter.md)` animeSearchFilter)`
    * **Параметры**:
        * [`AnimeSearchFilter`](../Filters/SearchFilter/AnimeSearchFilter.md)`animeSearchFilter` - критерии выбора аниме.
    * **Возвращает:** список аниме, которые соответствуют заданным критериям.
    
* `List<`[`Role`](../Items/Role.md)`> getRoles(int id)`
    * **Параметры**:
        * `int id` - идентификатор аниме.
    * **Возвращает:** список ролей в аниме.

* `List<`[`Relation`](../Items/Relation.md)`> getRelations(int id)`
    * **Параметры**:
        * `int id` - идентификатор аниме.
    * **Возвращает:** список связей с другими аниме.

* `List<`[`Anime`](../Items/Anime.md)`> getSimilar(int id)`
    * **Параметры**:
        * `int id` - идентификатор аниме.
    * **Возвращает:** список похожих аниме.

* [`Franchise`](../Items/Franchise.md)` getFranchise(int id)`
    * **Параметры**:
        * `int id` - идентификатор аниме.
    * **Возвращает:** франшизу, в которую входит аниме.

* `List<`[`ExternalLink`](../Items/ExternalLink.md)`> getExternalLinks(int id)`
    * **Параметры**:
        * `int id` - идентификатор аниме.
    * **Возвращает:** список ссылок на внешние ресурсы.