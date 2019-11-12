package com.froyo.spring.model.entity.postgres;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "currency")
@EntityListeners(AuditingEntityListener.class) //Ejecutara los los procesos dentro de AuditingEntityListener en el momento que se afecte (Insert,Update,Delete) CurrrencyPostgresEntity
@Data
@ToString
public class CurrrencyPostgresEntity implements Serializable {

	private static final long serialVersionUID = 6734139637088679530L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // Each currency will be given an auto-generated unique identifier when stored

    @Column(name = "currency", nullable = false)
    private String currency;

}
