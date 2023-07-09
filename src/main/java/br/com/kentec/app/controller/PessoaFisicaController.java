package br.com.kentec.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.kentec.app.dto.PessoaFisicaDTO;
import br.com.kentec.app.service.PessoaFisicaService;

@RestController
@RequestMapping("/pessoaFisica")
public class PessoaFisicaController {
	
	@Autowired
	private PessoaFisicaService pfs;
	
	@GetMapping("/listar")
	public List<PessoaFisicaDTO> findAll(){
		return pfs.findAll();
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody PessoaFisicaDTO pf) {
		pfs.save(pf);
	}

}
