package simpleSpringData.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author froy
 */
@Entity
@Table(name = "tblfactura")
@AssociationOverrides({
        @AssociationOverride(name = "pk.producto", joinColumns = @JoinColumn(name = "rid_producto")),
        @AssociationOverride(name = "pk.vendedor", joinColumns = @JoinColumn(name = "rid_vendedor"))
})
public class Factura implements Serializable {

    private static final long serialVersionUID = -2781598635517468873L;

    /**
     * pk.producto (pk = nombre del objeto)
     */
    private ProductoVendedor pk = new ProductoVendedor();

    //Campo extras...
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rid")
    private long rid;

    public long getRid() {
        return rid;
    }

    public void setRid(long rid) {
        this.rid = rid;
    }

    @Embedded
    public ProductoVendedor getPk() {
        return pk;
    }

    public Vendedor getVendedor() {
        return this.getPk().getVendedor();
    }

    public void setVendedor(Vendedor vendedor) {
        this.getPk().setVendedor(vendedor);
    }

    public void setPk(ProductoVendedor pk) {
        this.pk = pk;
    }

    public Producto getProducto() {
        return this.getPk().getProducto();
    }

    public void setProducto(Producto producto) {
        this.getPk().setProducto(producto);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Factura [pk=");
        builder.append(pk);
        builder.append(", rid=");
        builder.append(rid);
        builder.append("]\n");
        return builder.toString();
    }

}
