package com.froyo.spring.model.entity.h2;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "currency")
@Data
@ToString
public class CurrencyH2Entity implements Serializable {

	private static final long serialVersionUID = -3815142955075835558L;

	@Id
	@Column(name = "id", nullable = false)
    private Long id; // Each currency will be given an auto-generated unique identifier when stored

    @Column(name = "currency", nullable = false)
    private String currency;

}
