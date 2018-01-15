package net.pagala.JShikiApi.Filters.SearchFilter;

import net.pagala.JShikiApi.Items.TitleRating;

/**
 *
 * Created by firely-pasha on 7/12/17.
 */
@SuppressWarnings("unused")
public class AnimeSearchFilter extends TitleSearchFilter {

    // TODO: Make it more simple!!!
    private AnimeOrder order;
    private SearchParameterList<AnimeKind> kind;
    private SearchParameterList<Duration> durations;
    private SearchParameterList<TitleRating> ratings;
    private SearchParameterList<Integer> studioIds;

    public AnimeSearchFilter() {
        super();
        kind        = new SearchParameterList<>("kind");
        durations   = new SearchParameterList<>("duration");
        ratings     = new SearchParameterList<>("rating");
        studioIds   = new SearchParameterList<>("studio");
    }

    public AnimeOrder getOrder() {
        return order;
    }

    public void setOrder(AnimeOrder order) {
        this.order = order;
    }

    public SearchParameterList<AnimeKind> getTypes() {
        return kind;
    }

    public SearchParameterList<Duration> getDurations() {
        return durations;
    }

    public SearchParameterList<TitleRating> getRatings() {
        return ratings;
    }

    public SearchParameterList<Integer> getStudios() {
        return studioIds;
    }

    public String buildQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("?");
        sb.append(page == null ? "" : "page=" + page + '&');
        sb.append(limit == null ? "" : "limit=" + limit + '&');
        sb.append(order == null ? "" : "order=" + order + '&');
        if (!kind.isEmpty()) {
            sb.append(kind).append('&');
        }
        if (!statuses.isEmpty()) {
            sb.append(statuses).append('&');
        }
        if (!seasons.isEmpty()) {
            sb.append(seasons).append('&');
        }
        sb.append(score == null ? "" : "score=" + score + '&');
        if (!durations.isEmpty()) {
            sb.append(durations).append('&');
        }
        if (!ratings.isEmpty()) {
            sb.append(ratings).append('&');
        }
        if (!genreIds.isEmpty()) {
            sb.append(genreIds).append('&');
        }
        if (!studioIds.isEmpty()) {
            sb.append(studioIds).append('&');
        }
        sb.append(censored == null ? "" : "censored=" + censored + '&');
        if (!myLists.isEmpty()) {
            sb.append(myLists).append('&');
        }
        if (!ids.isEmpty()) {
            sb.append(ids).append('&');
        }
        if (!excludeIds.isEmpty()) {
            sb.append(excludeIds).append('&');
        }

        if (searchString != null) {
            searchString = searchString.replace(' ', '_');
        }
        sb.append(searchString == null ? "" : "search=" + searchString + '&');
        return sb.toString();
    }

    @Override
    public String toString() {
        return buildQuery();
    }
}