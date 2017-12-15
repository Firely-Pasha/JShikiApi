[//]: # (Created by Firely-Pasha on 16.12.2017)

# Интерфейс Title

Методы:

* `int getId()`
    * **Возвращает:** идентификатор тайтла.

* `String getName()`
    * **Возвращает:** название тайтла.

* `String getRussian()`
    * **Возвращает:** название тайтла на русском.

* [`Image`](../Items/Image.md) ` getImage()`
    * **Возвращает:** постер.

* `String getUrl()`
    * **Возвращает:** адрес тайтла на сайте.

* `String getKind()`
    * **Возвращает:** тип тайтла.

* `String getStatus()`
    * **Возвращает:** статус выхода.

* `Date getAiredOn()`
    * **Возвращает:** дату начала показа / публикации.

* `Date getReleasedOn()`
    * **Возвращает:** дату конца показа / публикации.

* `List<`[`Role`](../Items/Role.md)`> getRoles()`
    * **Возвращает:** роли в тайтле.

* `List<`[`Relation`](../Items/Relation.md)`> getRelations()`
    * **Возвращает:** связи с другими тайтлами.

* `<E extends `[`Title`](Title.md)`> List<E> getSimilar()`
    * **Возвращает:** похожие тайтлы.

* [`Franchise`](../Items/Franchise.md)` getFranchise()`
    * **Возвращает:** франшизу, в которую входит тайтл.

* `List<`[`ExternalLink`](../Items/ExternalLink.md)`> getExternalLinks()`
    * **Возвращает:** ссылки на внешние ресурсы.
