package com.froyo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author froy
 */
@Entity
@Table(name = "tblvendedor")
public class Vendedor implements Serializable {

    private static final long serialVersionUID = -5197146734804952998L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rid")
    private long rid;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(
            fetch = FetchType.LAZY,    /* Para que traiga los datos necesarios y los vaya usando conformelos vaya requieriendo ?? */
            mappedBy = "pk.vendedor",
            cascade = CascadeType.ALL    /* Operaciones en cascada. */
    )
    private Set<Factura> facturarSet = new HashSet<>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getRid() {
        return rid;
    }

    public void setRid(long rid) {
        this.rid = rid;
    }

    public Set<Factura> getFacturarSet() {
        return facturarSet;
    }

    public void setFacturarSet(Set<Factura> facturarSet) {
        this.facturarSet = facturarSet;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Vendedor [rid=");
        builder.append(rid);
        builder.append(", nombre=");
        builder.append(nombre);
        builder.append(", facturarSet=");
        builder.append(facturarSet.size());
        builder.append("]\n");
        return builder.toString();
    }

}
