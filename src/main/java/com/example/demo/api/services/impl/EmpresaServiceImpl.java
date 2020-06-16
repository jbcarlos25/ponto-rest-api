package com.example.demo.api.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.api.entity.Empresa;
import com.example.demo.api.repositories.EmpresaRepository;
import com.example.demo.api.services.EmpresaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmpresaServiceImpl implements EmpresaService {
	
	private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);
	
	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	public Optional<Empresa> buscarPorCnpj(String cnpj) {
		log.info("Buscar uma empresa para o CNPJ {} ", cnpj);
		return Optional.ofNullable(empresaRepository.findByCnpj(cnpj));
	}

	@Override
	public Empresa persistir(Empresa empresa) {
		log.info("Persistindo empresa: {} ", empresa);
		return this.empresaRepository.save(empresa);
	}

}
