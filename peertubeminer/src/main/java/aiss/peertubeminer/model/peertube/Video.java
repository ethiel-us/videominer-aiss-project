
package aiss.peertubeminer.model.peertube;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "uuid",
    "shortUUID",
    "url",
    "name",
    "language",
    "nsfw",
    "nsfwFlags",
    "nsfwSummary",
    "truncatedDescription",
    "description",
    "isLocal",
    "duration",
    "aspectRatio",
    "views",
    "viewers",
    "likes",
    "dislikes",
    "thumbnailPath",
    "previewPath",
    "embedPath",
    "createdAt",
    "updatedAt",
    "publishedAt",
    "originallyPublishedAt",
    "isLive",
    "account",
    "channel",
    "comments"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Video {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("uuid")
    private String uuid;
    @JsonProperty("shortUUID")
    private String shortUUID;
    @JsonProperty("url")
    private String url;
    @JsonProperty("name")
    private String name;
    @JsonProperty("language")
    private Language language;
    @JsonProperty("nsfw")
    private Boolean nsfw;
    @JsonProperty("nsfwFlags")
    private Integer nsfwFlags;
    @JsonProperty("nsfwSummary")
    private Object nsfwSummary;
    @JsonProperty("truncatedDescription")
    private String truncatedDescription;
    @JsonProperty("description")
    private String description;
    @JsonProperty("isLocal")
    private Boolean isLocal;
    @JsonProperty("duration")
    private Integer duration;
    @JsonProperty("aspectRatio")
    private Double aspectRatio;
    @JsonProperty("views")
    private Integer views;
    @JsonProperty("viewers")
    private Integer viewers;
    @JsonProperty("likes")
    private Integer likes;
    @JsonProperty("dislikes")
    private Integer dislikes;
    @JsonProperty("thumbnailPath")
    private String thumbnailPath;
    @JsonProperty("previewPath")
    private String previewPath;
    @JsonProperty("embedPath")
    private String embedPath;
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("updatedAt")
    private String updatedAt;
    @JsonProperty("publishedAt")
    private String publishedAt;
    @JsonProperty("originallyPublishedAt")
    private Object originallyPublishedAt;
    @JsonProperty("isLive")
    private Boolean isLive;
    @JsonProperty("account")
    private User user;
    @JsonProperty("channel")
    private Channel channel;
    @JsonProperty("comments")
    private Integer comments;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("uuid")
    public String getUuid() {
        return uuid;
    }

    @JsonProperty("uuid")
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @JsonProperty("shortUUID")
    public String getShortUUID() {
        return shortUUID;
    }

    @JsonProperty("shortUUID")
    public void setShortUUID(String shortUUID) {
        this.shortUUID = shortUUID;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("language")
    public Language getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(Language language) {
        this.language = language;
    }

    @JsonProperty("nsfw")
    public Boolean getNsfw() {
        return nsfw;
    }

    @JsonProperty("nsfw")
    public void setNsfw(Boolean nsfw) {
        this.nsfw = nsfw;
    }

    @JsonProperty("nsfwFlags")
    public Integer getNsfwFlags() {
        return nsfwFlags;
    }

    @JsonProperty("nsfwFlags")
    public void setNsfwFlags(Integer nsfwFlags) {
        this.nsfwFlags = nsfwFlags;
    }

    @JsonProperty("nsfwSummary")
    public Object getNsfwSummary() {
        return nsfwSummary;
    }

    @JsonProperty("nsfwSummary")
    public void setNsfwSummary(Object nsfwSummary) {
        this.nsfwSummary = nsfwSummary;
    }

    @JsonProperty("truncatedDescription")
    public String getTruncatedDescription() {
        return truncatedDescription;
    }

    @JsonProperty("truncatedDescription")
    public void setTruncatedDescription(String truncatedDescription) {
        this.truncatedDescription = truncatedDescription;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("isLocal")
    public Boolean getIsLocal() {
        return isLocal;
    }

    @JsonProperty("isLocal")
    public void setIsLocal(Boolean isLocal) {
        this.isLocal = isLocal;
    }

    @JsonProperty("duration")
    public Integer getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @JsonProperty("aspectRatio")
    public Double getAspectRatio() {
        return aspectRatio;
    }

    @JsonProperty("aspectRatio")
    public void setAspectRatio(Double aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    @JsonProperty("views")
    public Integer getViews() {
        return views;
    }

    @JsonProperty("views")
    public void setViews(Integer views) {
        this.views = views;
    }

    @JsonProperty("viewers")
    public Integer getViewers() {
        return viewers;
    }

    @JsonProperty("viewers")
    public void setViewers(Integer viewers) {
        this.viewers = viewers;
    }

    @JsonProperty("likes")
    public Integer getLikes() {
        return likes;
    }

    @JsonProperty("likes")
    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @JsonProperty("dislikes")
    public Integer getDislikes() {
        return dislikes;
    }

    @JsonProperty("dislikes")
    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }

    @JsonProperty("thumbnailPath")
    public String getThumbnailPath() {
        return thumbnailPath;
    }

    @JsonProperty("thumbnailPath")
    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }

    @JsonProperty("previewPath")
    public String getPreviewPath() {
        return previewPath;
    }

    @JsonProperty("previewPath")
    public void setPreviewPath(String previewPath) {
        this.previewPath = previewPath;
    }

    @JsonProperty("embedPath")
    public String getEmbedPath() {
        return embedPath;
    }

    @JsonProperty("embedPath")
    public void setEmbedPath(String embedPath) {
        this.embedPath = embedPath;
    }

    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("createdAt")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("updatedAt")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updatedAt")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("publishedAt")
    public String getPublishedAt() {
        return publishedAt;
    }

    @JsonProperty("publishedAt")
    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    @JsonProperty("originallyPublishedAt")
    public Object getOriginallyPublishedAt() {
        return originallyPublishedAt;
    }

    @JsonProperty("originallyPublishedAt")
    public void setOriginallyPublishedAt(Object originallyPublishedAt) {
        this.originallyPublishedAt = originallyPublishedAt;
    }

    @JsonProperty("isLive")
    public Boolean getIsLive() {
        return isLive;
    }

    @JsonProperty("isLive")
    public void setIsLive(Boolean isLive) {
        this.isLive = isLive;
    }

    @JsonProperty("account")
    public User getUser() {
        return user;
    }

    @JsonProperty("account")
    public void setUser(User user) {
        this.user = user;
    }

    @JsonProperty("channel")
    public Channel getChannel() {
        return channel;
    }

    @JsonProperty("channel")
    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    @JsonProperty("comments")
    public Integer getComments() {
        return comments;
    }

    @JsonProperty("comments")
    public void setComments(Integer comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", shortUUID='" + shortUUID + '\'' +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", language=" + language +
                ", nsfw=" + nsfw +
                ", nsfwFlags=" + nsfwFlags +
                ", nsfwSummary=" + nsfwSummary +
                ", truncatedDescription='" + truncatedDescription + '\'' +
                ", description='" + description + '\'' +
                ", isLocal=" + isLocal +
                ", duration=" + duration +
                ", aspectRatio=" + aspectRatio +
                ", views=" + views +
                ", viewers=" + viewers +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                ", thumbnailPath='" + thumbnailPath + '\'' +
                ", previewPath='" + previewPath + '\'' +
                ", embedPath='" + embedPath + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", originallyPublishedAt=" + originallyPublishedAt +
                ", isLive=" + isLive +
                ", account=" + user +
                ", channel=" + channel +
                ", comments=" + comments +
                '}';
    }

}
