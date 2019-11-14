package simpleSpringData.domain.dsl;

import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.EntityPathBase;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.PathInits;
import simpleSpringData.domain.Factura;

import javax.annotation.Generated;

import static com.mysema.query.types.PathMetadataFactory.forVariable;


/**
 * QFactura is a Querydsl query type for Factura
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QFactura extends EntityPathBase<Factura> {

    private static final long serialVersionUID = -433410960L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFactura factura = new QFactura("factura");

    public final QProductoVendedor pk;

    public final QProducto producto;

    public final NumberPath<Long> rid = createNumber("rid", Long.class);

    public final QVendedor vendedor;

    public QFactura(String variable) {
        this(Factura.class, forVariable(variable), INITS);
    }

    public QFactura(Path<? extends Factura> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QFactura(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QFactura(PathMetadata<?> metadata, PathInits inits) {
        this(Factura.class, metadata, inits);
    }

    public QFactura(Class<? extends Factura> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.pk = inits.isInitialized("pk") ? new QProductoVendedor(forProperty("pk"), inits.get("pk")) : null;
        this.producto = inits.isInitialized("producto") ? new QProducto(forProperty("producto"), inits.get("producto")) : null;
        this.vendedor = inits.isInitialized("vendedor") ? new QVendedor(forProperty("vendedor")) : null;
    }

}

