package com.wcarvalho.course.services;

import com.wcarvalho.course.entities.User;
import com.wcarvalho.course.respositories.UserRepository;
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
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
       Optional<User> obj = repository.findById(id);
       return obj.get();
    }

    public User insert(User obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public User update(Long id, User obj){
        User entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
