package br.com.kentec.app.dto;

public class AssociadoDto {
	
	private String funcao;
	private Integer pessoaId;
	
	public AssociadoDto() {
		
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Integer getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Integer pessoaId) {
		this.pessoaId = pessoaId;
	}
	
}
