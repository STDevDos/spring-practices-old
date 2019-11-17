package com.froyo.pesistence.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Froy
 */
@Entity
@Table(name = "tblpersona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rid")
    private long rid;

    @Column(name = "rfc")
    private String rfc;

    @Column(name = "fullname")
    private String nombreCompleto;

    @Column(name = "dateupdate")
    private Timestamp fechaUpdate;

    public long getRid() {
        return rid;
    }

    public void setRid(long rid) {
        this.rid = rid;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Timestamp getFechaUpdate() {
        return fechaUpdate;
    }

    public void setFechaUpdate(Timestamp fechaUpdate) {
        this.fechaUpdate = fechaUpdate;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Persona [rid=");
        builder.append(rid);
        builder.append(", rfc=");
        builder.append(rfc);
        builder.append(", nombreCompleto=");
        builder.append(nombreCompleto);
        builder.append(", fechaUpdate=");
        builder.append(fechaUpdate);
        builder.append("]");
        return builder.toString();
    }

}
