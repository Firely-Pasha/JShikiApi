package net.pagala.JShikiApi.Items;

import net.pagala.JShikiApi.Items.*;

import java.util.*;

/**
 *
 * Created by firely-pasha on 7/15/17.
 */
@SuppressWarnings("unused")
public interface Title {
     int getId();

     String getName();

     String getRussian();

     Image getImage();

     String getUrl();

     String getKind();

     String getStatus();

     Date getAiredOn();

     Date getReleasedOn();
}
