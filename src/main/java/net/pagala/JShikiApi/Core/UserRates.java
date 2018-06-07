package net.pagala.JShikiApi.Core;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.pagala.JShikiApi.Filters.UserRateFilter.UserRateFilter;
import net.pagala.JShikiApi.Items.Notice;
import net.pagala.JShikiApi.Items.TitleType;
import net.pagala.JShikiApi.Items.UserRate;
import net.pagala.JShikiApi.RequestItems.UserRateToCreate;
import net.pagala.JShikiApi.RequestItems.UserRateToUpdate;

import static net.pagala.JShikiApi.Core.Shikimori.*;

public final class UserRates {

    private UserRates() {

    }

    public static ApiCall<UserRate> get(int id) {
        return getItem("/user_rates/" + id, UserRate.class, RequestVersion.API_V2);
    }

    public static ApiCall<UserRate[]> getList(UserRateFilter userRateFilter) {
        return getItem("/user_rates" + userRateFilter.build(), UserRate[].class, RequestVersion.API_V2);
    }

    public static ApiCall<UserRate> create(UserRateToCreate userRate) {
        return postItem("/user_rates", new UserRateAction<>(userRate), UserRate.class, RequestVersion.API_V2);
    }

    public static ApiCall<UserRate> update(int userRateId, UserRateToUpdate userRate) {
        return putItem("/user_rates/" + userRateId, new UserRateAction<>(userRate), UserRate.class, RequestVersion.API_V2);
    }

    public static ApiCall<UserRate> increment(int userRateId) {
        return postItem("/user_rates/" + userRateId + "/increment", "", UserRate.class, RequestVersion.API_V2);
    }

    public static void delete(int userRateId) {
        deleteItem("/user_rates/" + userRateId, null, RequestVersion.API_V2);
    }

    public static ApiCall<Notice> cleanup(TitleType titleType) {
        return deleteItem("/user_rates/" + titleType + "/cleanup", Notice.class);
    }


    public static ApiCall<Notice> reset(TitleType titleType) {
        return deleteItem("/user_rates/" + titleType + "/reset", Notice.class);
    }

    private static class UserRateAction<T> {
        @JsonProperty("user_rate")
        private final T userRate;

        private UserRateAction(T userRateToUpdate) {
            this.userRate = userRateToUpdate;
        }

        public T getUserRate() {
            return userRate;
        }
    }
}
