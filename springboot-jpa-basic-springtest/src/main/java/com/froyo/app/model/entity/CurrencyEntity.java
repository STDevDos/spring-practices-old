package com.froyo.app.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "currency",uniqueConstraints = {
        @UniqueConstraint(columnNames = "currency", name = "uniqueCurrencyConstraint")
    }
)
@Data
public class CurrencyEntity implements Serializable {

    private static final long serialVersionUID = 6734139637088679530L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Each currency will be given an auto-generated unique identifier when stored

    @Column(name = "currency", nullable = false)
    private String currency;

}
