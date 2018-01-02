package net.pagala.JShikiApi.Core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import net.pagala.JShikiApi.Items.Device;
import net.pagala.JShikiApi.RequestItems.DeviceToCreate;
import net.pagala.JShikiApi.RequestItems.DeviceToUpdate;

import java.io.IOException;
import java.util.List;

import static net.pagala.JShikiApi.Core.Shikimori.*;

public final class Devices {

    private Devices() {

    }

    public static List<Device> getList(int limit, int page) {
        if (Shikimori.getUserId() != -1) {
            return getItemList("/devices?limit=" + limit + "&page=" + page, Device[].class);
        }

        return null;
    }

    public static Device create(DeviceToCreate deviceToCreate) {
        try {
            JsonNode jsonDevice = postRequest("/devices", getObjectMapper().writeValueAsString(deviceToCreate), true);
            return getObjectMapper().readValue(jsonDevice.toString(), Device.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Device update(int id, DeviceToUpdate deviceToUpdate) {
        try {
            JsonNode jsonDevice = putRequest("/devices/" + id, getObjectMapper().writeValueAsString(deviceToUpdate), true);
            return getObjectMapper().readValue(jsonDevice.toString(), Device.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void delete(int id) {
        deleteRequest("/devices/" + id, false);
    }
}
