import net.pagala.JShikiApi.Core.*;
import net.pagala.JShikiApi.Filters.SearchFilter.*;
import net.pagala.JShikiApi.Items.*;
import net.pagala.JShikiApi.Items.TitleStatus;
import net.pagala.JShikiApi.Usr.AnimeRate;
import net.pagala.JShikiApi.Usr.HistoryItem;

import java.io.IOException;
import java.util.List;

//TODO: Catch URL-Level errors!!!
public class Main {

    public static void main(String[] args) throws IOException {
    	Shikimori.logIn("Firely-Pasha", "Goinass19981");
//        ApiCheck.getAnimeCheck();
//    	ApiCheck.getAnimeRatesCheck();
        SearchFilter searchFilter = new SearchFilter();
        searchFilter.setLimit(10);
        searchFilter.setScore(7);
        System.out.println(Shikimori.getAnimes(searchFilter).get(0).getName());
    }

    private static class ApiCheck {

        private static void getAnimeCheck() {
            AnimeFull anime = Shikimori.getAnime(1);
            System.out.println("Anime check: ");
            System.out.println("\tID: " + anime.getId());
            System.out.println("\tName: " + anime.getName());
            System.out.println("\tRussian: " + anime.getRussian());
            System.out.println("\tImage: ");
            System.out.println("\t\tOriginal: " + anime.getImage().getOriginal());
            System.out.println("\t\tPreview: " + anime.getImage().getPreview());
            System.out.println("\t\tx96: " + anime.getImage().getX96());
            System.out.println("\t\tx48: " + anime.getImage().getX48());
            System.out.println("\tURL: " + anime.getUrl());
            System.out.println("\tKind: " + anime.getKind());
            System.out.println("\tStatus: " + anime.getStatus());
            System.out.println("\tEpisodes: " + anime.getEpisodes());
            System.out.println("\tEpisodes aired: " + anime.getEpisodesAired());
            System.out.println("\tAired on: " + anime.getAiredOn());
            System.out.println("\tReleased on: " + anime.getReleasedOn());
            System.out.println("\tRating: " + anime.getRating());

            System.out.println("\tEnglish: ");
            List<String> englishNames = anime.getEnglish();
            for (String englishName : englishNames) {
                System.out.println("\t\t" + englishName);
            }

            System.out.println("\tJapanese: ");
            List<String> japaneseNames = anime.getJapanese();
            for (String japaneseName : japaneseNames) {
                System.out.println("\t\t" + japaneseName);
            }

            System.out.println("\tSynonyms: ");
            List<String> synonymsNames = anime.getSynonyms();
            for (String synonymsName : synonymsNames) {
                System.out.println("\t\t" + synonymsName);
            }

            System.out.println("\tDuration: " + anime.getDuration());
            System.out.println("\tScore: " + anime.getScore());
            System.out.println("\tDescription: " + anime.getDescription());
            System.out.println("\tDescription HTML: " + anime.getDescriptionHtml());
            System.out.println("\tDescription source: " + anime.getDescriptionSource());
            System.out.println("\tFavoured: " + anime.isFavoured());
            System.out.println("\tAnons: " + anime.isAnons());
            System.out.println("\tOngoing: " + anime.isOngoing());
            System.out.println("\tThread ID: " + anime.getThreadId());
            System.out.println("\tTopic ID: " + anime.getTopicId());
            System.out.println("\tMyAnimeList ID: " + anime.getMyanimelistId());

            System.out.println("\tRates scores stats: ");
            List<RatesScore> ratesScores = anime.getRatesScoresStats();
            for (RatesScore ratesScore : ratesScores) {
                System.out.println("\t\t" + ratesScore.getName() + " -> " + ratesScore.getValue());
            }

            System.out.println("\tRates statuses stats: ");
            List<RatesStatus> ratesStatuses = anime.getRatesStatusesStats();
            for (RatesStatus ratesStatus : ratesStatuses) {
                System.out.println("\t\t" + ratesStatus.getName() + " -> " + ratesStatus.getValue());
            }

            System.out.println("\tUpdated at: " + anime.getUpdatedAt());
            System.out.println("\tNext episode at: " + anime.getNextEpisodeAt());

            System.out.println("\tGenres: ");
            List<Genre> genres = anime.getGenres();
            for (Genre genre : genres) {
                System.out.println("\t\tGenre: " + genre.getName());
                System.out.println("\t\t\tID: " + genre.getId());
                System.out.println("\t\t\tKind: " + genre.getKind());
                System.out.println("\t\t\tRussian: " + genre.getRussian());
            }

            System.out.println("\tStudios: ");
            List<Studio> studios = anime.getStudios();
            for (Studio studio : studios) {
                System.out.println("\t\tStudio: " + studio.getName());
                System.out.println("\t\t\tID: " + studio.getId());
                System.out.println("\t\t\tFiltered name: " + studio.getFilteredName());
                System.out.println("\t\t\tImage URL: " + studio.getImageUrl());
            }

            System.out.println("\tVideos: ");
            List<Video> videos = anime.getVideos();
            for (Video video : videos) {
                System.out.println("\t\tVideo" + video.getName());
                System.out.println("\t\t\tID: " + video.getId());
                System.out.println("\t\t\tKind: " + video.getKind());
                System.out.println("\t\t\tURL: " + video.getUrl());
                System.out.println("\t\t\tHosting: " + video.getHosting());
                System.out.println("\t\t\tPlayer URL: " + video.getPlayerUrl());
                System.out.println("\t\t\tImage URL:" + video.getImageUrl());
            }

            System.out.println("\tScreenshots: ");
            List<Screenshot> screenshots = anime.getScreenshots();
            int i = 0;
            for (Screenshot screenshot : screenshots) {
                System.out.println("\t\tScreenshot: " + i++);
                System.out.println("\t\t\tOriginal: " + screenshot.getPreview());
                System.out.println("\t\t\tPreview: " + screenshot.getOriginal());
            }

            System.out.println("\tUser rate: ");
            TitleUserRate userRate = anime.getTitleUserRate();
            System.out.println("\t\tID: " + userRate.getId());
            System.out.println("\t\tStatus: " + userRate.getStatus());
            System.out.println("\t\tScore: " + userRate.getScore());
            System.out.println("\t\tEpisodes: " + userRate.getEpisodes());
            System.out.println("\t\tVolumes: " + userRate.getVolumes());
            System.out.println("\t\tChapters: " + userRate.getChapters());
            System.out.println("\t\tRewatches: " + userRate.getRewatches());
            System.out.println("\t\tText: " + userRate.getText());
            System.out.println("\t\tText HTML: " + userRate.getTextHtml());
        }

        private static void getAnimeRatesCheck() {
            System.out.println("Anime rates check: ");
            List<AnimeRate> animeRates = Shikimori.whoAmI().getAnimeRates(TitleStatus.COMPLETED, 10, 1);
            for (AnimeRate animeRate : animeRates) {
                System.out.println("\tName: " + animeRate.getAnime().getName());
                System.out.println("\t\tID: " + animeRate.getId());
                System.out.println("\t\tStatus: " + animeRate.getStatus());
                System.out.println("\t\tScore: " + animeRate.getScore());
                System.out.println("\t\tEpisodes: " + animeRate.getEpisodes());
                System.out.println("\t\tVolumes: " + animeRate.getVolumes());
                System.out.println("\t\tChapters: " + animeRate.getChapters());
                System.out.println("\t\tRewatches: " + animeRate.getRewatches());
                System.out.println("\t\tText: " + animeRate.getText());
                System.out.println("\t\tText HTML: " + animeRate.getTextHtml());
            }
        }
    }
}