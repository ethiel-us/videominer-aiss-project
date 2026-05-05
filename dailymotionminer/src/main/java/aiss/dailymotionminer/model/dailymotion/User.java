
package aiss.dailymotionminer.model.dailymotion;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
        "avatar_url"
})
@Generated("jsonschema2pojo")
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
    @JsonProperty("avatar_url")
    private String avatar_url;

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

    public Long getCreated_Time() {
        return created_Time;
    }

    public void setCreated_Time(Long created_Time) {
        this.created_Time = created_Time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", screenname='" + screenname + '\'' +
                ", description='" + description + '\'' +
                ", created_Time=" + created_Time +
                ", url='" + url + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                '}';
    }
}
