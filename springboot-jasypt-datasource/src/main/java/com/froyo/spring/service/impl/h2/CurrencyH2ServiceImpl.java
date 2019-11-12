package com.froyo.spring.service.impl.h2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.froyo.spring.model.entity.h2.CurrencyH2Entity;
import com.froyo.spring.repository.h2.CurrencyH2Repository;
import com.froyo.spring.service.CurrencyService;

@Service("currencyH2ServiceImpl")
public class CurrencyH2ServiceImpl implements CurrencyService {

	@Autowired
	private CurrencyH2Repository currencyH2Repository;

	@Override
	public String addCurrency() {

		CurrencyH2Entity currencyH2Entity = new CurrencyH2Entity();
		currencyH2Entity.setId(5L);
		currencyH2Entity.setCurrency("btc");

		currencyH2Repository.saveCurrency();

		return "success";

	}

	@Override
	public void insertCurrency(Long id, String currency) {
		CurrencyH2Entity currencyH2Entity = new CurrencyH2Entity();
		currencyH2Entity.setId(5L);
		currencyH2Entity.setCurrency("btc");

		currencyH2Repository.saveCurrency();

	}

}
