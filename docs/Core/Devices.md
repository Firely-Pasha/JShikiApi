[//]: # (Created by Firely-Pasha on !!.!!.2018)

# Devices

[`net.pagala.JShikiApi`](../../README.md)`.`[`Сore`](../Core.md)`.`[`Devices`](../../src/main/java/net/pagala/JShikiApi/Core/Devices.java)

***Все методы в классе `Devices` - статические.***

Методы:
* `List<`[`Device`](../Items/Device.md)`> getList(int limit, int page)`
    * **Параметры**:
        * `int limit` - количество возвращаемых объектов + 1 (`limit >= 0`).
        * `int page` - страница (`page > 0`).
    * **Возвращает:** список девайсов.
    
* [`Device`](../Items/Device.md)` create(`[`DeviceToCreate`](../RequestItems/DeviceToCreate.md)` deviceToCreate)`
    * **Параметры**:
        * `DeviceToCreate deviceToCreate` - новый девайс.
    * **Возвращает:** новый девайс.
    
* [`Device`](../Items/Device.md)` update(`[`DeviceToUpdate`](../RequestItems/DeviceToUpdate.md)` deviceToUpdate)`
    * **Параметры**:
        * `DeviceToUpdate deviceToUpdate` - измененный девайс.
    * **Возвращает:** измененный девайс.
    
* `void delete(int id)`
    * **Описание**: удаляет девайс.