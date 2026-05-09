package aiss.videominer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

/**
 * @author Juan C. Alonso
 */
@Entity
@Table(name = "Video")
public class Video {

    @Id
    @JsonProperty("id")
    @NotBlank(message = "Video id cannot be null")
    private String id;

    @JsonProperty("name")
    @NotBlank(message = "Video name cannot be blank")
    @Column(name = "name")
    private String name;

    @JsonProperty("description")
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @JsonProperty("releaseTime")
    @NotBlank(message = "Video release time cannot be null")
    @Column(name = "releaseTime")
    private String releaseTime;

    @JsonProperty("user")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "userId")
    private User author;

    @Valid
    @JsonProperty("comments")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "videoId")
    private List<Comment> comments;

    @Valid
    @JsonProperty("captions")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "videoId")
    private List<Caption> captions;

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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Caption> getCaptions() {
        return captions;
    }

    public void setCaptions(List<Caption> captions) {
        this.captions = captions;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                ", author=" + author +
                ", comments=" + comments +
                ", captions=" + captions +
                '}';
    }
}
