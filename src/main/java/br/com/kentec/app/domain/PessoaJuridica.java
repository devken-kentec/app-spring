package br.com.kentec.app.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="pessoa_juridica")
@SuppressWarnings("serial")
public class PessoaJuridica extends Usuario {
	
	@Column(name="cnpj", nullable = true, length = 14)
	private String cnpj;
	
	@Column(name="data", nullable = true)
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate data;
	
	public PessoaJuridica() {
		
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "PessoaJuridica [cnpj=" + cnpj + ", data=" + data + "]";
	}
	
	
}
