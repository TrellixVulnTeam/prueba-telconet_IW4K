package com.example.demo.repository;

import java.util.Optional;

import com.example.demo.models.Comentario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    public boolean existsByIdAndEstado(String string, String estado);

    public Optional<Comentario> findByEstado(String estado);
    public boolean existsByEstado(String estado);

}
