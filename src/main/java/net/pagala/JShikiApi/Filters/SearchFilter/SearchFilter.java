package net.pagala.JShikiApi.Filters.SearchFilter;

/**
 *
 * Created by firely-pasha on 7/12/17.
 */
@SuppressWarnings("unused")
public class SearchFilter {

    // TODO: Make it more simple!!!
    private Integer page;
    private Integer limit;
    private AnimeOrder order;
    private SearchParameterList<AnimeType> types;
    private SearchParameterList<TitleStatus> statuses;
    private SearchParameterList<SeasonYear> seasons;
    private Integer score;
    private SearchParameterList<Duration> durations;
    private SearchParameterList<TitleRating> ratings;
    private SearchParameterList<Integer> genreIds;
    private SearchParameterList<Integer> studioIds;
    private Boolean censored;
    private SearchParameterList<MyListTitleStatus> myLists;
    private SearchParameterList<Integer> ids;
    private SearchParameterList<Integer> excludeIds;
    private String searchString;

    public SearchFilter() {
        types       = new SearchParameterList<>("type");
        statuses    = new SearchParameterList<>("status");
        seasons     = new SearchParameterList<>("season");
        durations   = new SearchParameterList<>("duration");
        ratings     = new SearchParameterList<>("rating");
        genreIds    = new SearchParameterList<>("genre");
        studioIds   = new SearchParameterList<>("studio");
        myLists     = new SearchParameterList<>("mylist");
        ids         = new SearchParameterList<>("ids");
        excludeIds  = new SearchParameterList<>("exclude_ids");
        limit       = 10;
        page        = 1;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(int page) {
        if (page < 1) {
            page = 1;
        }
        if (page > 10000) {
            page = 10000;
        }
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit < 1) {
            limit = 1;
        }
        if (limit > 10000) {
            limit = 10000;
        }
        this.limit = limit;
    }

    public AnimeOrder getOrder() {
        return order;
    }

    public void setOrder(AnimeOrder order) {
        this.order = order;
    }

    public SearchParameterList<AnimeType> getTypes() {
        return types;
    }

    public SearchParameterList<TitleStatus> getStatuses() {
        return statuses;
    }

    public SearchParameterList<SeasonYear> getSeasons() {
        return seasons;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

    public SearchParameterList<Duration> getDurations() {
        return durations;
    }

    public SearchParameterList<TitleRating> getRatings() {
        return ratings;
    }

    public SearchParameterList<Integer> getGenres() {
        return genreIds;
    }

    public SearchParameterList<Integer> getStudios() {
        return studioIds;
    }

    public Boolean getCensored() {
        return censored;
    }

    public void setCensored(Boolean censored) {
        this.censored = censored;
    }

    public SearchParameterList<MyListTitleStatus> getMyLists() {
        return myLists;
    }


    public SearchParameterList<Integer> getIds() {
        return ids;
    }

    public SearchParameterList<Integer> getExcludeIds() {
        return excludeIds;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public String buildQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("?");
        sb.append(page == null ? "" : "page=" + page + '&');
        sb.append(limit == null ? "" : "limit=" + limit + '&');
        sb.append(order == null ? "" : "order=" + order + '&');
        if (!types.isEmpty()) {
            sb.append(types).append('&');
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