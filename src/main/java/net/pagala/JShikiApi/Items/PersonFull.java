package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;
import java.net.URL;
import java.util.Date;
import java.util.List;

public class PersonFull extends Person {

    private String japanese;

    @JsonProperty("job_title")
    private String jobTitle;

    private Date birthday;

    private URL website;

    @JsonProperty("groupped_roles")
    private String[][] grouppedRoles;

    private List<PersonRole> roles;

    private List<PersonWork> works;

    @JsonProperty("thread_id")
    private int threadId;

    @JsonProperty("topic_id")
    private int topicId;

    @JsonProperty("person_favoured")
    private boolean personFavoured;

    private boolean producer;

    @JsonProperty("producer_favoured")
    private boolean producerFavoured;

    private boolean mangaka;

    @JsonProperty("mangaka_favoured")
    private boolean mangakaFavoured;

    private boolean seyu;

    @JsonProperty("seyu_favoured")
    private boolean seyuFavored;

    @JsonProperty("updated_at")
    private Date updatedAt;

    private PersonFull() {
        super();
    }

    public String getJapanese() {
        return japanese;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public Date getBirthday() {
        return birthday;
    }

    public URL getWebsite() {
        return website;
    }

    public String[][] getGrouppedRoles() {
        return grouppedRoles;
    }

    public List<PersonRole> getRoles() {
        return roles;
    }

    public List<PersonWork> getWorks() {
        return works;
    }

    public int getThreadId() {
        return threadId;
    }

    public int getTopicId() {
        return topicId;
    }

    public boolean isPersonFavoured() {
        return personFavoured;
    }

    public boolean isProducer() {
        return producer;
    }

    public boolean isProducerFavoured() {
        return producerFavoured;
    }

    public boolean isMangaka() {
        return mangaka;
    }

    public boolean isMangakaFavoured() {
        return mangakaFavoured;
    }

    public boolean isSeyu() {
        return seyu;
    }

    public boolean isSeyuFavored() {
        return seyuFavored;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
}
