package senati.inventario.servicios;

import senati.inventario.modelo.Producto;

import java.util.List;

public interface IProductoServicio {

    public List<Producto>listarProductos();

    public  Producto buscarProductoporId(Integer idProducto);

    public Producto guardarProducto(Producto producto);

    public  void eliminarProductoporId(Integer idProducto);
}
