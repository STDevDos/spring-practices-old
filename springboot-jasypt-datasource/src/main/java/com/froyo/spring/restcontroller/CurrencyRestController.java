package com.froyo.spring.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.froyo.spring.service.CurrencyService;

@RestController
@RequestMapping("/api")
public class CurrencyRestController {
	
	@Autowired
	@Qualifier("currencyPostgresServiceImpl")
	private CurrencyService currencyPostgresService;
	
	@Autowired
	@Qualifier("currencyH2ServiceImpl")
	private CurrencyService currencyH2Service;
	
	@GetMapping("/addCurrency")
	private String addCurrencyH2() {
		currencyPostgresService.addCurrency();
		currencyH2Service.insertCurrency(5L, "BTC");
		return "success";
	}
	
}
