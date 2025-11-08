package com.wcarvalho.course.resources;

import com.wcarvalho.course.entities.Product;
import com.wcarvalho.course.services.ProductService;
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
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
