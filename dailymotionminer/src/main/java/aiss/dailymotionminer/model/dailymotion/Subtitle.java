
package aiss.dailymotionminer.model.dailymotion;

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
    "format",
    "language",
    "url"
})
@Generated("jsonschema2pojo")
public class Subtitle {

    @JsonProperty("id")
    private String id;
    @JsonProperty("format")
    private String format;
    @JsonProperty("language")
    private String language;
    @JsonProperty("url")
    private String url;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @JsonProperty("format")
    public String getFormat() {
        return format;
    }

    @JsonProperty("format")
    public void setFormat(String format) {
        this.format = format;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Subtitle{" +
                "id='" + id + '\'' +
                ", format='" + format + '\'' +
                ", language='" + language + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
