package br.com.crud.clientes.service.impl;

import br.com.crud.clientes.domain.Cliente;
import br.com.crud.clientes.domain.dto.ClienteDTO;
import br.com.crud.clientes.repositories.ClienteRepository;
import br.com.crud.clientes.service.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository repository;

	@Autowired
	private ModelMapper mapper;

	public List<Cliente> findAll(){
		return repository.findAll();
	}

	@Override
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElse(null);
	}

	@Override
	public Cliente update (ClienteDTO cli){
		return repository.save(mapper.map(cli, Cliente.class));
	}

	@Override
	public Cliente create(ClienteDTO cli) {
		return repository.save(mapper.map(cli, Cliente.class));
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
