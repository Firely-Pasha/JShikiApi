package net.pagala.JShikiApi.Filters.SearchFilter;

public class SeasonYear {
    private Season season;
    private int year;
    private int yearFrom;
    private int yearTo;

    public SeasonYear(Season season, int year) {
        this.season = season;
        this.year = year;
        this.yearFrom = 0;
        this.yearTo = 0;
    }

    public SeasonYear(int year) {
        this.season = null;
        this.year = year;
        this.yearFrom = 0;
        this.yearTo = 0;
    }

    public SeasonYear(int yearFrom, int yearTo) {
        this.season = null;
        this.year = 0;
        this.yearFrom = yearFrom;
        this.yearTo = yearTo;
    }

    @Override
    public String toString() {
        if (season != null && year != 0) {
            return season.toString() + "_" + year;
        } else if (season == null && year != 0) {
            return Integer.toString(year);
        } else if (yearFrom != 0 && yearTo != 0) {
            return Integer.toString(yearFrom) + "_" + Integer.toString(yearTo);
        }
        return null;
    }
}
