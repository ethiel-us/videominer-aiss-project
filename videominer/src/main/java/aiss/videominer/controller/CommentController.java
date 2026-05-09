package aiss.videominer.controller;

import aiss.videominer.exception.ResourceNotFoundException;
import aiss.videominer.model.Comment;
import aiss.videominer.repository.CommentRepository;
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

@Tag(name = "Comment", description = "Comment management operations")
@RestController
@RequestMapping("/videominer/comments")
public class CommentController {

    @Autowired
    private CommentRepository repository;

    @Operation(
            summary = "List all comments",
            description = "Returns a list of all comments stored in database",
            tags = {"comments", "get"}
    )
    @ApiResponse(
            responseCode = "200",
            description = "List of comments retrieved succesfully",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Comment.class)))
    )
    @GetMapping
    public List<Comment> getAllComments() {
        return repository.findAll();
    }

    @Operation(
            summary = "Retrieve a comment by ID",
            description = "Returns a comment searched by its ID"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Comment found",
                    content = {@Content(schema = @Schema(implementation = Comment.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Comment not found")
    })
    @GetMapping("/{id}")
    public Comment getCommentById(
            @Parameter(description = "Comment ID") @PathVariable String id) throws ResourceNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found with id: " + id));
    }

}
