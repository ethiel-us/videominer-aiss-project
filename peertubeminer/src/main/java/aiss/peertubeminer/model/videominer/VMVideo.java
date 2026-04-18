package aiss.peertubeminer.model.videominer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VMVideo {

    private String id;
    private String name;
    private String description;
    private String releaseTime;
    private String user;
    private List<VMComment> comments;
    private List<VMCaption> captions;

    public VMVideo() {
    }

    public VMVideo(String id, String name, String description, String releaseTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.releaseTime = releaseTime;
        this.comments = new ArrayList<>();
        this.captions = new ArrayList<>();
    }

    public static VMVideo of(String id, String name, String description, String releaseTime) {
        return new VMVideo(id, name, description, releaseTime);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<VMComment> getComments() {
        return comments;
    }

    public void setComments(List<VMComment> comments) {
        this.comments = comments;
    }

    public List<VMCaption> getCaptions() {
        return captions;
    }

    public void setCaptions(List<VMCaption> captions) {
        this.captions = captions;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                ", user='" + user + '\'' +
                ", comments=" + comments +
                ", captions=" + captions +
                '}';
    }
}
