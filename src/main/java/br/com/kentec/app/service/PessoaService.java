package br.com.kentec.app.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.kentec.app.domain.Pessoa;
import br.com.kentec.app.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pr;
	
	public Iterable<Pessoa> listPessoa(){
		return pr.findAll();
	}
	
	public Optional<Pessoa> listPessoaById(Integer id){
		return pr.findById(id);
	}
	
	public Iterable<Pessoa> listPessoaByFormacao(String formacao){
		return pr.findByFormacao(formacao);
	}
	
	public List<Pessoa> lisPessoaByFormacao2(String formacao){
		return pr.findByFormacao2(formacao);
	}
	
	public List<Pessoa> listFindByNome(String nome){
		return pr.findByNome(nome);
	}
	
	public void gravar(Pessoa pessoa) {
		pr.save(pessoa);
	}
	
	public void alterar(Pessoa pessoa) {
		Optional<Pessoa> p = pr.findById(pessoa.getId()); 
		if(p.isPresent()) {
			pr.save(pessoa);
		}
	}
	
	public void delete(Integer id) {
		Optional<Pessoa> pessoa= this.listPessoaById(id);
		if(pessoa.isPresent()) {
			pr.deleteById(id);
		}		
	}
}
