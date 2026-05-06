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

@Tag(name = "Comment", description = "API para la consulta de comentarios de los vídeos")
@RestController
@RequestMapping("/videominer/comments")
public class CommentController {

    @Autowired
    private CommentRepository repository;

    @Operation(
            summary = "Listar todos los comentarios",
            description = "Obtiene una lista global de todos los comentarios almacenados en el sistema",
            tags = {"comments", "get"}
    )
    @ApiResponse(
            responseCode = "200",
            description = "Lista de comentarios obtenida con éxito",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Comment.class))))
    @GetMapping
    public List<Comment> getAllComments() {
        return repository.findAll();
    }

    @Operation(
            summary = "Obtener un comentario por ID",
            description = "Devuelve el texto y la fecha de creación de un comentario específico"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Comentario encontrado",
                    content = {@Content(schema = @Schema(implementation = Comment.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Comentario no encontrado")
    })
    @GetMapping("/{id}")
    public Comment getCommentById(
            @Parameter(description = "ID del comentario") @PathVariable String id) throws ResourceNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comentario no encontrado con id: " + id));
    }

}
