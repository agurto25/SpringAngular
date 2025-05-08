package senati.inventario.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senati.inventario.modelo.Producto;
import senati.inventario.repositorio.ProductoRepositorio;

import java.util.List;
@Service

public class ProductoServicio implements IProductoServicio{

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Override
    public List<Producto> listarProductos() {
        return this.productoRepositorio.findAll();

    }

    @Override
    public Producto buscarProductoporId(Integer idProducto) {
        Producto producto = this.productoRepositorio.findById(idProducto).orElse(null);
        return producto;
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return this.productoRepositorio.save(producto);
    }

    @Override
    public void eliminarProductoporId(Integer idProducto) {
        this.productoRepositorio.deleteById(idProducto);
    }
}
