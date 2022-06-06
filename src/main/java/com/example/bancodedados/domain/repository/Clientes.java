package com.example.bancodedados.domain.repository;

import com.example.bancodedados.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Clientes {
    private static String INSERT = "insert into cliente (nome) values (?)";
    private static String SELECT_ALL= "select * from cliente";
    private static String UPDATE= "update cliente set nome = ? where id = ?";
    private static String DELETE= "delete from cliente where id = ?";

    @Autowired(required = false)
    private JdbcTemplate jdbcTemplate;

    public Cliente salvar(Cliente cliente){
        jdbcTemplate.update(INSERT, cliente.getNome());
        return cliente;
    }

    public List<Cliente> obterTodos(){
        return jdbcTemplate.query(SELECT_ALL, obterClienteMapper());
    }

    private RowMapper<Cliente> obterClienteMapper() {
        return new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
                Integer id = rs.getInt("id");
                String nome = rs.getString("nome");

                return new Cliente(id, nome);
            }
        };
    }

    public Cliente atualizar(Cliente cliente){
        jdbcTemplate.update(UPDATE, cliente.getNome(), cliente.getId());
        return cliente;
    }

    public void deletar(Integer id){
        jdbcTemplate.update(DELETE, id);
    }

    public List<Cliente> buscarPorNome(String nome){
        return jdbcTemplate.query(SELECT_ALL.concat(" where nome like ?"), new Object[]{
                "%"+nome+"%"
        }, obterClienteMapper());
    }
}
