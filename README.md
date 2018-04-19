# JShikiApi

### Краткое описание
Реализация API сайта [Shikimori.org](https://shikimori.org/) на Java.

### Установка 
#### Gradle
*Если ваш проект для `Windows`, `MacOS` или `Linux`, то все пути указаны относительно корневой папки проекта, для `Android` же все пути указаны относительно `%PROJECT_LOCATION%/app/`.*
1. Скачать [jar-файл](https://github.com/Firely-Pasha/JShikiApi/releases).
2. Переместить файл в папку `./libs/`.
3. Добавить `mavenCentral` и папку `./libs/` в список репозиториев в файле `./build.gradle`: 
    ```gradle
    repositories {
        mavenCentral()
        flatDir {
            dirs 'libs'
        }
    }
    ```
4. Подключить библиотеку к проекту:
    * Если ваш проект для `Android`, то необходимо в файле `./build.gradle` добавить следующее:
    ```gradle
    dependencies {
        // Название jar-файла.
        implementation name: 'JShikiApi'
        // Зависимость, необходимая для работы с JShikiApi на Android.
        implementation 'org.apache.httpcomponents:httpclient-android:4.3.5.1'
    }
    ```
    * Если ваш проект для `Windows`, `MacOS` или `Linux`, то необходимо в файле `./build.gradle` добавить следующее:
    ```gradle
    dependencies {
        // Название jar-файла.
        implementation name: "JShikiApi"
        // Зависимость, необходимая для работы с JShikiApi на Windows, MacOS и Linux.
        implementation 'org.apache.httpcomponents:httpclient:4.5.3'
    }
    ```
#### Source code
Если вы скачали проект, то для корректной работы API необходимо убрать следующую строчку в файле `pom.xml`:
```xml
<scope>provided</scope>
``` 
### [Документация](https://github.com/Firely-Pasha/JShikiApi/wiki)

### Контакты
Если есть какие-то вопросы или предложения:
* [ВКонтакте](https://vk.com/firely_pasha)
* [Shikimori](https://shikimori.org/Firely-Pasha)
* Firely-Pasha@ya.ru