package com.example.demo.api.repositories;



import java.util.List;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.api.entity.Lancamento;

@Transactional(readOnly = true)
@NamedQueries({
			@NamedQuery(name= "LancamentoRepository.findByFuncionarioId",
					query = "Select lanc From lancamento lanc where lanc.Funcionario.id = :funcionarioId")})

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

	List<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId);
	
	Page<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId, Pageable pageble);
}
