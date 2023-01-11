package com.rahul.microservices.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrancyExchangeController {
	
	@Autowired CurrencyExchangeRepository currencyRepo;
	@Autowired Environment environmet;
	
	@GetMapping("/currance-exchange/from/{from}/to/{to}")
	public CurrancyExchange retriveExchangeValue(@PathVariable String from,@PathVariable String to) {
		CurrancyExchange currancyExchange =currencyRepo.findByFromAndTo(from, to);
		currancyExchange.setEnvironment(environmet.getProperty("server.port")) ;
		return currancyExchange;
	}

}
