package br.com.kentec.app.dto;

import java.time.LocalDate;

import br.com.kentec.app.domain.PessoaFisica;

public class PessoaFisicaDTO {
	
	private Long id;
	private String nome;
	private String cpf;
	private LocalDate data;
	
	public PessoaFisicaDTO() {
		
	}
	
	public PessoaFisicaDTO(PessoaFisica pf) {
		this.id = pf.getId();
		this.nome = pf.getNome();
		this.cpf = pf.getCpf();
		this.data = pf.getData();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "PessoaFisicaDTO [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", data=" + data + "]";
	}


}
