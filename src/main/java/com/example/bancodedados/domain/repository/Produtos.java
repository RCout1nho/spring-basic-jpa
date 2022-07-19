package com.example.bancodedados.domain.repository;

import com.example.bancodedados.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto, Integer> { // Integer indica o tipo de dados da chave do id

}
