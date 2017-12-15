[//]: # (Created by Firely-Pasha on 16.12.2017)

# Класс AnimeFull

Собственные методы:

* `String getRating()`
    * **Возвращает:** возрастной рейтинг аниме.

* `int getDuration()`
    * **Возвращает:** длительность эпизода.

* `String getUpdatedAt()`
    * **Возвращает:** дату последнего обновления.

* `String getNextEpisodeAt()`
    * **Возвращает:** дату следующего эпизода.

* `List<`[`Studio`](../Items/Studio.md)`> getStudios()`
    * **Возвращает:** студии.

* `List<`[`Video`](../Items/Video.md)`> getVideos()`
    * **Возвращает:** видео.

* `List<`[`Screenshot`](../Items/Screenshot.md)`> getScreenshots()`
    * **Возвращает:** скриншоты.


Методы, унаследованные от класса [`Anime`](Anime.md):

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
    * **Возвращает:** похожие аниме.

* [`Franchise`](../Items/Franchise.md)` getFranchise()`
    * **Возвращает:** франшизу, в которую входит аниме.

* `List<`[`ExternalLink`](../Items/ExternalLink.md)`> getExternalLinks()`
    * **Возвращает:** ссылки на внешние ресурсы.

Методы, унаследованные от интерфейса [`TitleFull`](TitleFull.md):

* `List<String> getEnglish()`
    * **Возвращает:** названия аниме на английском.

* `List<String> getJapanese()`
    * **Возвращает:** названия аниме на японском.

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
    * **Возвращает:** присутствует ли аниме в списке любимых.

* `boolean isAnons()`
    * **Возвращает:** является ли аниме анонсом.

* `boolean isOngoing()`
    * **Возвращает:** является ли аниме онгоингом.

* `int getThreadId()`
    * **Возвращает:** идентификатор треда аниме.

* `int getTopicId()`
    * **Возвращает:** идентификатор топика аниме.

* `int getMyanimelistId()`
    * **Возвращает:** идентификатор аниме на сайте [MyAnimeList](https://myanimelist.net/).

* `List<`[`RatesStatus`](../Items/RateStatus.md)`> getRatesStatusesStats()`
    * **Возвращает:** пары "*Оценка*" - "*Количество пользователей*".

* `List<`[`RatesScore`](../Items/RateScore.md)`> getRatesScoresStats()`
    * **Возвращает:** пары "*Статус просмотра*" - "*Количество пользователей*".

* `List<`[`Genre`](../Items/Genre.md)`> getGenres()`
    * **Возвращает:** жанры аниме.

* [`TitleUserRate`](../Items/TitleUserRate.md)` getTitleUserRate()`
    * **Возвращает:** данные пользователя о аниме.