package com.example.demo.services;

import java.util.List;
import com.example.demo.models.Comentario;
import org.springframework.stereotype.Service;

@Service
public interface ComentarioService {
    public List<Comentario> listarComentario();

    public Comentario guardarComentario(Comentario request);

    public Comentario actualizarComentario(Long comentarioId, Comentario request);

}