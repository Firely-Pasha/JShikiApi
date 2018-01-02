[//]: # (Created by Firely-Pasha on 16.12.2017)

# Класс MangaFull

[`net.pagala.JShikiApi`](../../README.md)`.`[`Items`](../Items.md)`.`[`MangaFull`](../../src/main/java/net/pagala/JShikiApi/Items/MangaFull.java)


Собственные методы:

* `List<`[`Publisher`](./Publisher.md)`> getPublishers()`
    * **Возвращает:** издательства.

Методы, унаследованные от класса [`Manga`](./Manga.md):

* `int getVolumes()`
    * **Возвращает:** количество томов.

* `int getChapters()`
    * **Возвращает:** количество глав.

Методы, унаследованные от интерфейса [`Title`](./Title.md):

* `int getId()`
    * **Возвращает:** идентификатор манги.

* `String getName()`
    * **Возвращает:** название манги.

* `String getRussian()`
    * **Возвращает:** название манги на русском.

* [`Image`](./Image.md) ` getImage()`
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

* `List<`[`Role`](./Role.md)`> getRoles()`
    * **Возвращает:** роли в манге.

* `List<`[`Relation`](./Relation.md)`> getRelations()`
    * **Возвращает:** связи с другими мангами.

* `List<`[`Manga`](./Manga.md)`> getSimilar()`
    * **Возвращает:** похожую мангу.

* [`Franchise`](./Franchise.md)` getFranchise()`
    * **Возвращает:** франшизу, в которую входит манга.

* `List<`[`ExternalLink`](./ExternalLink.md)`> getExternalLinks()`
    * **Возвращает:** ссылки на внешние ресурсы.

Методы, унаследованные от интерфейса [`TitleFull`](./TitleFull.md):

* `List<String> getEnglish()`
    * **Возвращает:** названия манги на английском.

* `List<String> getJapanese()`
    * **Возвращает:** названия манги на японском.

* `List<String> getSynonyms()`
    * **Возвращает:** синонимы.

* `String getScore()`
    * **Возвращает:** рейтинг.

* `String getDescription()`
    * **Возвращает:** описание в формате BBCode.

* `String getDescriptionHtml()`
    * **Возвращает:** описание в формате HTML.

* `String getDescriptionSource()`
    * **Возвращает:** источник описания.

* `boolean isFavoured()`
    * **Возвращает:** присутствует ли манга в списке любимых.

* `boolean isAnons()`
    * **Возвращает:** является ли манга анонсом.

* `boolean isOngoing()`
    * **Возвращает:** является ли манга онгоингом.

* `int getThreadId()`
    * **Возвращает:** идентификатор треда манги.

* `int getTopicId()`
    * **Возвращает:** идентификатор топика манги.

* `int getMyanimelistId()`
    * **Возвращает:** идентификатор манги на сайте [MyAnimeList](https://myanimelist.net/).

* `List<`[`RatesStatus`](./RateStatus.md)`> getRatesStatusesStats()`
    * **Возвращает:** пары "*Оценка*" - "*Количество пользователей*".

* `List<`[`RatesScore`](./RateScore.md)`> getRatesScoresStats()`
    * **Возвращает:** пары "*Статус чтения*" - "*Количество пользователей*".

* `List<`[`Genre`](./Genre.md)`> getGenres()`
    * **Возвращает:** жанры манги.

* [`TitleUserRate`](./TitleUserRate.md)` getTitleUserRate()`
    * **Возвращает:** данные пользователя о манге.