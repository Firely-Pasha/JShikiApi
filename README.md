# JShikiApi
### Описание
Реализация API сайта Shikimori.org на Java.

Если есть какие-то вопросы или предложения:
* [ВКонтакте](https://vk.com/firely_pasha)
* [Shikimori](https://shikimori.org/Firely-Pasha)
* Firely-Pasha@ya.ru

Авторизация:
```java
Shikimori.logIn("UserName", "Password");
```

Ипользование API:
```java
Shikimori.getAnime(animeId);
```

За поиск аниме по критериям отвечает SearchFilter. Манги пока нет.

Пример:
```java
SearchFilter searchFilter = new SearchFilter();
searchFilter.setLimit(20);
searchFilter.getSeasons().getYes().add(new SeasonYear(Season.SUMMER, 2007));
Shikimori.getAnimes(searchFilter);
```

Класс User предоставляет как статические, так и не сатические методы.
В первом случае нужно передать дополнительный параметр ``id``, во втором же будет использоваться id экземпляра класса.

```java
User user = Shikimori.getUser(userId);
user.getFriends();

User.getFriends(userId);
```