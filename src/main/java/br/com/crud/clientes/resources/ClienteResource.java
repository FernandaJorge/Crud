package br.com.crud.clientes.resources;


import br.com.crud.clientes.domain.dto.ClienteDTO;
import br.com.crud.clientes.service.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {
	
	@Autowired(required = false)
    private ClienteService service;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(mapper.map(service.findById(id), ClienteDTO.class));
    }
	 
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll(){
	     return ResponseEntity.ok()
				.body(service.findAll()
						.stream().map(x -> mapper.map(x, ClienteDTO.class)).collect(Collectors.toList()));
	}	

	@PutMapping("/{id}")
	public ResponseEntity<ClienteDTO> update(@PathVariable Integer id, @RequestBody ClienteDTO cli){
		cli.setId(id);
		return ResponseEntity.ok().body(mapper.map(service.update(cli), ClienteDTO.class));
	}

	@PostMapping
	public ResponseEntity<ClienteDTO> create(@RequestBody ClienteDTO cli){
		URI uri = ServletUriComponentsBuilder.
				fromCurrentRequestUri().path("/{id}").buildAndExpand(service.create(cli).getId()).toUri();
		return  ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ClienteDTO> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
