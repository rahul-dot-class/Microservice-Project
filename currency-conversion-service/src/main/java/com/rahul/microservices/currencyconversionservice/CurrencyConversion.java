package com.rahul.microservices.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyConversion {
	
	private Long id;

	//@Column(name = "from_currency")
	private String from;
	
	//@Column(name = "to_currency")
	private String to;
	
	private BigDecimal quantity;

	private BigDecimal convertionMultiple;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getConvertionMultiple() {
		return convertionMultiple;
	}

	public void setConvertionMultiple(BigDecimal convertionMultiple) {
		this.convertionMultiple = convertionMultiple;
	}

	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public CurrencyConversion() {
		super();
	}

	public CurrencyConversion(Long id, String from, String to, BigDecimal quantity, BigDecimal convertionMultiple,
			BigDecimal totalCalculatedAmount, String environment) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.quantity = quantity;
		this.convertionMultiple = convertionMultiple;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.environment = environment;
	}

	private BigDecimal totalCalculatedAmount;
	
	private String environment;
	
	

}
