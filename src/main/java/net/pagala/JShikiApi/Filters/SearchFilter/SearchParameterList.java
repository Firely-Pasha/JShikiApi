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
            sb.append("&").append(name).append("=");
            sb.append(getElements(yes, true));
            sb.append(getElements(no, false));
            return sb.toString();
        } else {
            return "";
        }
    }

    private String getElements(List<E> list, boolean include) {
	    StringBuilder sb = new StringBuilder();
	    if (list.size() != 0) {
		    sb.append(include ? "" : "!").append(list.get(0));
		    for (int i = 1; i < list.size(); i++) {
				    sb.append(include ? "," : ",!").append(list.get(i).toString());
		    }
	    }
	    return sb.toString();
    }
}
