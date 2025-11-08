package com.wcarvalho.course.resources;

import com.wcarvalho.course.entities.User;
import com.wcarvalho.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Controller → recebe a requisição HTTP
//É a porta de entrada do sistema (quem recebe as chamadas da web, do Postman, do front-end etc.).

//Camada:	    Função:	                                        Usa quem:
//Controller	Recebe requisições HTTP e devolve respostas	    Chama o Service
@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
