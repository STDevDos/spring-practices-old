package com.froyo.spring.service.impl.postgres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.froyo.spring.model.entity.postgres.CurrrencyPostgresEntity;
import com.froyo.spring.repository.postgres.CurrencyPostgresRepository;
import com.froyo.spring.service.CurrencyService;

@Service("currencyPostgresServiceImpl")
public class CurrencyPostgresServiceImpl implements CurrencyService {

	@Autowired
	private CurrencyPostgresRepository currencyPostgresRepository;

	@Override
	public String addCurrency() {

		CurrrencyPostgresEntity currrencyPostgresEntity = new CurrrencyPostgresEntity();
		currrencyPostgresEntity.setCurrency("btc");

		currencyPostgresRepository.save(currrencyPostgresEntity);

		return "success";
	}

	@Override
	public void insertCurrency(Long id, String currency) {
		
	}

}
