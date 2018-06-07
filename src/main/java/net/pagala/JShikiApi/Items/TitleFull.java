package net.pagala.JShikiApi.Items;

/**
 *
 * Created by firely-pasha on 7/14/17.
 */
@SuppressWarnings("unused")
public interface TitleFull extends Title {

    String[] getEnglish();

    String[] getJapanese();

    String[] getSynonyms();

    String getScore();

    String getDescription();

    String getDescriptionHtml();

    String getDescriptionSource();

    boolean isFavoured();

    boolean isAnons();

    boolean isOngoing();

    int getThreadId();

    int getTopicId();

    int getMyanimelistId();

    RatesStatus[] getRatesStatusesStats();

    RatesScore[] getRatesScoresStats();

    Genre[] getGenres();

    TitleUserRate getTitleUserRate();
}