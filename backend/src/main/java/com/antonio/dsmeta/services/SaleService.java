package com.antonio.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.antonio.dsmeta.entities.Sale;
import com.antonio.dsmeta.repositories.SaleRepository;

// Componente responsável por fazer operaçoes de negócios, buscar vendas no banco de dados
@Service
public class SaleService {

	//Service chama o repository
	@Autowired
	private SaleRepository repository;

	// buscar uma lista de vendas
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {
		
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		// converter as datas Stgring para localDate java
		LocalDate min = minDate.equals("") ? today.minusYears(1) : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
		
		return repository.findSales(min, max, pageable);
	}

}
