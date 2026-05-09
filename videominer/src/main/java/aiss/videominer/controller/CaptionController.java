package aiss.videominer.controller;

import aiss.videominer.exception.ResourceNotFoundException;
import aiss.videominer.model.Caption;
import aiss.videominer.repository.CaptionRepository;
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

@Tag(name = "Caption", description = "Caption management operations")
@RestController
@RequestMapping("/videominer/captions")
public class CaptionController {

    @Autowired
    private CaptionRepository repository;

    @Operation(
            summary = "Retrieve all captions",
            description = "Returns a list of all captions stored in database",
            tags = {"captions", "get"}
    )
    @ApiResponse(
            responseCode = "200",
            description = "List of captions retrieved succesfully",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Caption.class)))
    )
    @GetMapping
    public List<Caption> getAllCaptions() {
        return repository.findAll();
    }

    @Operation(
            summary = "Retrieve a caption by ID",
            description = "Returns a specific caption by ID"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200", description = "Caption found",
                    content = {@Content(schema = @Schema(implementation = Caption.class), mediaType = "application/json")}
            ),
            @ApiResponse(responseCode = "404", description = "Caption not found")
    })
    @GetMapping("/{id}")
    public Caption getCaptionById(
            @Parameter(description = "Caption ID") @PathVariable String id) throws ResourceNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Caption not found with id: " + id));
    }

}
