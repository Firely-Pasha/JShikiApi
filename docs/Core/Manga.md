[//]: # (Created by Firely-Pasha on 16.12.2017)

# Класс Manga

Собственные методы:

* `int getVolumes()`
    * **Возвращает:** количество томов.

* `int getChapters()`
    * **Возвращает:** количество глав.

Методы, унаследованные от интерфейса [`Title`](Title.md):

* `int getId()`
    * **Возвращает:** идентификатор манги.

* `String getName()`
    * **Возвращает:** название манги.

* `String getRussian()`
    * **Возвращает:** название манги на русском.

* [`Image`](../Items/Image.md) ` getImage()`
    * **Возвращает:** постер.

* `String getUrl()`
    * **Возвращает:** адрес манги на сайте.

* `String getKind()`
    * **Возвращает:** тип манги.

* `String getStatus()`
    * **Возвращает:** статус выхода.

* `Date getAiredOn()`
    * **Возвращает:** дату начала публикации.

* `Date getReleasedOn()`
    * **Возвращает:** дату конца публикации.

* `List<`[`Role`](../Items/Role.md)`> getRoles()`
    * **Возвращает:** роли в манге.

* `List<`[`Relation`](../Items/Relation.md)`> getRelations()`
    * **Возвращает:** связи с другими мангами.

* `List<`[`Manga`](Manga.md)`> getSimilar()`
    * **Возвращает:** похожую мангу.

* [`Franchise`](../Items/Franchise.md)` getFranchise()`
    * **Возвращает:** франшизу, в которую входит манга.

* `List<`[`ExternalLink`](../Items/ExternalLink.md)`> getExternalLinks()`
    * **Возвращает:** ссылки на внешние ресурсы.