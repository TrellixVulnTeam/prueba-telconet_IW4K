package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.User;
import com.example.demo.services.UserService;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repositorioUsuario;

    @Autowired
    // RolRepository repositorioRol;

    // La lógica: consultas,
    public List<User> listarUsuario() {

        return repositorioUsuario.findAll();
    }

    public User guardarUsuario(User request) throws ResourceAccessException {

        User response = new User();
        try {
            // si el correo está vacío
            if (request.getEmail() == null) {
                throw new ResourceAccessException("Email vacio");
            }
            // si el correo existe en un usuario activo
            if (repositorioUsuario.existsByEmailAndEstadoEquals(request.getEmail(), "activo")) {
                throw new ResourceAccessException("Correo ya esta registrado y activo");
            }
            request.setEstado("activo");
            response = repositorioUsuario.save(request);
        } catch (Exception e) {
            throw new ResourceAccessException(e.getMessage());
        }
        return response;
    }

    public User actualizarUser(Long userId, User request) throws ResourceAccessException {

        User response = new User();
        try {
            if (!repositorioUsuario.existsById(userId)) {
                throw new ResourceAccessException("Usuario no encontrado");
            }
            // String nombre = response.getNombre();
            // System.out.println("ESTE ES EL VALOR DEL NOMBRE " + nombre);
            Optional<User> optionalUser = repositorioUsuario.findById(userId);
            User usuario = optionalUser.orElse(request);
            usuario.setNombre(request.getNombre() != null ? request.getNombre() : usuario.getNombre());
            usuario.setEmail(request.getEmail() != null ? request.getEmail() : usuario.getEmail());
            usuario.setEstado(request.getEstado() != null ? request.getEstado() : usuario.getEstado());
            usuario.setClave(request.getClave() != null ? request.getClave() : usuario.getClave());
            // usuario.setRol(request.getRol() != null ? request.getRol() : usuario.getRol());
            usuario.setId(request.getId() != null ? request.getId() : usuario.getId());
            response = repositorioUsuario.save(usuario);
        } catch (Exception e) {
            throw new ResourceAccessException(e.getMessage());
        }
        return response;
    }

    // eliminar usuario
    public boolean deleteUser(Long userId) throws ResourceAccessException {
        boolean response = false;
        try {
            if (!repositorioUsuario.existsById(userId)) {
                throw new ResourceAccessException("Usuario no encontrado");
            }
            User request = repositorioUsuario.findById(userId).get();
            request.setEstado("eliminado");
            repositorioUsuario.save(request);
            response = true;
        } catch (Exception e) {
            throw new ResourceAccessException(e.getMessage());
        }
        return response;
    }

    // valdar el login
    public ResponseEntity<User> login(User request) {
        Optional<User> optionalUser = repositorioUsuario.findByEmail(request.getEmail());
        User usuario = null;
        if (optionalUser.isPresent()) {
            usuario = optionalUser.get();
            if (request.getClave().equals(usuario.getClave())) {
                return new ResponseEntity<User>(usuario, HttpStatus.OK);
            }
        }
        usuario = null;
        return new ResponseEntity<User>(usuario, HttpStatus.OK);
    }
}
