package br.com.crud.clientes.service;

import br.com.crud.clientes.domain.Cliente;
import br.com.crud.clientes.domain.dto.ClienteDTO;

import java.util.List;

public interface ClienteService {
	
	List<Cliente>findAll();

	Cliente findById(Integer id);

	Cliente update(ClienteDTO obj);

	Cliente create(ClienteDTO obj);

	void delete(Integer id);
}
