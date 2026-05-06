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


@Tag(name = "Video", description = "API para la consulta de vídeos, sus comentarios y subtítulos")
@RestController
@RequestMapping("/videominer/videos")
public class VideoController {

    @Autowired
    private VideoRepository repository;

    @Operation(
            summary = "Listar todos los vídeos",
            description = "Devuelve una lista con todos los vídeos almacenados de todas las plataformas",
            tags = {"videos", "get"}
    )
    @ApiResponse(
            responseCode = "200",
            description = "Lista de vídeos obtenida con éxito",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Video.class))))
    @GetMapping
    public List<Video> getAllVideos() {
        return repository.findAll();
    }

    @Operation(summary = "Obtener un vídeo por ID", description = "Devuelve un vídeo según por su identificador")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Vídeo encontrado",
                    content = {@Content(schema = @Schema(implementation = Video.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Vídeo no encontrado")
    })
    @GetMapping("/{id}")
    public Video getVideoById(
            @Parameter(description = "ID del vídeo a buscar") @PathVariable String id) throws ResourceNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Video no encontrado con id: " + id));
    }

    @Operation(summary = "Obtener comentarios de un vídeo", description = "Devuelve la lista de comentarios asociados a un vídeo concreto")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de comentarios"),
            @ApiResponse(responseCode = "404", description = "Vídeo no encontrado")
    })
    @GetMapping("/{id}/comments")
    public List<Comment> getCommentsByVideo(
            @Parameter(description = "ID del vídeo") @PathVariable String id) throws ResourceNotFoundException {
        Video video = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Video no encontrado con id: " + id));
        return video.getComments();
    }

    @Operation(summary = "Obtener captions de un vídeo", description = "Devuelve las captions de un vídeo")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de captions"),
            @ApiResponse(responseCode = "404", description = "Vídeo no encontrado")
    })
    @GetMapping("/{id}/captions")
    public List<Caption> getCaptionsByVideo(
            @Parameter(description = "ID del vídeo") @PathVariable String id) throws ResourceNotFoundException {
        Video video = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Video no encontrado con id: " + id));
        return video.getCaptions();
    }


}
