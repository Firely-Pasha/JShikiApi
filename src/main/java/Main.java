import net.pagala.JShikiApi.Core.*;
import net.pagala.JShikiApi.Items.AnimeFull;

import java.io.IOException;

//TODO: Catch URL-Level errors!!!
public class Main {

    public static void main(String[] args) throws IOException {
        Shikimori.setDeveloperName("Firely-Pasha");
        Shikimori.setAppName("JShikiApi");
        Shikimori.setClientId("");
        Shikimori.setClientSecret("");
////        Shikimori.refreshToken("args[2]");
//        Shikimori.setRedirectUrl("urn:ietf:wg:oauth:2.0:oob");
        Shikimori.setAccessToken("");
        Shikimori.showRequestUrl(true);
//        Shikimori.showResponse(true);

//        Animes.get(1).enqueue(getCallback());

//        Users.whoAmI().enqueue(getCallback());
//        Users.get(229069).enqueue(getCallback());

//        Shikimori.signUp("lssssol@yandex.ru", "ssss", "sadsasdas").enqueue(getCallback());
        int animeId = 0;

        try(ApiResponse<AnimeFull> animeResponse = Animes.get(animeId).execute()) {
            if (animeResponse.isSuccessful()) {
                AnimeFull animeFull = animeResponse.body();
                System.out.println(animeFull.getName());
            } else {
                System.out.println(animeResponse.code() + ": " + animeResponse.message());
                System.out.println("Body: " + animeResponse.prettyRawBody());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
////
        Animes.get(animeId).enqueue(new ApiCallback<AnimeFull>() {
            @Override
            public void onFailure(ApiCall<AnimeFull> call, Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onResponse(ApiCall<AnimeFull> call, ApiResponse<AnimeFull> response) {
                if (response.isSuccessful()) {
                    AnimeFull anime = response.body();
                    System.out.println(anime.getName());
                } else {
                    System.out.println(response.code() + ": " + response.message());
                    System.out.println("Body: " + response.prettyRawBody());
                }
            }
        });
    }
// Firely-Pasha: 69263
// Jimmy_Cool: 229069
// Test club: 1211

    private static <T> ApiCallback<T> getCallback() {
        return new ApiCallback<T>() {
            @Override
            public void onFailure(ApiCall<T> call, Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onResponse(ApiCall<T> call, ApiResponse<T> response) {
                System.out.println(response.code() + ": " + response.message());
                System.out.println("Body: " + response.prettyRawBody());
            }
        };
    }
}