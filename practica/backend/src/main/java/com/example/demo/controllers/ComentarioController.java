package com.example.demo.controllers;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.demo.models.Comentario;
import com.example.demo.services.ComentarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComentarioController {
    Logger log = LogManager.getLogger(this.getClass());

    @Autowired
    ComentarioService servicioDeComentario;

    @GetMapping(path = "/listarComentario")
    public List<Comentario> metodoComentario() {
        return servicioDeComentario.listarComentario();
    }

    // Registro
    @PostMapping(path = "/registroComentario")
    public Comentario postComentario(@RequestBody Comentario request) {

        log.info("Peticion recibida {}", request);
        return servicioDeComentario.guardarComentario(request);
    }

    // Actualizar
    @PutMapping(path = "/actualizarComentario/{id}")
    public Comentario actualizarComentario(@PathVariable(value = "id") Long comentarioId, @RequestBody Comentario request) {

        log.info("Peticion recibida {}", request);
        return servicioDeComentario.actualizarComentario(comentarioId, request);
    }
    
}
