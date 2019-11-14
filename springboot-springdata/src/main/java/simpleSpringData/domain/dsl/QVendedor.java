package simpleSpringData.domain.dsl;

import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.*;
import simpleSpringData.domain.Factura;
import simpleSpringData.domain.Vendedor;

import javax.annotation.Generated;

import static com.mysema.query.types.PathMetadataFactory.forVariable;


/**
 * QVendedor is a Querydsl query type for Vendedor
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QVendedor extends EntityPathBase<Vendedor> {

    public static final QVendedor vendedor = new QVendedor("vendedor");
    private static final long serialVersionUID = 1119025903L;
    public final SetPath<Factura, QFactura> facturarSet = this.<Factura, QFactura>createSet("facturarSet", Factura.class, QFactura.class, PathInits.DIRECT2);

    public final StringPath nombre = createString("nombre");

    public final NumberPath<Long> rid = createNumber("rid", Long.class);

    public QVendedor(String variable) {
        super(Vendedor.class, forVariable(variable));
    }

    public QVendedor(Path<? extends Vendedor> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVendedor(PathMetadata<?> metadata) {
        super(Vendedor.class, metadata);
    }

}
