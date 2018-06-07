# JShikiApi

### Краткое описание
Реализация API сайта [Shikimori.org](https://shikimori.org/) на Java.

### Установка 
#### Gradle
*Если ваш проект для `Windows`, `MacOS` или `Linux`, то все пути указаны относительно корневой папки проекта, для `Android` же все пути указаны относительно `%PROJECT_LOCATION%/app/`.*
1. Скачать [jar-файл](https://github.com/Firely-Pasha/JShikiApi/releases).
2. Переместить файл в папку `./libs/`.
3. Добавить папку `./libs/` в список репозиториев в файле `./build.gradle`: 
    ```gradle
    repositories {
        flatDir {
            dirs 'libs'
        }
    }
    ```
4. Подключить библиотеку к проекту:
    ```gradle
    dependencies {
        // Название jar-файла.
        implementation name: 'JShikiApi' // Или 'compile name: ...'.
    }
    ```
### [Документация](https://github.com/Firely-Pasha/JShikiApi/wiki)

Пример синхронного запроса: 

```java
try(ApiResponse<AnimeFull> animeResponse = Animes.get(animeId).execute()) {
    if (animeResponse.isSuccessful()) {
        AnimeFull animeFull = animeResponse.body();
        System.out.println(animeFull.getName());
    } else {
        System.out.println(animeResponse.code() + ": " + animeResponse.message());
        System.out.println("Body: " + animeResponse.prettyRawBody());
    }
} catch (Exception e) {
    e.printStackTrace();
}
```

Пример асинхронного запроса:
```java
Animes.get(animeId).enqueue(new ApiCallback<AnimeFull>() {
    @Override
    public void onFailure(ApiCall<AnimeFull> call, Throwable t) {
        t.printStackTrace();
    }

    @Override
    public void onResponse(ApiCall<AnimeFull> call, ApiResponse<AnimeFull> response) {
        if (response.isSuccessful()) {
            AnimeFull anime = response.body();
            System.out.println(anime.getName());
        } else {
            System.out.println(response.code() + ": " + response.message());
            System.out.println("Body: " + response.prettyRawBody());
        }
    }
});
```