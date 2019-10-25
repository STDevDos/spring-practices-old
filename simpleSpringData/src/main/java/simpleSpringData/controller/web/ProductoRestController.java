package simpleSpringData.controller.web;

import com.fd.simpleSpringData.domain.Categoria;
import com.fd.simpleSpringData.domain.Factura;
import com.fd.simpleSpringData.domain.Producto;
import com.fd.simpleSpringData.domain.Vendedor;
import com.fd.simpleSpringData.service.CategoriaService;
import com.fd.simpleSpringData.service.FacturaService;
import com.fd.simpleSpringData.service.ProductoService;
import com.fd.simpleSpringData.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Muguruza
 */
//@Controller		/* request válido -> http://localhost:8080/web/common/producto/save solo que quiere regresar un tiles al parecer. */
@RestController
@RequestMapping(value = "/producto")
public class ProductoRestController {

    @Qualifier("productoServiceImpl")
    @Autowired
    private ProductoService productoService;

    @Qualifier("categoriaServiceImpl")
    @Autowired
    private CategoriaService categoriaService;

    @Qualifier("vendedorServiceImpl")
    @Autowired
    private VendedorService vendedorService;

    @Qualifier("facturaServiceImpl")
    @Autowired
    private FacturaService facturaService;

    private int ITEMS_PER_PAGE = 3;

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String saveProducto() {

        Producto producto = new Producto();
        producto.setNombreProducto("Majestic 1");
        producto.setDateUpdate(new Timestamp(new Date().getTime()));
        producto.setCategoria(new Categoria(1l));

        productoService.save(producto);


//		List<Producto> listProducto = new ArrayList<>();
//		listProducto.add(new Producto("Produco uno lista"));
//		listProducto.add(new Producto("Produco dos lista"));
//		productoService.save(producto);

        return "save";
    }

    @RequestMapping(value = "/saveList", method = RequestMethod.GET)
    public String saveListProducto() {

        List<Producto> listProducto = new ArrayList<>();
        listProducto.add(new Producto("Produco uno lista"));
        listProducto.add(new Producto("Produco dos lista"));
        productoService.save(listProducto);

        return "saveList";
    }

    @RequestMapping(value = "/findOne/{rid}", method = RequestMethod.GET)
    public String findOne(@PathVariable("rid") long rid) {
        return productoService.findOne(rid).toString();
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public String findAllProducto() {
        return productoService.findAll().toString();
    }

    @RequestMapping(value = "/exists/{rid}", method = RequestMethod.GET)
    public boolean exists(@PathVariable("rid") long rid) {
        return productoService.exists(rid);
    }

    @RequestMapping(value = "/findByNombre/{nombreProducto}", method = RequestMethod.GET)
    public String findByNombreProductoLike(@PathVariable("nombreProducto") String nombreProducto) {
        return productoService.findByNombreProductoLike(nombreProducto).toString();
    }

    /**
     * Encontrar todos los productos cuya fecha de actualización sea menor a la que se le pasa por parametro.
     *
     * @param updateDate
     * @return
     */
    @RequestMapping(value = "/findByUpdateDate/{updateDate}", method = RequestMethod.GET)
    public String findByDateUpdateLessThan(@PathVariable("updateDate") String updateDate) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date parseDate = null;
        try {
            parseDate = sdf.parse(updateDate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productoService.findByDateUpdateLessThan(new Timestamp(parseDate.getTime())).toString();
    }

    @RequestMapping(value = "/deleteByRid/{rid}", method = RequestMethod.GET)
    public long deleteByRid(@PathVariable("rid") long rid) {
        return productoService.deleteByRid(rid);
    }

    @RequestMapping(value = "/findByRidCategoria/{categoria}", method = RequestMethod.GET)
    public String findByRidCategoria(@PathVariable("categoria") long ridCategoria) {
        Categoria categoria = categoriaService.findOne(ridCategoria);
        return productoService.findByCategoria(categoria).toString();
    }

    @RequestMapping(value = "/findByNombreCategoria/{categoria}", method = RequestMethod.GET)
    public String findByNombreCategoria(@PathVariable("categoria") String nombreCategoria) {
        return productoService.findByCategoria(nombreCategoria).toString();
    }

    @RequestMapping(value = "/findByNombreSDCategoria/{categoria}", method = RequestMethod.GET)
    public String findByNombreSDCategoria(@PathVariable("categoria") String nombreCategoria) {
        return productoService.findByCategoria_Categoria(nombreCategoria).toString();
    }

    @RequestMapping(value = "/findByNombreSD2Categoria/{categoria}/{updateDate}", method = RequestMethod.GET)
    public String findByNombreSD2Categoria(@PathVariable("categoria") String nombreCategoria
            , @PathVariable("updateDate") String updateDate) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date parseDate = null;
        try {
            parseDate = sdf.parse(updateDate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productoService.findByCategoria_CategoriaAndDateUpdate_LessThan(nombreCategoria
                , new Timestamp(parseDate.getTime())).toString();

    }

    @RequestMapping(value = "/findAllPagination/{index}", method = RequestMethod.GET)
    public String findAll(@PathVariable("index") int index) {
        Page<Producto> page = productoService.findAll(new PageRequest(index - 1, ITEMS_PER_PAGE, Direction.ASC, "rid"));
        return page.getContent().toString();
    }

    /**
     * Ordernarlos de forma ASC "rid","etc..."
     *
     * @param nombreCategoria
     * @param index
     * @return
     */
    @RequestMapping(value = "/findAllPagination2/{nombreCategoria}/{index}", method = RequestMethod.GET)
    public String findAll(@PathVariable("nombreCategoria") String nombreCategoria, @PathVariable("index") int index) {
        Page<Producto> page = productoService.findByCategoria_Categoria(nombreCategoria, new PageRequest(index - 1, ITEMS_PER_PAGE, Direction.ASC, "rid"));
        return page.getContent().toString();
    }


    @RequestMapping(value = "/savePk", method = RequestMethod.GET)
    public String savePk() {

        Producto producto = new Producto();
        producto.setNombreProducto("Papa");
        producto.setDateUpdate(new Timestamp(new Date().getTime()));
        producto.setCategoria(new Categoria(1l));
        productoService.save(producto);

        Vendedor vendedor = new Vendedor();
        vendedor.setNombre("Alfredo");
        vendedorService.save(vendedor);

        Vendedor vendedor2 = new Vendedor();
        vendedor2.setNombre("Pichardo");
        vendedorService.save(vendedor2);

        Factura factura = new Factura();
        factura.setProducto(producto);
        factura.setVendedor(vendedor);
        //Campos extras...
        //......

        Factura factura2 = new Factura();
        factura2.setProducto(producto);
        factura2.setVendedor(vendedor2);
        //Campos extras...
        //......

        vendedor.getFacturarSet().add(factura);
        vendedor.getFacturarSet().add(factura2);

        vendedorService.save(vendedor);

        return "success";
    }

}
