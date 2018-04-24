package net.pagala.JShikiApi.Core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import net.pagala.JShikiApi.Filters.UserRateFilter.UserRateFilter;
import net.pagala.JShikiApi.Items.TitleType;
import net.pagala.JShikiApi.Items.UserRate;
import net.pagala.JShikiApi.RequestItems.UserRateToCreate;
import net.pagala.JShikiApi.RequestItems.UserRateToUpdate;

import java.util.List;

import static net.pagala.JShikiApi.Core.Shikimori.*;

public final class UserRates {

    private UserRates() {

    }

    public static UserRate get(int id) {
        switchApiVersion(RequestVersion.API_V2);
        return getItem("/user_rates/" + id, UserRate.class);
    }

    public static List<UserRate> getList(UserRateFilter userRateFilter) {
        switchApiVersion(RequestVersion.API_V2);
        return getItemList("/user_rates" + userRateFilter.build(), UserRate[].class);
    }

    public static UserRate create(UserRateToCreate userRate) {
        switchApiVersion(RequestVersion.API_V2);
        JsonNode response = postRequest("/user_rates", userRate.build(), true);
        return makeUserRateFromJson(response);
    }

    public static UserRate update(int userRateId, UserRateToUpdate userRate) {
        switchApiVersion(RequestVersion.API_V2);
        JsonNode response = putRequest("/user_rates/" + userRateId, userRate.build(), true);
        return makeUserRateFromJson(response);
    }

    public static UserRate increment(int userRateId) {
        switchApiVersion(RequestVersion.API_V2);
        JsonNode response = postRequest("/user_rates/" + userRateId + "/increment", null, true);
        return makeUserRateFromJson(response);
    }

    public static void delete(int userRateId) {
        switchApiVersion(RequestVersion.API_V2);
        deleteRequest("/user_rates/" + userRateId, false);
    }

    public static JsonNode cleanup(TitleType titleType) {
        return deleteRequest("/user_rates/" + titleType + "/cleanup", true);
    }


    public static JsonNode reset(TitleType titleType) {
        return deleteRequest("/user_rates/" + titleType + "/reset", true);
    }

    private static UserRate makeUserRateFromJson(JsonNode jsonUserRate) {
        UserRate userRate = null;
        try {
            userRate = mapper.treeToValue(jsonUserRate, UserRate.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return userRate;
    }
}
