package com.example.bancodedados.domain.repository;

import com.example.bancodedados.domain.entity.Cliente;
import com.example.bancodedados.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface Pedidos extends JpaRepository<Pedido, Integer> {
    List<Pedido> findByCliente(Cliente cliente);
}
