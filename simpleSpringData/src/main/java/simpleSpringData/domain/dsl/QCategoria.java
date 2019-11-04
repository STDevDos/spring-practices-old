package simpleSpringData.domain.dsl;

import static com.mysema.query.types.PathMetadataFactory.forVariable;

import javax.annotation.Generated;

import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.EntityPathBase;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.PathInits;
import com.mysema.query.types.path.SetPath;
import com.mysema.query.types.path.StringPath;

import simpleSpringData.domain.Categoria;
import simpleSpringData.domain.Producto;


/**
 * QCategoria is a Querydsl query type for Categoria
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCategoria extends EntityPathBase<Categoria> {

    private static final long serialVersionUID = -1303451605L;

    public static final QCategoria categoria1 = new QCategoria("categoria1");

    public final StringPath categoria = createString("categoria");

    public final SetPath<Producto, QProducto> productos = this.<Producto, QProducto>createSet("productos", Producto.class, QProducto.class, PathInits.DIRECT2);

    public final NumberPath<Long> rid = createNumber("rid", Long.class);

    public QCategoria(String variable) {
        super(Categoria.class, forVariable(variable));
    }

    public QCategoria(Path<? extends Categoria> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCategoria(PathMetadata<?> metadata) {
        super(Categoria.class, metadata);
    }

}

