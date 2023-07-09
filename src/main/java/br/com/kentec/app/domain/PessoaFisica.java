package br.com.kentec.app.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="pessoa_fisica")
@SuppressWarnings("serial")
public class PessoaFisica extends Usuario {
	
	@Column(name="cpf", nullable = true, length = 11)
	private String cpf;
	
	@Column(name="data", nullable = true)
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate data;
	
	public PessoaFisica() {
		
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
		return "PessoaFisica [cpf=" + cpf + ", data=" + data + "]";
	}
	
}
