package com.example.bancodedados.domain.repository;

import com.example.bancodedados.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Clientes extends JpaRepository<Cliente, Integer> {
    // 0 formato do nome do método diz para o spring data o que queremos que ele faça

    // findBy + _prop_name_ + Like(SQL like)
    List<Cliente> findByNomeLike(String nome);

    // existsBy + _prop_name_
    boolean existsByNome(String nome);

    // findOneBy + _prop_name_
    Cliente findOneByNome(String nome);

    // sem usar o formato que o jpa entende sozinho:
    //  @Query(value = " select * from cliente c where c.nome like %:nome% ", nativeQuery = true) // usando SQL nativo
    @Query(value = " select c from Cliente c where c.nome like :nome ") // usando HQL
    List<Cliente> encontrarPorNome(@Param("nome")String nome);

     @Query(value = " delete from Cliente c where c.nome =:nome " )
     @Modifying // é usado para querys que modificarão o DB: create, update, delete
     void deleteByNome(String nome);

     @Query(value = " select c from Cliente c left join fetch c.pedidos where c.id = :id ")
     Cliente findClientFetchPedidos(@Param("id") Integer id);
}
