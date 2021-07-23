package com.example.demo.services;

import com.example.demo.models.User;
// import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UserService {

    public List<User> listarUsuario();

    public User guardarUsuario(User request);

    public User actualizarUser(Long Userid, User request);

    public boolean deleteUser(Long userId);

    public ResponseEntity<User> login(User request);
}
