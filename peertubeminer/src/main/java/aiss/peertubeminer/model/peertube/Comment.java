
package aiss.peertubeminer.model.peertube;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "url",
    "text",
    "threadId",
    "inReplyToCommentId",
    "videoId",
    "createdAt",
    "updatedAt",
    "deletedAt",
    "heldForReview",
    "isDeleted",
    "totalRepliesFromVideoAuthor",
    "totalReplies",
    "account"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("url")
    private String url;
    @JsonProperty("text")
    private String text;
    @JsonProperty("threadId")
    private Integer threadId;
    @JsonProperty("inReplyToCommentId")
    private Object inReplyToCommentId;
    @JsonProperty("videoId")
    private Integer videoId;
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("updatedAt")
    private String updatedAt;
    @JsonProperty("deletedAt")
    private Object deletedAt;
    @JsonProperty("heldForReview")
    private Boolean heldForReview;
    @JsonProperty("isDeleted")
    private Boolean isDeleted;
    @JsonProperty("totalRepliesFromVideoAuthor")
    private Integer totalRepliesFromVideoAuthor;
    @JsonProperty("totalReplies")
    private Integer totalReplies;
    @JsonProperty("account")
    private User user;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("threadId")
    public Integer getThreadId() {
        return threadId;
    }

    @JsonProperty("threadId")
    public void setThreadId(Integer threadId) {
        this.threadId = threadId;
    }

    @JsonProperty("inReplyToCommentId")
    public Object getInReplyToCommentId() {
        return inReplyToCommentId;
    }

    @JsonProperty("inReplyToCommentId")
    public void setInReplyToCommentId(Object inReplyToCommentId) {
        this.inReplyToCommentId = inReplyToCommentId;
    }

    @JsonProperty("videoId")
    public Integer getVideoId() {
        return videoId;
    }

    @JsonProperty("videoId")
    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
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

    @JsonProperty("deletedAt")
    public Object getDeletedAt() {
        return deletedAt;
    }

    @JsonProperty("deletedAt")
    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    @JsonProperty("heldForReview")
    public Boolean getHeldForReview() {
        return heldForReview;
    }

    @JsonProperty("heldForReview")
    public void setHeldForReview(Boolean heldForReview) {
        this.heldForReview = heldForReview;
    }

    @JsonProperty("isDeleted")
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    @JsonProperty("isDeleted")
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonProperty("totalRepliesFromVideoAuthor")
    public Integer getTotalRepliesFromVideoAuthor() {
        return totalRepliesFromVideoAuthor;
    }

    @JsonProperty("totalRepliesFromVideoAuthor")
    public void setTotalRepliesFromVideoAuthor(Integer totalRepliesFromVideoAuthor) {
        this.totalRepliesFromVideoAuthor = totalRepliesFromVideoAuthor;
    }

    @JsonProperty("totalReplies")
    public Integer getTotalReplies() {
        return totalReplies;
    }

    @JsonProperty("totalReplies")
    public void setTotalReplies(Integer totalReplies) {
        this.totalReplies = totalReplies;
    }

    @JsonProperty("account")
    public User getUser() {
        return user;
    }

    @JsonProperty("account")
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", text='" + text + '\'' +
                ", threadId=" + threadId +
                ", inReplyToCommentId=" + inReplyToCommentId +
                ", videoId=" + videoId +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", deletedAt=" + deletedAt +
                ", heldForReview=" + heldForReview +
                ", isDeleted=" + isDeleted +
                ", totalRepliesFromVideoAuthor=" + totalRepliesFromVideoAuthor +
                ", totalReplies=" + totalReplies +
                ", account=" + user +
                '}';
    }

}
