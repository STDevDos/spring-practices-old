package com.froyo.domain;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * @author froy
 */
@Embeddable     /* Clase de ids compuestos */
public class ProductoVendedor implements Serializable {

    private static final long serialVersionUID = 642339734335735479L;

    @ManyToOne
    private Vendedor vendedor;
    @ManyToOne
    private Producto producto;

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ProductoVendedor [vendedor=");
        builder.append(vendedor.getNombre());
        builder.append(", producto=");
        builder.append(producto.getNombreProducto());
        builder.append("]\n");
        return builder.toString();
    }


}
