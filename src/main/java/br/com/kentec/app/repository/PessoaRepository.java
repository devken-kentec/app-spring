package br.com.kentec.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.kentec.app.domain.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
	
	@Query("SELECT p FROM Pessoa p WHERE p.formacao LIKE %:formacao% ")
	public Iterable<Pessoa> findByFormacao(String formacao);
	//Native @Param("formacao")
	
	@Query("FROM Pessoa WHERE UPPER(nome) LIKE CONCAT('%', UPPER(?1), '%')")
	public List<Pessoa> findByNome(String nome);
	
	@Query("FROM Pessoa WHERE UPPER(formacao) LIKE CONCAT('%', UPPER(?1), '%')")
	public List<Pessoa> findByFormacao2(String formacao);
	
}
