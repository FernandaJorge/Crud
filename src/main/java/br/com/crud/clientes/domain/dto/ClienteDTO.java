package br.com.crud.clientes.domain.dto;


public class ClienteDTO {
	
	private Integer id;
	private String nome;
	private String endereco;
	private String cpf;
	private String email;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public ClienteDTO(Integer id, String nome, String endereco, String cpf, String email) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.cpf = cpf;
		this.email = email;
	}
	
	public ClienteDTO() {
		super();
	}
	
	

}
