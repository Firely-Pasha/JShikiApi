[//]: # (Created by Firely-Pasha on 16.12.2017)

# Интерфейс TitleFull

[`net.pagala.JShikiApi`](../../README.md)`.`[`Items`](../Items.md)`.`[`TitleFull`](../../src/main/java/net/pagala/JShikiApi/Items/TitleFull.java)

Методы:

* `List<String> getEnglish()`
    * **Возвращает:** названия тайтла на английском.

* `List<String> getJapanese()`
    * **Возвращает:** названия тайтла на японском.

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
    * **Возвращает:** присутствует ли тайтл в списке любимых.

* `boolean isAnons()`
    * **Возвращает:** является ли тайтл анонсом.

* `boolean isOngoing()`
    * **Возвращает:** является ли тайтл онгоингом.

* `int getThreadId()`
    * **Возвращает:** идентификатор треда тайтла.

* `int getTopicId()`
    * **Возвращает:** идентификатор топика тайтла.

* `int getMyanimelistId()`
    * **Возвращает:** идентификатор тайтла на сайте [MyAnimeList](https://myanimelist.net/).

* `List<`[`RatesStatus`](./RateStatus.md)`> getRatesStatusesStats()`
    * **Возвращает:** пары "*Оценка*" - "*Количество пользователей*".

* `List<`[`RatesScore`](./RateScore.md)`> getRatesScoresStats()`
    * **Возвращает:** пары "*Статус просмотра / чтения*" - "*Количество пользователей*".

* `List<`[`Genre`](./Genre.md)`> getGenres()`
    * **Возвращает:** жанры тайтла.

* [`TitleUserRate`](./TitleUserRate.md)` getTitleUserRate()`
    * **Возвращает:** данные пользователя о тайтле.