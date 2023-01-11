package com.rahul.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

	@Autowired
	CurrancyExchangeProxy proxy;

	@GetMapping("/currancy-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertCurrancy(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		RestTemplate rest = new RestTemplate();
		HashMap<String, String> pathData = new HashMap<>();
		pathData.put("from", from);
		pathData.put("to", to);

		ResponseEntity<CurrencyConversion> responseEntity = rest.getForEntity(
				"http://localhost:8000/currance-exchange/from/{from}/to/{to}", CurrencyConversion.class, pathData);

		CurrencyConversion currancyConversion = responseEntity.getBody();
		currancyConversion.setTotalCalculatedAmount(quantity.multiply(currancyConversion.getConvertionMultiple()));
		currancyConversion.setQuantity(quantity);
		return currancyConversion;

	}

	@GetMapping("/currancy-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertCurrancyFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		CurrencyConversion currencyConversion = proxy.retriveExchangeValue(from, to);
		currencyConversion.setTotalCalculatedAmount(quantity.multiply(currencyConversion.getConvertionMultiple()));
		currencyConversion.setQuantity(quantity);
		return currencyConversion;

	}

}
