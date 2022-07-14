package com.antonio.dsmeta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.antonio.dsmeta.entities.Sale;

// Sistema responsável por acessar o banco de dados, buscar
public interface SaleRepository extends JpaRepository<Sale, Long>{
	
}
