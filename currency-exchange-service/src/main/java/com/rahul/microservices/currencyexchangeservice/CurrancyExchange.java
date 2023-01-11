package com.rahul.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import io.micrometer.core.annotation.Counted;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CurrancyExchange")
public class CurrancyExchange {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "from_currency")
	private String from;
	
	@Column(name = "to_currency")
	private String to;
	
	private BigDecimal convertionMultiple;
	
	private String environment;

	public CurrancyExchange(Long id, String from, String to, BigDecimal convertionMultiple, String environment) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.convertionMultiple = convertionMultiple;
		this.environment = environment;
	}

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

	public BigDecimal getConvertionMultiple() {
		return convertionMultiple;
	}

	public void setConvertionMultiple(BigDecimal convertionMultiple) {
		this.convertionMultiple = convertionMultiple;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public CurrancyExchange() {
		super();
	}

}
