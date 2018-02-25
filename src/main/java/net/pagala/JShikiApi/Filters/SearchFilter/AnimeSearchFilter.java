package net.pagala.JShikiApi.Filters.SearchFilter;

import net.pagala.JShikiApi.Items.AnimeKind;
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
        buildRootQuery();
        if (order != null) {
            query.append("&order=").append(order);
        }
        if (!kind.isEmpty()) {
            query.append(kind);
        }
        if (!durations.isEmpty()) {
            query.append(durations);
        }
        if (!ratings.isEmpty()) {
            query.append(ratings);
        }
        if (!studioIds.isEmpty()) {
            query.append(studioIds);
        }
        return query.toString();
    }

    @Override
    public String toString() {
        return buildQuery();
    }
}