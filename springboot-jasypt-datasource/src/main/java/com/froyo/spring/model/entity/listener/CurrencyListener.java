package com.froyo.spring.model.entity.listener;

import com.froyo.spring.model.entity.CurrencyEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;

public class CurrencyListener {

    @PrePersist
    public void salvar(CurrencyEntity currency) {
        System.out.println("save CURRENCY: " + currency.getCurrency());
    }

    @PreRemove
    public void borrar(CurrencyEntity currency) {
        System.out.println("remove CURRENCY: " + currency.getCurrency());
    }

}
