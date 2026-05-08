package aiss.videominer.controller;


import aiss.videominer.exception.ResourceNotFoundException;
import aiss.videominer.model.Channel;
import aiss.videominer.repository.ChannelRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Channel", description = "Channel management operations")
@RestController
@RequestMapping("/videominer/channels")
public class ChannelController {

    @Autowired
    private ChannelRepository repository;

    @Operation(
            summary = "Retrieve all channels",
            description = "Returns a complete list of all stored PeerTube/Dailymotion channels",
            tags = {"channels", "get"}
    )
    @ApiResponse(
            responseCode = "200",
            description = "List of channels retrieved successfully",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Channel.class)))
    )
    @GetMapping
    public List<Channel> getAllChannels() {
        return repository.findAll();
    }

    @Operation(
            summary = "Retrieve a channel by ID",
            description = "Returns a channel including all its videos"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200", description = "Channel found",
                    content = {@Content(schema = @Schema(implementation = Channel.class), mediaType = "application/json")}
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Channel not found",
                    content = @Content(schema = @Schema())
            )
    })
    @GetMapping("/{id}")
    public Channel getChannelById(
            @Parameter(description = "Channel ID")
            @PathVariable String id
    ) throws ResourceNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Channel not found with id: " + id));
    }

    @Operation(
            summary = "Create a new channel", description = "Creates and store a new channel"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201", description = "Channel created successfully",
                    content = @Content(schema = @Schema(implementation = Channel.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad request"
            )
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Channel create(@Valid @RequestBody Channel channel) {
        return repository.save(channel);
    }

    @Operation(
            summary = "Update a channel", description = "Updates an existing channel by its ID"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Channel updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid channel data"),
            @ApiResponse(responseCode = "404", description = "Channel not found")
    })
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Channel update(
            @Parameter(description = "ID of the channel to update") @PathVariable String id,
            @Valid @RequestBody Channel updatedChannel
    ) throws ResourceNotFoundException {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Channel not found with id: " + id);
        }
        updatedChannel.setId(id);
        return repository.save(updatedChannel);
    }

    @Operation(
            summary = "Delete a channel", description = "Deletes a channel and all its videos by its ID"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Channel deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Channel not found")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @Parameter(description = "ID of the channel to delete") @PathVariable String id
    ) throws ResourceNotFoundException {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Channel not found with id: " + id);
        }
    }

}
