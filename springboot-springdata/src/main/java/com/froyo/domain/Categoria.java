package com.froyo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author froy
 */
@Entity
@Table(name = "tblcategoria")
public class Categoria implements Serializable {

    private static final long serialVersionUID = -4709178056276993177L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rid")
    private long rid;

    @Column(name = "categoria")
    private String categoria;

    /**
     * https://www.udemy.com/persistencia-de-datos-con-java/learn/v4/t/lecture/5619788?start=330
     * Una categoría va estar en muchos productos.
     */
    @OneToMany(mappedBy = "categoria") /* Nombre del atributo en la clase Producto (buscar el atributo con la anotación @JoinColumn) */
    private Set<Producto> productos;

    public Categoria() {

    }

    public Categoria(long rid) {
        this.rid = rid;
    }

    public long getRid() {
        return rid;
    }

    public void setRid(long rid) {
        this.rid = rid;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Categoria [rid=");
        builder.append(rid);
        builder.append(", categoria=");
        builder.append(categoria);
        builder.append(", productos=");
        builder.append(productos.size());
        builder.append("]\n");
        return builder.toString();
    }


}
