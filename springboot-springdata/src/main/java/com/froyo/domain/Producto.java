package com.froyo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * @author froy
 */
@Entity
@Table(name = "tblproducto")
public class Producto implements Serializable {

    private static final long serialVersionUID = -277616802029174187L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rid")
    private long rid;

    @Column(name = "nombre")
    private String nombreProducto;

    @Column(name = "date_update")
    private Timestamp dateUpdate;

    /**
     * Muchos productos van a estar en una categoría.
     */
    @ManyToOne
    @JoinColumn(name = "rid_categoria")
    private Categoria categoria;

    @OneToMany(
            fetch = FetchType.LAZY,    /* Para que traiga los datos necesarios y los vaya usando conformelos vaya requieriendo ?? */
            mappedBy = "pk.producto",
            cascade = CascadeType.ALL    /* Operaciones en cascada. */
    )
    private Set<Factura> facturarSet = new HashSet<>();

    public Producto() {
    }

    public Producto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public long getRid() {
        return rid;
    }

    public void setRid(long rid) {
        this.rid = rid;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Timestamp getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Timestamp dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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
        builder.append("Producto [rid=");
        builder.append(rid);
        builder.append(", nombrfacturarSeteProducto=");
        builder.append(nombreProducto);
        builder.append(", dateUpdate=");
        builder.append(dateUpdate);
        builder.append(", categoria=");
        builder.append(categoria.getCategoria());
        builder.append(", facturarSet=");
        builder.append(facturarSet.size());
        builder.append("]\n");
        return builder.toString();
    }


}
