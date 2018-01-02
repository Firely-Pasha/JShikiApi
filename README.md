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

### Документация (Не полная)
* [`Core`](./docs/Core.md) - содержит все методы взаимодействия с сайтом [Shikimori.org](https://shikimori.org/). 
* [`Items`](./docs/Items.md) - содержит все возвращаемые объекты.

### Контакты
Если есть какие-то вопросы или предложения:
* [ВКонтакте](https://vk.com/firely_pasha)
* [Shikimori](https://shikimori.org/Firely-Pasha)
* Firely-Pasha@ya.ru