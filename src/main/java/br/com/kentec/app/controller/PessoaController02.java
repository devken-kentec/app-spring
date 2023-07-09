package br.com.kentec.app.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.kentec.app.domain.Pessoa;
import br.com.kentec.app.service.PessoaService;

@RestController
@RequestMapping("/pessoa02")
public class PessoaController02 {
	
	@Autowired
	private PessoaService ps;
	
	@GetMapping()
	public ResponseEntity<Iterable<Pessoa>> listarPessoa(){
		//return new ResponseEntity<>(ps.listPessoa(), HttpStatus.OK);
		return ResponseEntity.ok(ps.listPessoa());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> listarPessoa(@PathVariable("id") Integer id){
		Optional<Pessoa> pessoa = ps.listPessoaById(id);
		
		//Normal
		/*if(pessoa.isPresent()) {
			return ResponseEntity.ok(pessoa.get());
		} else {
			return ResponseEntity.notFound().build();
		}*/
		
		//Operador ternario
		//return  pessoa.isPresent()? ResponseEntity.ok(pessoa.get()):ResponseEntity.notFound().build();
		
		//Função lambda
		//return pessoa.map(p -> ResponseEntity.ok(p)).orElse(ResponseEntity.notFound().build());
		
		//Função lambda
		return pessoa
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/tipo/{formacao}")
	public ResponseEntity<List<Pessoa>> listarPessoaformacao2(@PathVariable("formacao") String formacao){
		List<Pessoa> pessoa = ps.lisPessoaByFormacao2(formacao);
		return pessoa.isEmpty()?ResponseEntity.noContent().build():ResponseEntity.ok(pessoa);	
	
		/*	if(pessoa.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(pessoa);
		}*/
	}
}
