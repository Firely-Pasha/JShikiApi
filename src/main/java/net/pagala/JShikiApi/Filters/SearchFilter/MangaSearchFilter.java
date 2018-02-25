package net.pagala.JShikiApi.Filters.SearchFilter;

import net.pagala.JShikiApi.Items.MangaKind;

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
        buildRootQuery();
        if (order != null) {
            query.append("&order=").append(order);
        }
        if (!kind.isEmpty()) {
            query.append(kind);
        }
        if (!publisherIds.isEmpty()) {
            query.append(publisherIds);
        }
        return query.toString();
    }

    public MangaOrder getOrder() {
        return order;
    }

    public void setOrder(MangaOrder order) {
        this.order = order;
    }

    public SearchParameterList<MangaKind> getKind() {
        return kind;
    }

    public SearchParameterList<Integer> getPublishers() {
        return publisherIds;
    }

    @Override
    public String toString() {
        return buildQuery();
    }
}
