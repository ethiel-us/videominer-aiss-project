
package aiss.peertubeminer.model.peertube;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "language",
        "automaticallyGenerated",
        "captionPath",
        "fileUrl",
        "m3u8Url",
        "updatedAt"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Caption {

    @JsonProperty("language")
    private Language language;
    @JsonProperty("automaticallyGenerated")
    private Boolean automaticallyGenerated;
    @JsonProperty("captionPath")
    private String captionPath;
    @JsonProperty("fileUrl")
    private String fileUrl;
    @JsonProperty("m3u8Url")
    private String m3u8Url;
    @JsonProperty("updatedAt")
    private String updatedAt;

    @JsonProperty("language")
    public Language getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(Language language) {
        this.language = language;
    }

    @JsonProperty("automaticallyGenerated")
    public Boolean getAutomaticallyGenerated() {
        return automaticallyGenerated;
    }

    @JsonProperty("automaticallyGenerated")
    public void setAutomaticallyGenerated(Boolean automaticallyGenerated) {
        this.automaticallyGenerated = automaticallyGenerated;
    }

    @JsonProperty("captionPath")
    public String getCaptionPath() {
        return captionPath;
    }

    @JsonProperty("captionPath")
    public void setCaptionPath(String captionPath) {
        this.captionPath = captionPath;
    }

    @JsonProperty("fileUrl")
    public String getFileUrl() {
        return fileUrl;
    }

    @JsonProperty("fileUrl")
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @JsonProperty("m3u8Url")
    public String getM3u8Url() {
        return m3u8Url;
    }

    @JsonProperty("m3u8Url")
    public void setM3u8Url(String m3u8Url) {
        this.m3u8Url = m3u8Url;
    }

    @JsonProperty("updatedAt")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updatedAt")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Caption{" +
                "language=" + language +
                ", automaticallyGenerated=" + automaticallyGenerated +
                ", captionPath='" + captionPath + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", m3u8Url='" + m3u8Url + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }

}
