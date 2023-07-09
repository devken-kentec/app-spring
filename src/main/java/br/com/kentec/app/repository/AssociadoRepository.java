package br.com.kentec.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.kentec.app.domain.Associado;

public interface AssociadoRepository extends JpaRepository<Associado, Integer>{
	
	@Query("SELECT a FROM Associado a JOIN a.pessoa p "
			+ "WHERE UPPER(p.nome) LIKE UPPER(:nome) AND UPPER(a.funcao) LIKE UPPER(:funcao)")
	List<Associado> findByNomeAndFuncao(
			@Param("nome") String nome, 
			@Param("funcao") String funcao);

}
