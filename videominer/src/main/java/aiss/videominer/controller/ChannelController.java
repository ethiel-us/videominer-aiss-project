package aiss.videominer.controller;


import aiss.videominer.exception.ResourceNotFoundException;
import aiss.videominer.model.Caption;
import aiss.videominer.model.Channel;
import aiss.videominer.model.Video;
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
import java.util.UUID;

@Tag(name = "Channel", description = "API de gestión de canales de vídeo")
@RestController
@RequestMapping("/videominer/channels")
public class ChannelController {

    @Autowired
    private ChannelRepository repository;

    @Operation(
            summary = "Listar todos los canales",
            description = "Obtiene una lista completa de todos los canales de PeerTube/Dailymotion almacenados",
            tags = {"channels", "get"}
    )
    @ApiResponse(
            responseCode = "200",
            description = "Lista de canales obtenida con éxito",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Channel.class))))
    @GetMapping
    public List<Channel> getAllChannels() {
        return repository.findAll();
    }

    @Operation(summary = "Obtener un canal por su ID", description = "Devuelve el canal completo incluyendo sus vídeos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Canal encontrado",
                    content = {@Content(schema = @Schema(implementation = Channel.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Canal no encontrado", content = @Content(schema = @Schema()))
    })
    @GetMapping("/{id}")
    public Channel getChannelById(
            @Parameter(description = "ID único del canal")
            @PathVariable String id
    ) throws ResourceNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Channel not found with id: " + id));
    }

    @Operation(summary = "Crear un nuevo canal", description = "Crea un nuevo canal")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Canal creado correctamente",
                    content = @Content(schema = @Schema(implementation = Channel.class))),
            @ApiResponse(responseCode = "400", description = "Petición incorrecta")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Channel create(@Valid @RequestBody Channel channel) {

        return repository.save(channel);
    }


}
