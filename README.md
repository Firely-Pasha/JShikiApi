# JShikiApi

### Краткое описание
Реализация API сайта Shikimori.org на Java.

Авторизация:
```java
Shikimori.logIn("UserName", "Password");
```

Ипользование API:
```java
Shikimori.getAnime(animeId);
```

За поиск аниме по критериям отвечает ``AnimeSearchFilter``, за поиск по манге - ``MangaSearchFilter``.

Пример:
```java
AnimeSearchFilter animeSearchFilter = new AnimeSearchFilter();
animeSearchFilter.setLimit(20);
animeSearchFilter.getSeasons().getYes().add(new SeasonYear(Season.SUMMER, 2007));
List<Anime> animes = Shikimori.getAnimes(animeSearchFilter);
```

Класс User предоставляет как статические, так и не сатические методы.
В первом случае нужно передать дополнительный параметр ``id``, во втором же будет использоваться id экземпляра класса.

```java
User user = Shikimori.getUser(userId);
user.getFriends();

User.getFriends(userId);
```

### Документация
Классы:
* Core:
    * [`Anime`](docs/Core/Anime.md) - основная информация об аниме;
    * [`AnimeFull`](docs/Core/Anime.md) - полная информация об аниме;
    * [`Comments`](docs/Core/Comments.md) - содержит методы для работы с комментариями;
    * [`Manga`](docs/Core/Manga.md) - основная информация о манге;
    * [`MangaFull`](docs/Core/MangaFull.md) - полная информация о манге;
    * [`Shikimori`](docs/Core/Shikimori.md) - содержит основные методы.

### Контакты
Если есть какие-то вопросы или предложения:
* [ВКонтакте](https://vk.com/firely_pasha)
* [Shikimori](https://shikimori.org/Firely-Pasha)
* Firely-Pasha@ya.ru