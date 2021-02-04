package com.platzi.platziweb.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private int cantidadPersonas;
    private String decripcion;

    @ManyToOne
    @JoinColumn(name = "id")
    private Cliente cliente;

}
