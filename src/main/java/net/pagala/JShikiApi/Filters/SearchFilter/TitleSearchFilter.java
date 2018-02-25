package net.pagala.JShikiApi.Filters.SearchFilter;

import net.pagala.JShikiApi.Items.TitleListStatus;
import net.pagala.JShikiApi.Items.TitleStatus;

public abstract class TitleSearchFilter {
    protected Integer page;
    protected Integer limit;
    protected SearchParameterList<TitleStatus> statuses;
    protected SearchParameterList<SeasonYear> seasons;
    protected Integer score;
    protected Boolean censored;
    protected SearchParameterList<Integer> ids;
    protected SearchParameterList<Integer> excludeIds;
    protected SearchParameterList<TitleListStatus> myLists;
    protected SearchParameterList<Integer> genreIds;
    protected String searchString;
    protected StringBuilder query;

    protected TitleSearchFilter() {
        page        = 1;
        limit       = 10;
        statuses    = new SearchParameterList<>("status");
        seasons     = new SearchParameterList<>("season");
        ids         = new SearchParameterList<>("ids");
        excludeIds  = new SearchParameterList<>("exclude_ids");
        myLists     = new SearchParameterList<>("mylist");
        genreIds    = new SearchParameterList<>("genre");
    }

    protected void buildRootQuery() {
    	query = new StringBuilder("?");
        if (page != null) {
            query.append("page=").append(page);
        } else {
            query.append("page=1");
        }
        if (limit != null) {
            query.append("&limit=").append(limit);
        }
        if (!statuses.isEmpty()) {
            query.append(statuses);
        }
        if (!seasons.isEmpty()) {
            query.append(seasons);
        }
        if (score != null) {
            query.append("&score=").append(score);
        }
        if (censored != null) {
            query.append("&censored=").append(censored);
        }
        if (!ids.isEmpty()) {
            query.append(ids);
        }
        if (!excludeIds.isEmpty()) {
            query.append(excludeIds);
        }
        if (!myLists.isEmpty()) {
            query.append(myLists);
        }
        if (!genreIds.isEmpty()) {
            query.append(genreIds);
        }
        if (searchString != null && !searchString.equals("")) {
            searchString = searchString.replace(' ', '_');
            query.append("&search=").append(searchString);
        }
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

    public Boolean getCensored() {
        return censored;
    }

    public void setCensored(Boolean censored) {
        this.censored = censored;
    }

    public SearchParameterList<Integer> getIds() {
        return ids;
    }

    public SearchParameterList<Integer> getExcludeIds() {
        return excludeIds;
    }

    public SearchParameterList<TitleListStatus> getMyLists() {
        return myLists;
    }

    public SearchParameterList<Integer> getGenres() {
        return genreIds;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }
}
