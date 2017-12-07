package net.pagala.JShikiApi.Filters.SearchFilter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by firely-pasha on 7/12/17.
 */
public class SearchParameterList<E> {
    private String name;

    private List<E> yes;
    private List<E> no;

    public SearchParameterList(String name) {
        this.name = name;
        this.yes = new ArrayList<>();
        this.no = new ArrayList<>();
    }

    public List<E> getYes() {
        return yes;
    }

    public List<E> getNo() {
        return no;
    }

    public boolean isEmpty() {
        return yes.isEmpty() && no.isEmpty();
    }

    @Override
    public String toString() {
        if (yes.size() != 0 || no.size() != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(name).append("=");

            for (E element : yes) {
                sb.append(element.toString()).append(",");
            }

            for (E element : no) {
                sb.append('!').append(element.toString()).append(",");
            }

            return sb.toString();
        } else {
            return "";
        }
    }
}
