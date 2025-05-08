package senati.inventario.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import senati.inventario.modelo.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {

}
