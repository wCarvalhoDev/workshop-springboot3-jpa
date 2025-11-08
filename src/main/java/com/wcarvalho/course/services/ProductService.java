package com.wcarvalho.course.services;

import com.wcarvalho.course.entities.Product;
import com.wcarvalho.course.respositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Service → faz a lógica de negócio
//O Service é quem decide o que deve ser feito (validações, regras, cálculos, etc.)
//Mas ele não acessa o banco diretamente — ele chama o Repository.

//Camada:	Função:	                                        Usa quem:
//Service	Contém regras de negócio e coordena o fluxo	    Chama o Repository
@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id){
       Optional<Product> obj = repository.findById(id);
       return obj.get();
    }
}
