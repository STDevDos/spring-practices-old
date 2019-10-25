package simpleSpringData.domain.dsl;

import com.fd.simpleSpringData.domain.Factura;
import com.fd.simpleSpringData.domain.Producto;
import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;

import static com.mysema.query.types.PathMetadataFactory.forVariable;


/**
 * QProducto is a Querydsl query type for Producto
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QProducto extends EntityPathBase<Producto> {

    private static final long serialVersionUID = -2066150552L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProducto producto = new QProducto("producto");

    public final QCategoria categoria;

    public final DateTimePath<java.sql.Timestamp> dateUpdate = createDateTime("dateUpdate", java.sql.Timestamp.class);

    public final SetPath<Factura, QFactura> facturarSet = this.<Factura, QFactura>createSet("facturarSet", Factura.class, QFactura.class, PathInits.DIRECT2);

    public final StringPath nombreProducto = createString("nombreProducto");

    public final NumberPath<Long> rid = createNumber("rid", Long.class);

    public QProducto(String variable) {
        this(Producto.class, forVariable(variable), INITS);
    }

    public QProducto(Path<? extends Producto> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProducto(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProducto(PathMetadata<?> metadata, PathInits inits) {
        this(Producto.class, metadata, inits);
    }

    public QProducto(Class<? extends Producto> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.categoria = inits.isInitialized("categoria") ? new QCategoria(forProperty("categoria")) : null;
    }

}

