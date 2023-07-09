package br.com.kentec.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.app.domain.Associado;
import br.com.kentec.app.service.AssociadoService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/associado")
public class AssociadoController {
	
	@Autowired
	private AssociadoService as;
	
	@GetMapping()
	public Iterable<Associado> listarAssociado(){
		return as.listarAssociado();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Associado> listarAssociado(@PathVariable("id") Integer id){
		Optional<Associado> associado = as.listarAssociadoById(id);
		return associado.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/pesquisar")
	public ResponseEntity<List<Associado>> pesquisar(
			@RequestParam(value ="nome", required = false, defaultValue = "") String nome, 
			@RequestParam(value ="funcao", required = false, defaultValue = "") String funcao) {
		return ResponseEntity.ok(as.findByNomeAndFuncao("%" + nome + "%", "%" + funcao + "%"));
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void gravar(@RequestBody Associado associado) {
		as.gravar(associado);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void altarar(@RequestBody Associado associado) {
		as.alterar(associado);
	}
	
}
