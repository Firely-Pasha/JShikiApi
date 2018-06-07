package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.ClubConstants;
import net.pagala.JShikiApi.Items.Smile;
import net.pagala.JShikiApi.Items.TitleConstants;
import net.pagala.JShikiApi.Items.UserRateConstants;

import static net.pagala.JShikiApi.Core.Shikimori.getItem;

public final class Constants {

    private Constants() {

    }

    public static ApiCall<TitleConstants> getAnime() {
        return getItem("/constants/anime", TitleConstants.class);
    }


    public static ApiCall<TitleConstants> getManga() {
        return getItem("/constants/manga", TitleConstants.class);
    }

    public static ApiCall<UserRateConstants> getUserRate() {
        return getItem("/constants/user_rate", UserRateConstants.class);
    }

    public static ApiCall<ClubConstants> getClub() {
        return getItem("/constants/club", ClubConstants.class);
    }

    public static ApiCall<Smile[]> getSmiles() {
        return getItem("/constants/smileys", Smile[].class);
    }
}