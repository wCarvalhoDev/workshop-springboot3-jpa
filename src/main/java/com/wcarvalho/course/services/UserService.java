package com.wcarvalho.course.services;

import com.wcarvalho.course.entities.User;
import com.wcarvalho.course.respositories.UserRepository;
import com.wcarvalho.course.services.exceptions.DatabaseException;
import com.wcarvalho.course.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
       return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj){
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            if (!repository.existsById(id)) {
                System.out.println("Erro: Usuário não encontrado!");
                throw new ResourceNotFoundException(id);
            }
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User obj){
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
