package com.antonio.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.antonio.dsmeta.entities.Sale;
import com.antonio.dsmeta.services.SaleService;
import com.antonio.dsmeta.services.SmsService;

// Classe que disponibiliza os endpoints onde p frontend vai acessar o backend
@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	//Controller chama o Service
	@Autowired
	private SaleService service;
	
	@Autowired
	private SmsService smsService;
	
	//método que disponibiliza as vendas para o frontend
	@GetMapping
	public Page<Sale> findSales(
			@RequestParam(value = "minDate", defaultValue = "") String minDate, 
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate, 
			Pageable pageable){
		return service.findSales(minDate, maxDate, pageable);
	}
	
	@GetMapping("/{id}/notification")
	public void notifySms(@PathVariable Long id) {
		smsService.sendSms(id);
	}

}
