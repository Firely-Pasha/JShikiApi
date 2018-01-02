# JShikiApi

### Краткое описание
Реализация API сайта [Shikimori.org](https://shikimori.org/) на Java.

#### Ипользование API:

Авторизация:
```java
Shikimori.logIn("UserName", "Password");
```

Для получения и отправки данных используются классы в пакете [`net.pagala.JShikiApi.Core`](./docs/Core.md).

Пример:

```java
AnimeFull anime = Animes.get(animeId);

List<Manga> mangaList = Mangas.getList(mangaSearchFilter);

CommentToCreate commentToCreate = new CommentToCreate("Some comment", 1, CommentableType.ANIME);
int newCommentId = Comments.create(commentToCreate);
```

За поиск аниме по критериям отвечает `AnimeSearchFilter`, за поиск манги по критериям - `MangaSearchFilter`.

Пример:
```java
AnimeSearchFilter animeSearchFilter = new AnimeSearchFilter();
animeSearchFilter.setLimit(20);
animeSearchFilter.getSeasons().getYes().add(new SeasonYear(Season.SUMMER, 2007));
List<Anime> animeList = Animes.getList(animeSearchFilter);
```

### Документация (Неполная)
* [`Core`](./docs/Core.md) - содержит все методы взаимодействия с сайтом [Shikimori.org](https://shikimori.org/). 
* [`Items`](./docs/Items.md) - содержит все возвращаемые объекты.

### Контакты
Если есть какие-то вопросы или предложения:
* [ВКонтакте](https://vk.com/firely_pasha)
* [Shikimori](https://shikimori.org/Firely-Pasha)
* Firely-Pasha@ya.ru