# Shikimori

***Все поля и методы в классе `Shikimori` - статические.***

Методы:

* `boolean logIn(String nickname, String password)`
    * **Параметры**:
        * `String nickname` - никнейм.
        * `String password` - пароль.
    * **Возвращает:** результат авторизации.
    * **Описание:** авторизация.
    
* [`AnimeFull`](AnimeFull.md)`getAnime(int id)`
    * **Параметры**:
        * `int id` - идентификатор аниме.
    * **Возвращает:** полную информацию об аниме.
    
* [`MangaFull`](MangaFull.md)`getManga(int id)`
    * **Параметры**:
        * `int id` - идентификатор манги.
    * **Возвращает:** полную информацию о манге.
    
* [`MangaFull`](MangaFull.md)`getRanobe(int id)`
    * **Параметры**:
        * `int id` - идентификатор ранобэ.
    * **Возвращает:** полную информацию о ранобэ.

* [`CharacterFull`](../Items/CharacterFull.md)`getCharacter(int id)`
    * **Параметры**:
        * `int id` - идентификатор персонажа.
    * **Возвращает:** полную информацию о персонаже.

* [`CharacterFull`](../Items/CharacterFull.md)`getHuman(int id)`
    * **Параметры**:
        * `int id` - идентификатор человека.
    * **Возвращает:** полную информацию о человеке.

* [`UserFull`](../Items/UserFull.md)`getUser(int id)`
    * **Параметры**:
        * `int id` - идентификатор пользователя.
    * **Возвращает:** полную информацию о пользователе.

* [`UserFull`](../Items/UserFull.md)`whoAmI()`
    * **Возвращает:** полную информацию о текущем авторизированном пользователе.

* [`ClubFull`](ClubFull.md)`getClub(int id)`
    * **Параметры**:
        * `int id` - идентификатор клуба.
    * **Возвращает:** полную информацию о клубе.

* `List<`[`CalendarItem`](../Items/CalendarItem.md)`> getCalendar()`
    * **Параметры**:
        * `int id` - идентификатор клуба.
    * **Возвращает:** календарь онгоингов.

* ` List<`[`Anime`](Anime.md)`> getAnimes(`[`AnimeSearchFilter`](#)` animeSearchFilter)`
    * **Параметры**:
        * [`AnimeSearchFilter`](../Filters/SearchFilter/AnimeSearchFilter.md)`animeSearchFilter` - критерии выбора аниме.
    * **Возвращает:** аниме, которые соответствуют заданным критериям.

* ` List<`[`Manga`](Manga.md)`> getMangas(`[`MangaSearchFilter`](../Filters/SearchFilter/MangaSearchFilter.md)` mangaSearchFilter)`
    * **Параметры**:
        * [`MangaSearchFilter`](../Filters/SearchFilter/MangaSearchFilter.md)` mangaSearchFilter` - критерии выбора манги.
    * **Возвращает:** манги, которые соответствуют заданным критериям.

* ` List<`[`Character`](../Items/Character.md)`> getCharacters(String searchString)`
    * **Параметры**:
        * [`Character`](../Items/Character.md)` searchString` - строка поиска.
    * **Возвращает:** персонажей, имя которых содержит фрагмент из строки поиска.

* ` List<`[`Character`](../Items/Character.md)`> getPeople(String searchString)`
    * **Параметры**:
        * [`Character`](../Items/Character.md)` searchString` - строка поиска.
    * **Возвращает:** людей, имя которых содержит фрагмент из строки поиска.

* `List<`[`Genre`](../Items/Genre.md)`> getGenres()`
    * **Возвращает:** все жанры.

* `List<`[`Ban`](../Items/Ban.md)`> getBans(int limit, int page)`
    * **Параметры**:
        * `int limit` - количество возвращаемых объектов + 1 (`limit >= 0`).
        * `int page` - страница (`page > 0`).
    * **Возвращает:** последние баны пользователей.

* `List<`[`Club`](Club.md)`> getClubs(int limit, int page)`
    * **Параметры**:
        * `int limit` - количество возвращаемых объектов + 1 (`limit >= 0`).
        * `int page` - страница (`page > 0`).
    * **Возвращает:** клубы.

* `List<`[`Club`](Club.md)`> getClubs(int limit, int page, String searchString)`
    * **Параметры**:
        * `int limit` - количество возвращаемых объектов + 1 (`limit >= 0`).
        * `int page` - страница (`page > 0`).
        * `String searchString` - строка поиска.
    * **Возвращает:** клубы, название которых содержит фрагмент из строки поиска.

* [`Topic`](../Items/Topic.md)`getTopic(int id)`
    * **Параметры**:
        * `int id` - идентификатор топика.
    * **Возвращает:** топик.

* `List<`[`Topic`](../Items/Topic.md)`> getTopics(`[`Forums`](#)` forum, int limit, int page)`
    * **Параметры**:
        * [`Forums`](../Items/Forum.md)` forum` - форум.
        * `int limit` - количество возвращаемых объектов + 1 (`limit >= 0`).
        * `int page` - страница (`page > 0`).
    * **Возвращает:** топики определенного форума.

* `List<`[`Studio`](../Items/Studio.md)`> getStudios()`
    * **Возвращает:** все студии.

* `List<`[`Publisher`](../Items/Publisher.md)`> getStudios()`
    * **Возвращает:** всех издателей.

* `List<`[`Forum`](../Items/Forum.md)`> getForums()`
    * **Возвращает:** все форумы.

* `String getNickname()`
    * **Возвращает:** никнейм.

* `int getUserId()`
    * **Возвращает:** идентификатор пользователя.

* `void setAppName(String appName)`
    * **Параметры**:
        * `String appName` - название программы (должно состоять только из цифр и больших и маленьких латинских букв).
    * **Описание:** меняет название программы.

* [`ObjectMapper`](https://fasterxml.github.io/jackson-databind/javadoc/2.5/com/fasterxml/jackson/databind/ObjectMapper.html)`getObjectMapper()`
    * **Возвращает:**  [`ObjectMapper`](https://fasterxml.github.io/jackson-databind/javadoc/2.5/com/fasterxml/jackson/databind/ObjectMapper.html).

Поля:
* `final String SITE_DOMAIN` - домен сайта.
* `final String API_DOMAIN` - адрес API.