package aiss.videominer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Juan C. Alonso
 */
@Entity
@Table(name = "Channel")
public class Channel {

    @Id
    @JsonProperty("id")
    @NotNull(message = "Channel id cannot be null")
    private String id;

    @JsonProperty("name")
    @NotBlank(message = "Channel name cannot be blank")
    @Column(name = "name")
    private String name;

    @JsonProperty("description")
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @JsonProperty("createdTime")
    @NotBlank(message = "Channel creation time cannot be blank")
    @Column(name = "createdTime")
    private String createdTime;

    @JsonProperty("videos")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "channelId")
    private List<Video> videos;

    public Channel() {
        this.videos = new ArrayList<>();
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

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", videos=" + videos +
                '}';
    }
}
