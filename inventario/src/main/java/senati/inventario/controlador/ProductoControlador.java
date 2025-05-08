package senati.inventario.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senati.inventario.modelo.Producto;
import senati.inventario.servicios.ProductoServicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//http://localhost:8080/inventario-app

@RequestMapping("inventario-app")
@CrossOrigin(value = "http://localhost:4200")

public class ProductoControlador {
    @Autowired
    private ProductoServicio productoServicio;

    //http://localhost:8080/inventario-app/productos
    @GetMapping("/productos")
    public List<Producto> obtenerProductos(){
        List<Producto> productos = this.productoServicio.listarProductos();
        return productos;
    }

    @PostMapping("/productos")
    public Producto agregarProducto(@RequestBody Producto producto){
        return this.productoServicio.guardarProducto(producto);
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProductoporId(@PathVariable int id){
        Producto producto = this.productoServicio.buscarProductoporId(id);
        return ResponseEntity.ok(producto);
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable int id, @RequestBody Producto actproducto){
        Producto producto = this.productoServicio.buscarProductoporId(id);
        producto.setNombreProducto(actproducto.getNombreProducto());
        producto.setCategoria(actproducto.getCategoria());
        producto.setStock(actproducto.getStock());
        producto.setProveedor(actproducto.getProveedor());
        producto.setPrecio(actproducto.getPrecio());
        this.productoServicio.guardarProducto(producto);
        return ResponseEntity.ok(producto);
    }
    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarProducto(@PathVariable int id){
        Producto producto = productoServicio.buscarProductoporId(id);
        this.productoServicio.eliminarProductoporId(producto.getIdProducto());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Producto eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
