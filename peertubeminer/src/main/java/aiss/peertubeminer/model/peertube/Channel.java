
package aiss.peertubeminer.model.peertube;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "url",
    "name",
    "host",
    "avatars",
    "id",
    "hostRedundancyAllowed",
    "followingCount",
    "followersCount",
    "createdAt",
    "banners",
    "displayName",
    "description",
    "support",
    "isLocal",
    "updatedAt",
    "ownerAccount"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Channel {

    @JsonProperty("url")
    private String url;
    @JsonProperty("name")
    private String name;
    @JsonProperty("host")
    private String host;
    @JsonProperty("avatars")
    private List<Object> avatars;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("hostRedundancyAllowed")
    private Boolean hostRedundancyAllowed;
    @JsonProperty("followingCount")
    private Integer followingCount;
    @JsonProperty("followersCount")
    private Integer followersCount;
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("banners")
    private List<Object> banners;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("description")
    private String description;
    @JsonProperty("support")
    private String support;
    @JsonProperty("isLocal")
    private Boolean isLocal;
    @JsonProperty("updatedAt")
    private String updatedAt;
    @JsonProperty("ownerAccount")
    private User user;

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

    @JsonProperty("host")
    public String getHost() {
        return host;
    }

    @JsonProperty("host")
    public void setHost(String host) {
        this.host = host;
    }

    @JsonProperty("avatars")
    public List<Object> getAvatars() {
        return avatars;
    }

    @JsonProperty("avatars")
    public void setAvatars(List<Object> avatars) {
        this.avatars = avatars;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("hostRedundancyAllowed")
    public Boolean getHostRedundancyAllowed() {
        return hostRedundancyAllowed;
    }

    @JsonProperty("hostRedundancyAllowed")
    public void setHostRedundancyAllowed(Boolean hostRedundancyAllowed) {
        this.hostRedundancyAllowed = hostRedundancyAllowed;
    }

    @JsonProperty("followingCount")
    public Integer getFollowingCount() {
        return followingCount;
    }

    @JsonProperty("followingCount")
    public void setFollowingCount(Integer followingCount) {
        this.followingCount = followingCount;
    }

    @JsonProperty("followersCount")
    public Integer getFollowersCount() {
        return followersCount;
    }

    @JsonProperty("followersCount")
    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }

    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("createdAt")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("banners")
    public List<Object> getBanners() {
        return banners;
    }

    @JsonProperty("banners")
    public void setBanners(List<Object> banners) {
        this.banners = banners;
    }

    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("support")
    public String getSupport() {
        return support;
    }

    @JsonProperty("support")
    public void setSupport(String support) {
        this.support = support;
    }

    @JsonProperty("isLocal")
    public Boolean getIsLocal() {
        return isLocal;
    }

    @JsonProperty("isLocal")
    public void setIsLocal(Boolean isLocal) {
        this.isLocal = isLocal;
    }

    @JsonProperty("updatedAt")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updatedAt")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("ownerAccount")
    public User getOwnerAccount() {
        return user;
    }

    @JsonProperty("ownerAccount")
    public void setOwnerAccount(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", host='" + host + '\'' +
                ", avatars=" + avatars +
                ", id=" + id +
                ", hostRedundancyAllowed=" + hostRedundancyAllowed +
                ", followingCount=" + followingCount +
                ", followersCount=" + followersCount +
                ", createdAt='" + createdAt + '\'' +
                ", banners=" + banners +
                ", displayName='" + displayName + '\'' +
                ", description='" + description + '\'' +
                ", support='" + support + '\'' +
                ", isLocal=" + isLocal +
                ", updatedAt='" + updatedAt + '\'' +
                ", ownerAccount=" + user +
                '}';
    }

}
