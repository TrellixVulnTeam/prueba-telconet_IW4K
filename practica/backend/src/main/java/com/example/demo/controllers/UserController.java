package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

@RestController
public class UserController {

    Logger log = LogManager.getLogger(this.getClass());

    @Autowired
    UserService servicioDeUsuario;

    @GetMapping(path = "/listarUsuario")
    public List<User> metodoUsuario() {
        return servicioDeUsuario.listarUsuario();
    }

    // Registro
    @PostMapping(path = "/postUser")
    public User postUser(@RequestBody User request) {

        log.info("Peticion recibida {}", request);
        // user es una variable, y esta anotacion ayuda
        // armar una estructura json de nuestro modelo
        return servicioDeUsuario.guardarUsuario(request);
    }

    // Actualizar
    @PutMapping(path = "/actualizartUser/{id}")
    public User actualizarUser(@PathVariable(value = "id") Long userId, @RequestBody User request) {

        log.info("Peticion de actualizar recibida {}", request);
        return servicioDeUsuario.actualizarUser(userId, request);
    }

    // Eliminar logico
    @PostMapping(path = "/deleteUser/{id}")
    public boolean deleteUser(@PathVariable(value = "id") Long userId) {

        log.info("Peticion de delete recibida {}");
        return servicioDeUsuario.deleteUser(userId);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<User> login(@RequestBody User request){
        return servicioDeUsuario.login(request);
    }
}
