package br.com.crud.clientes.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.crud.clientes.domain.Cliente;
import br.com.crud.clientes.repositories.ClienteRepository;

@Configuration
@Profile("local")
public class LocalConfig {
	
	@Autowired
	private ClienteRepository repository;
	
	@Bean
	public void startDB() {
		Cliente cliente1 = new Cliente(null, "Cliente1", "Av. Silva Jardim, 123", "11.111.111-11", "cli1@mail.com");
		Cliente cliente2 = new Cliente(null, "Cliente2", "Av. Jardim Silva, 123", "22.222.222-22", "cli2@mail.com");
		
		repository.saveAll(List.of(cliente1, cliente2));
	}

}
