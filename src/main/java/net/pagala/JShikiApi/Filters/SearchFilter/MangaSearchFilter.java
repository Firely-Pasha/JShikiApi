package net.pagala.JShikiApi.Filters.SearchFilter;

public class MangaSearchFilter extends TitleSearchFilter {
    private MangaOrder order;
    private SearchParameterList<MangaKind> kind;
    private SearchParameterList<Integer> publisherIds;

    public MangaSearchFilter() {
        super();
        kind = new SearchParameterList<>("kind");
        publisherIds   = new SearchParameterList<>("publisher");
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
        if (!genreIds.isEmpty()) {
            sb.append(genreIds).append('&');
        }
        if (!publisherIds.isEmpty()) {
            sb.append(publisherIds).append('&');
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
        if (sb.charAt(sb.length() - 1) == '&') {
            sb.deleteCharAt(sb.length() - 1);
        }
        if (sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public MangaOrder getOrder() {
        return order;
    }

    public void setOrder(MangaOrder order) {
        this.order = order;
    }

    public SearchParameterList<Integer> getPublishers() {
        return publisherIds;
    }
}
