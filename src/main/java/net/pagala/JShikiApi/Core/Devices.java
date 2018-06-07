package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.Device;
import net.pagala.JShikiApi.RequestItems.DeviceToCreate;
import net.pagala.JShikiApi.RequestItems.DeviceToUpdate;

import static net.pagala.JShikiApi.Core.Shikimori.*;

public final class Devices {

    private Devices() {

    }

    public static ApiCall<Device[]> getList(int limit, int page) {
        return getItem("/devices?limit=" + limit + "&page=" + page, Device[].class);
    }

    public static ApiCall<Device> create(DeviceToCreate deviceToCreate) {
        return postItem("/devices", deviceToCreate, Device.class);
    }

    public static ApiCall<Device> update(int id, DeviceToUpdate deviceToUpdate) {
        return postItem("/devices/" + id, deviceToUpdate, Device.class);
    }

    public static ApiCall delete(int id) {
        return deleteItem("/devices/" + id, null);
    }
}
