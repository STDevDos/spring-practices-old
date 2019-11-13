package com.froyo.spring.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.froyo.spring.model.entity.listener.CurrencyListener;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "currency")
@EntityListeners(CurrencyListener.class) // Listener process logs
@Data
@ToString
public class CurrencyEntity implements Serializable {

	private static final long serialVersionUID = 6734139637088679530L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Each currency will be given an auto-generated unique identifier when stored

    @Column(name = "currency", nullable = false)
    private String currency;

}
