
package aiss.dailymotionminer.model.dailymotion;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "screenname",
        "description",
        "created_time",
        "url",
        "avatar_720_url"
})
@Generated("jsonschema2pojo")

/**
 * This model is used to map:
 * User model from VideoMiner
 * Channel model from VideoMiner
 *
 */
public class User {

    @JsonProperty("id")
    private String id;
    @JsonProperty("screenname")
    private String screenname;
    @JsonProperty("description")
    private String description;
    @JsonProperty("created_time")
    private Long created_Time;
    @JsonProperty("url")
    private String url;
    @JsonProperty("avatar_720_url")
    private String avatar_720_url;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("screenname")
    public String getScreenname() {
        return screenname;
    }

    @JsonProperty("screenname")
    public void setScreenname(String screenname) {
        this.screenname = screenname;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("created_time")
    public Long getCreated_Time() {
        return created_Time;
    }

    @JsonProperty("created_time")
    public void setCreated_Time(Long created_Time) {
        this.created_Time = created_Time;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("avatar_720_url")
    public String getAvatar_720_url() {
        return avatar_720_url;
    }

    @JsonProperty("avatar_720_url")
    public void setAvatar_720_url(String avatar_720_url) {
        this.avatar_720_url = avatar_720_url;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", screenname='" + screenname + '\'' +
                ", description='" + description + '\'' +
                ", created_Time=" + created_Time +
                ", url='" + url + '\'' +
                ", avatar_720_url='" + avatar_720_url + '\'' +
                '}';
    }
}
