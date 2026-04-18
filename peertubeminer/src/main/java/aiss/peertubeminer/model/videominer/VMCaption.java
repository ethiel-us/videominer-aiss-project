package aiss.peertubeminer.model.videominer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VMCaption {

    private String id;
    private String link;
    private String language;

    public VMCaption() {
    }

    public VMCaption(String id, String link, String language) {
        this.id = id;
        this.link = link;
        this.language = language;
    }

    public static VMCaption of(String id, String link, String language) {
        return new VMCaption(id, link, language);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Caption{" +
                "id='" + id + '\'' +
                ", link='" + link + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
