[//]: # (Created by Firely-Pasha on 16.12.2017)

# Класс Anime

Собственные методы:

* `int getEpisodes()`
    * **Возвращает:** количество эпизодов.

* `int getEpisodesAired()`
    * **Возвращает:** количество эпизодов на данный момент.

Методы, унаследованные от интерфейса [`Title`](Title.md):

* `int getId()`
    * **Возвращает:** идентификатор аниме.

* `String getName()`
    * **Возвращает:** название аниме.

* `String getRussian()`
    * **Возвращает:** название аниме на русском.

* [`Image`](../Items/Image.md) ` getImage()`
    * **Возвращает:** постер.

* `String getUrl()`
    * **Возвращает:** адрес аниме на сайте.

* `String getKind()`
    * **Возвращает:** тип аниме.

* `String getStatus()`
    * **Возвращает:** статус выхода.

* `Date getAiredOn()`
    * **Возвращает:** дату начала показа.

* `Date getReleasedOn()`
    * **Возвращает:** дату конца показа.

* `List<`[`Role`](../Items/Role.md)`> getRoles()`
    * **Возвращает:** роли в аниме.

* `List<`[`Relation`](../Items/Relation.md)`> getRelations()`
    * **Возвращает:** связи с другими аниме.

* `List<`[`Anime`](Anime.md)`> getSimilar()`
    * **Возвращает:** похожее аниме.

* [`Franchise`](../Items/Franchise.md)` getFranchise()`
    * **Возвращает:** франшизу, в которую входит аниме.

* `List<`[`ExternalLink`](../Items/ExternalLink.md)`> getExternalLinks()`
    * **Возвращает:** ссылки на внешние ресурсы.