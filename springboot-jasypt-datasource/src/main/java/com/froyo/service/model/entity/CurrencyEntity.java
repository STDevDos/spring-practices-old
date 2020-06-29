package com.froyo.service.model.entity;

import com.froyo.service.model.entity.listener.CurrencyListener;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "currency")
@EntityListeners(CurrencyListener.class) // Listener process logs
@Data
public class CurrencyEntity implements Serializable {

    private static final long serialVersionUID = 6734139637088679530L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Each currency will be given an auto-generated unique identifier when stored

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "fechacompleta", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime fechacompleta;

    @Column(name = "fecha", nullable = false, columnDefinition = "DATE")
    private LocalDate fecha;

    @Column(name = "tiempo", nullable = false, columnDefinition = "TIME")
    private LocalTime tiempo;

}
