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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Caption", description = "API para la consulta de captions de los vídeos")
@RestController
@RequestMapping("/videominer/captions")
public class CaptionController {

    @Autowired
    private CaptionRepository repository;

    @Operation(
            summary = "Listar todas las captions",
            description = "Obtiene una lista global de todos los subtítulos almacenados en el sistema",
            tags = { "captions", "get" }
    )
    @ApiResponse(
            responseCode = "200",
            description = "Lista de captions obtenida con éxito",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Caption.class))))
    @GetMapping
    public List<Caption> getAllCaptions() {
        return repository.findAll();
    }

    @Operation(
            summary = "Obtener una caption por ID",
            description = "Devuelve los detalles de una caption"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Caption encontrada",
                    content = { @Content(schema = @Schema(implementation = Caption.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "Caption no encontrada")
    })
    @GetMapping("/{id}")
    public Caption getCaptionById(
            @Parameter(description = "ID de la caption") @PathVariable String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Caption no encontrada con id: " + id));
    }

}
