package br.com.kentec.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kentec.app.domain.PessoaFisica;
import br.com.kentec.app.dto.PessoaFisicaDTO;
import br.com.kentec.app.repository.PessoaFisicaRepository;

@Service
public class PessoaFisicaService {
	
	@Autowired
	private PessoaFisicaRepository pfr;
	
	public List<PessoaFisicaDTO> findAll(){
		return pfr.findAll().stream().map(PessoaFisicaDTO::new).collect(Collectors.toList());
	}
	
	public void save(PessoaFisicaDTO pf) {
		
		PessoaFisica pessoa = new PessoaFisica();
		pessoa.setNome(pf.getNome());
		pessoa.setCpf(pf.getCpf());
		pessoa.setData(pf.getData());
		
		pfr.save(pessoa);
	}
}
