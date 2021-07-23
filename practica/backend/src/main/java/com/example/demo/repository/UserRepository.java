package com.example.demo.repository;

import java.util.Optional;

import com.example.demo.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    public boolean existsByEmailAndEstadoEquals(String email, String estado);
    public Optional<User> findByEmail(String email);
    public Optional<User> findByEstado(String estado);
    public Optional<User> findByNombreOrEstado(String nombre, String estado);
}
