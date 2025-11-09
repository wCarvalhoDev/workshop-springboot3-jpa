package com.wcarvalho.course.resources;

import com.wcarvalho.course.entities.User;
import com.wcarvalho.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    // @PostMapping → indica que o metodo responde a requisições HTTP POST.
    // @RequestBody → diz que o User vem no corpo da requisição.
    //  ervice.insert(obj) → salva o usuário no banco.
    //  ServletUriComponentsBuilder... → gera a URI do novo usuário criado.
    //  ResponseEntity.created(uri).body(obj) → retorna resposta HTTP 201 com o objeto e a URI.
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
