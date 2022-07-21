package com.example.bancodedados;

import com.example.bancodedados.domain.entity.Cliente;
import com.example.bancodedados.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BancoDeDadosApplication {
	public static void main(String[] args) {
		SpringApplication.run(BancoDeDadosApplication.class, args);
	}
}
