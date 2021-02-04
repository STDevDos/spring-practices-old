package com.platzi.platziweb.model;

import com.platzi.platziweb.common.codevalue.Category;
import com.platzi.platziweb.common.codevalue.Gender;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@Data
@Entity
@Table(name = "cliente")
@NamedQuery(name = "Cliente.findByIdentificacion", query = "Select c from Cliente c where c.identificacion = ?1")
public class Cliente {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    private String nombre;
    private String apellido;
    private String identificacion;
    private String direccion;
    private String telefono;
    private String email;

    @OneToMany(mappedBy = "cliente")
    private Set<Reserva> reservaSet;

    @Column(name = "column_date_time", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime columnDateTime;

    @Column(name = "column_date", nullable = false, columnDefinition = "DATE")
    private LocalDate columnDate;

    @Column(name = "column_time", nullable = false, columnDefinition = "TIME")
    private LocalTime column_time;

    //@Convert(converter = LocalDateTimeConverter.class)
    //@Column(name = "audit_insert_dt", nullable = false)
    //private LocalDateTime auditInsertDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Category category; //CategoryConverter (https://www.baeldung.com/jpa-persisting-enums-in-jpa)

}
