package com.froyo.domain.dsl;

import com.froyo.domain.ProductoVendedor;
import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.BeanPath;
import com.mysema.query.types.path.PathInits;

import javax.annotation.Generated;

import static com.mysema.query.types.PathMetadataFactory.forVariable;


/**
 * QProductoVendedor is a Querydsl query type for ProductoVendedor
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QProductoVendedor extends BeanPath<ProductoVendedor> {

    public static final QProductoVendedor productoVendedor = new QProductoVendedor("productoVendedor");
    private static final long serialVersionUID = 1313556591L;
    private static final PathInits INITS = PathInits.DIRECT2;
    public final QProducto producto;

    public final QVendedor vendedor;

    public QProductoVendedor(String variable) {
        this(ProductoVendedor.class, forVariable(variable), INITS);
    }

    public QProductoVendedor(Path<? extends ProductoVendedor> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProductoVendedor(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProductoVendedor(PathMetadata<?> metadata, PathInits inits) {
        this(ProductoVendedor.class, metadata, inits);
    }

    public QProductoVendedor(Class<? extends ProductoVendedor> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.producto = inits.isInitialized("producto") ? new QProducto(forProperty("producto"), inits.get("producto")) : null;
        this.vendedor = inits.isInitialized("vendedor") ? new QVendedor(forProperty("vendedor")) : null;
    }

}

