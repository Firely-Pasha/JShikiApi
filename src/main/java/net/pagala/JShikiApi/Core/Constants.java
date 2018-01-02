package net.pagala.JShikiApi.Core;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.pagala.JShikiApi.Items.ClubConstants;
import net.pagala.JShikiApi.Items.Smile;
import net.pagala.JShikiApi.Items.TitleConstants;
import net.pagala.JShikiApi.Items.UserRateConstants;

import java.util.Collections;
import java.util.List;

import static net.pagala.JShikiApi.Core.Shikimori.getItem;
import static net.pagala.JShikiApi.Core.Shikimori.getItemList;

public final class Constants {

    private Constants() {

    }

    public static TitleConstants getAnime() {
        return getItem("/constants/anime", TitleConstants.class);
    }


    public static TitleConstants getManga() {
        return getItem("/constants/manga", TitleConstants.class);
    }

    public static UserRateConstants getUserRate() {
        return getItem("/constants/user_rate", UserRateConstants.class);
    }

    public static ClubConstants getClub() {
        return getItem("/constants/club", ClubConstants.class);
    }

    public static List<Smile> getSmiles() {
        return getItemList("/constants/smileys", Smile[].class);
    }
}