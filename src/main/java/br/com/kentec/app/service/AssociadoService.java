package br.com.kentec.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.kentec.app.domain.Associado;
import br.com.kentec.app.domain.Pessoa;
import br.com.kentec.app.repository.AssociadoRepository;
import br.com.kentec.app.repository.PessoaRepository;

@Service
public class AssociadoService {
	
	@Autowired
	private AssociadoRepository ar;
	
	@Autowired
	private PessoaRepository pr;
	
	public Iterable<Associado> listarAssociado(){
		return ar.findAll();
	}
	
	public void gravar(Associado associado) {
	
		//Caso use DTO para salvar
		/*Associado associado = new Associado(); 
		associado.setFuncao(associadoDto.getFuncao());*/
		
		Pessoa pessoa = pr.findById(associado.getPessoa().getId()).orElseThrow(()-> 
				new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente não Encontrado"));
		
		associado.setPessoa(pessoa);
		
		ar.save(associado);
	}
	
	public void alterar(Associado associado) {
		
		//Caso use DTO para salvar
		/*Associado associado = new Associado(); 
		associado.setFuncao(associadoDto.getFuncao());*/
		
		Pessoa pessoa = pr.findById(associado.getPessoa().getId()).orElseThrow(()-> 
				new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente não Encontrado"));
		
		associado.setPessoa(pessoa);
		
		ar.save(associado);
	}
	
	
	public List<Associado> findByNomeAndFuncao(String nome, String funcao) {
	
		return ar.findByNomeAndFuncao(nome, funcao);
	}

	public Optional<Associado> listarAssociadoById(Integer id) {
		return ar.findById(id);
	}

}
