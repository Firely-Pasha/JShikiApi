# Shikimori

***Все поля и методы в классе `Comments` - статические.***

Методы:
* `List<`[`Comment`](../Items/Comment.md)`> getList(`[`CommentFilter`](../Filters/CommentFilter/CommentFilter.md)` filter)`
    * **Параметры**:
        * [`CommentFilter`](../Filters/CommentFilter/CommentFilter.md)` filter` - критерии поиска комментариев.
    * **Возвращает:** комментарии, отобранные по заданному критерию.

* [`Comment`](../Items/Comment.md)` get(int commentId)`
    * **Параметры**:
        * `int commentId` - идентификатор комментария.
    * **Возвращает:** комментарий с данным идентификатором.

* `int create(`[`CommentToCreate`](../RequestItems/CommentToCreate.md)` comment)`
    * **Параметры**:
        * [`CommentToCreate`](../RequestItems/CommentToCreate.md)` comment` - комментарий, который нужно создать.
    * **Возвращает:** идентификатор созданного комментария.

* [`Comment`](../Items/Comment.md)` update(int commentId, String commentBody)`
    * **Параметры**:
        * `int commentId` - идентификатор комментария.
        * `String commentBody` - новое тело комментария.
    * **Возвращает:** обновленный комментарий.

* `String delete(int commentId)`
    * **Параметры**:
        * `int commentId` - идентификатор комментария.
    * **Возвращает:** результат удаления.
