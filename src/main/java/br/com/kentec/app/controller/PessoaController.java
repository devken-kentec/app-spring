package br.com.kentec.app.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import br.com.kentec.app.domain.Pessoa;
import br.com.kentec.app.service.PessoaService;


@CrossOrigin(origins = "http://localhost:8100", maxAge = 3600)
@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService ps;
	
	@GetMapping()
	public ResponseEntity<Iterable<Pessoa>> listarPessoa() {
		return ResponseEntity.ok(ps.listPessoa());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> listarPessoa(@PathVariable("id") Integer id) {
		Optional<Pessoa> pessoa = ps.listPessoaById(id);
		return pessoa.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

	}
	
	@GetMapping("/tipo/{formacao}")
	public ResponseEntity<Iterable<Pessoa>> listarPessoaByFormacao(@PathVariable("formacao") String formacao){
		return ResponseEntity.ok(ps.lisPessoaByFormacao2(formacao));
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Pessoa>> listarFindByNome(@PathVariable("nome") String nome){
		List<Pessoa> pessoa = ps.listFindByNome(nome);
		return pessoa.isEmpty()?ResponseEntity.noContent().build():ResponseEntity.ok(pessoa);
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void gravar(@RequestBody Pessoa pessoa) {
		ps.gravar(pessoa);
		
		/*Em caso de debug retornar uma string
		*return "Objeto retornado: " + pessoa;
		*/
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void alterar(@RequestBody Pessoa pessoa) {
		ps.alterar(pessoa);
		//return "Alterado com Sucesso!";
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Integer id) {
		ps.delete(id);
		//return "Deletado com Sucesso!";
	}
}
