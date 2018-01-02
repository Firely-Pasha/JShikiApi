package net.pagala.JShikiApi.Items;

import java.util.List;

/**
 *
 * Created by firely-pasha on 7/14/17.
 */
@SuppressWarnings("unused")
public interface TitleFull extends Title {

    List<String> getEnglish();

    List<String> getJapanese();

    List<String> getSynonyms();

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

    List<RatesStatus> getRatesStatusesStats();

    List<RatesScore> getRatesScoresStats();

    List<Genre> getGenres();

    TitleUserRate getTitleUserRate();
}