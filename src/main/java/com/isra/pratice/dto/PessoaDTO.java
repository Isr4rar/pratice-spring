package com.isra.pratice.dto;

import java.io.Serializable;

import com.isra.pratice.domain.Pessoa;

public class PessoaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String email;
	private String cpf;
	
	public PessoaDTO() {
	}

	public PessoaDTO(Integer id, String nome, String email, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}
	
	public PessoaDTO(Pessoa obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
		cpf = obj.getCpf();
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	

}
