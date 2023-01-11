package com.rahul.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository
		extends JpaRepository<com.rahul.microservices.currencyexchangeservice.CurrancyExchange, Long> {
	
	public CurrancyExchange findByFromAndTo(String from,String to);

}
