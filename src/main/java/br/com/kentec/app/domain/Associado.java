package br.com.kentec.app.domain;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="associado")
@SuppressWarnings("serial")
public class Associado implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="funcao", nullable = true, length = 50)
	private String funcao;
	
	@ManyToOne
	@JoinColumn(name="pessoa_id")
	private Pessoa pessoa = new Pessoa();
	
	public Associado() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Associado [id=" + id + ", funcao=" + funcao + ", pessoa=" + pessoa + "]";
	}	
}
