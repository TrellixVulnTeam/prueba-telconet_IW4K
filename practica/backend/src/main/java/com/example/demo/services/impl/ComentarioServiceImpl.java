package com.example.demo.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.models.Comentario;
import com.example.demo.repository.ComentarioRepository;
import com.example.demo.services.ComentarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

@Service
public class ComentarioServiceImpl implements ComentarioService {
    @Autowired
    ComentarioRepository repositorioComentario;

    // Listar
    public List<Comentario> listarComentario() {

        return repositorioComentario.findAll();
    }

    // registrar
    public Comentario guardarComentario(Comentario request) throws ResourceAccessException {
        Comentario response = new Comentario();

        try {
            request.setEstado("activo");
            request.setFecha_registro(new Date());
            response = repositorioComentario.save(request);
        } catch (Exception e) {
            throw new ResourceAccessException(e.getMessage());
        }

        return response;
    }

    // actualización
    public Comentario actualizarComentario(Long comentarioId, Comentario request) throws ResourceAccessException {
        Comentario response = new Comentario();

        Optional<Comentario> optionalComentario = repositorioComentario.findById(comentarioId);
        Comentario comentario = optionalComentario.orElse(request);
        try {
            if (!repositorioComentario.existsById(comentarioId)) {
                throw new ResourceAccessException("Comentario no encontrado");
            }
            comentario.setId(request.getId() != null ? request.getId() : comentario.getId());
            comentario.setDescripcion(request.getDescripcion() != null ? request.getDescripcion() : comentario.getDescripcion());
            comentario.setEstado(request.getEstado() != null ? request.getEstado() : comentario.getEstado());
            comentario.setUsuario(request.getUsuario() != null ? request.getUsuario() : comentario.getUsuario());

            request.setFecha_registro(new Date());
            response = repositorioComentario.save(comentario);

        } catch (Exception e) {
            throw new ResourceAccessException(e.getMessage());
        }
        return response;
    }
}
