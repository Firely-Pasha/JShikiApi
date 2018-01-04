import net.pagala.JShikiApi.Core.*;
import net.pagala.JShikiApi.Items.*;
import net.pagala.JShikiApi.Items.AnimeRate;
import net.pagala.JShikiApi.Items.UserImage;
import net.pagala.JShikiApi.RequestItems.DeviceToCreate;
import net.pagala.JShikiApi.RequestItems.DeviceToUpdate;

import javax.management.relation.RoleStatus;
import java.io.IOException;
import java.lang.Character;
import java.util.List;

//TODO: Catch URL-Level errors!!!
public class Main {

    public static void main(String[] args) {
        Shikimori.logIn("Firely-Pasha", "Goinass19981");
//        Devices.delete(3626);

        List<Role> roleList = Animes.getRoles(1);
        List<net.pagala.JShikiApi.Items.Character> mainCharacters = People.getPersons(roleList, "Director");

        for (net.pagala.JShikiApi.Items.Character mainCharacter : mainCharacters) {
            System.out.println(mainCharacter.getName());
        }
    }
//69263
    private static class ApiCheck {

        private static void getAnimeCheck() {
            AnimeFull anime = Animes.get(1);
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
            List<AnimeRate> animeRates = Users.getAnimeRates(Users.whoAmI().getId(), TitleStatus.COMPLETED, 10, 1);
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

        private static void userCheck() {
            UserFull user = Users.get(Shikimori.getUserId());
            System.out.println("User check:");
            System.out.println("\tID: " + user.getId());
            System.out.println("\tNickname: " + user.getNickname());
            System.out.println("\tAvatar: " + user.getAvatar());
            System.out.println("\tImage: ");
            UserImage userImage = user.getImage();
            System.out.println("\t\tx160: " + userImage.getX160());
            System.out.println("\t\tx148: " + userImage.getX148());
            System.out.println("\t\tx80: " + userImage.getX80());
            System.out.println("\t\tx64: " + userImage.getX64());
            System.out.println("\t\tx48: " + userImage.getX48());
            System.out.println("\t\tx32: " + userImage.getX32());
            System.out.println("\t\tx16: " + userImage.getX16());
            System.out.println("\tLast online at: " + user.getLastOnlineAt());
            System.out.println("\tName: " + user.getName());
            System.out.println("\tSex: " + user.getSex());
            System.out.println("\tFull years: " + user.getFullYears());
            System.out.println("\tBirth on: " + user.getBirthOn());
            System.out.println("\tLast online: " + user.getLastOnlineAt());
            System.out.println("\tWebsite: " + user.getWebsite());
            System.out.println("\tLocation: " + user.getLocation());
            System.out.println("\tBanned: " + user.isBanned());
            System.out.println("\tAbout: " + user.getAbout());
            System.out.println("\tAbout (HTML): " + user.getAboutHtml());
            System.out.println("\tCommon info: ");
            String[] commonInfo = user.getCommonInfo();
            for (String info : commonInfo) {
                System.out.println("\t\t" + info);
            }
            System.out.println("\tShow comments: " + user.isShowComments());
            System.out.println("\tIn friends: " + user.getInFriends());
            System.out.println("\tIs ignored: " + user.isIgnored());
            UserInfo userInfo = Users.getUserInfo(user.getId());
            System.out.println("\tUser info: ");
            System.out.println("\t\tID: " + userInfo.getId());
            System.out.println("\t\tNickname: " + userInfo.getNickname());
            System.out.println("\t\tAvatar: " + userInfo.getAvatar());
            System.out.println("\t\tLast online at: " + userInfo.getLastOnlineAt());
            System.out.println("\t\tName: " + userInfo.getName());
            System.out.println("\t\tSex: " + userInfo.getSex());
            System.out.println("\t\tWebsite: " + userInfo.getWebsite());
            System.out.println("\t\tBirth on: " + userInfo.getBirthOn());
            List<User> friends = Users.getFriends(user.getId());
            System.out.println("\tFriends: ");
            for (User friend : friends) {
                System.out.println("\t\tNickname: " + friend.getNickname());
                System.out.println("\t\t\tID: " + friend.getId());
                System.out.println("\t\t\tAvatar: " + friend.getAvatar());
                System.out.println("\t\t\tLast online at: " + friend.getLastOnlineAt());
            }
            List<Club> clubs = Users.getClubs(user.getId());
            System.out.println("\tClubs: ");
            for (Club club : clubs) {
                System.out.println("\t\tName: " + club.getName());
                System.out.println("\t\t\tID: " + club.getId());
                System.out.println("\t\t\tLogo: ");
                ClubLogo clubLogo = club.getLogo();
                System.out.println("\t\t\t\tOriginal: " + clubLogo.getOriginal());
                System.out.println("\t\t\t\tMain: " + clubLogo.getMain());
                System.out.println("\t\t\t\tx96: " + clubLogo.getX96());
                System.out.println("\t\t\t\tx73: " + clubLogo.getX73());
                System.out.println("\t\t\t\tx48: " + clubLogo.getX48());
                System.out.println("\t\t\tIs censored: " + club.isCensored());
                System.out.println("\t\t\tJoin policy: " + club.getJoinPolicy());
                System.out.println("\t\t\tComment policy: " + club.getCommentPolicy());
            }
        }
    }
}