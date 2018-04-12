package net.pagala.JShikiApi.Core;

import com.fasterxml.jackson.core.JsonProcessingException;
import net.pagala.JShikiApi.Items.Device;
import net.pagala.JShikiApi.RequestItems.DeviceToCreate;
import net.pagala.JShikiApi.RequestItems.DeviceToUpdate;

import java.util.List;

import static net.pagala.JShikiApi.Core.Shikimori.*;

public final class Devices {

    private Devices() {

    }

    public static List<Device> getList(int limit, int page) {
        if (Shikimori.getAccessToken() != null) {
            return getItemList("/devices?limit=" + limit + "&page=" + page, Device[].class);
        }
        return null;
    }

    public static Device create(DeviceToCreate deviceToCreate) {
        try {
            return postItem("/devices", getObjectMapper().writeValueAsString(deviceToCreate), Device.class, true);
        } catch (JsonProcessingException jpe) {
            jpe.printStackTrace();
        }
        return null;
    }

    public static Device update(int id, DeviceToUpdate deviceToUpdate) {
        try {
            return postItem("/devices/" + id, getObjectMapper().writeValueAsString(deviceToUpdate), Device.class, true);
        } catch (JsonProcessingException jpe) {
            jpe.printStackTrace();
        }
        return null;
    }

    public static void delete(int id) {
        deleteRequest("/devices/" + id, false);
    }
}
