package aiss.videominer.controller;

import aiss.videominer.exception.ResourceNotFoundException;
import aiss.videominer.model.Caption;
import aiss.videominer.model.Comment;
import aiss.videominer.model.Video;
import aiss.videominer.repository.VideoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Tag(name = "Video", description = "Video management operations")
@RestController
@RequestMapping("/videominer/videos")
public class VideoController {

    @Autowired
    private VideoRepository repository;

    @Operation(
            summary = "Retrieve all videos",
            description = "Returns a list of all videos stored in database",
            tags = {"videos", "get"}
    )
    @ApiResponse(
            responseCode = "200",
            description = "List of all videos retrieved succesfully",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Video.class)))
    )
    @GetMapping
    public List<Video> getAllVideos() {
        return repository.findAll();
    }

    @Operation(summary = "Retrieve a video by ID", description = "Returns a video by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Vídeo found",
                    content = {@Content(schema = @Schema(implementation = Video.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Vídeo not found")
    })
    @GetMapping("/{id}")
    public Video getVideoById(
            @Parameter(description = "Video ID") @PathVariable String id) throws ResourceNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Video not found with id: " + id));
    }

    @Operation(summary = "Retrieve a list of comments", description = "Returns a list of comments posted in an specific video")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of comments"),
            @ApiResponse(responseCode = "404", description = "Vídeo not found")
    })
    @GetMapping("/{id}/comments")
    public List<Comment> getCommentsByVideo(
            @Parameter(description = "Video ID") @PathVariable String id) throws ResourceNotFoundException {
        Video video = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Video not found with id: " + id));
        return video.getComments();
    }

    @Operation(summary = "Retrieve a list of captions from a video", description = "Returns a list of captions posted in an specific video")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of captions"),
            @ApiResponse(responseCode = "404", description = "Vídeo not found")
    })
    @GetMapping("/{id}/captions")
    public List<Caption> getCaptionsByVideo(
            @Parameter(description = "Video ID") @PathVariable String id) throws ResourceNotFoundException {
        Video video = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Video with id " + id + " not found"));
        return video.getCaptions();
    }


}
