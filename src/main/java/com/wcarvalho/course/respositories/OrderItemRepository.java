package com.wcarvalho.course.respositories;

import com.wcarvalho.course.entities.OrderItem;
import com.wcarvalho.course.entities.User;
import com.wcarvalho.course.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

//Repository → conversa direto com o banco
//É o intermediário entre o mundo Java e o banco de dados.
//Quando o Service manda salvar, o Repository transforma o comando em SQL.

//Camada:	    Função:	                                        Usa quem:
//Repository    Acessa o banco de dados (CRUD)                  Chamado pelo Service
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}