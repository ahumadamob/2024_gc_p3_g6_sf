package imb.progra3.grupo6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import imb.progra3.grupo6.entity.Producto;
import java.util.List;
import java.time.LocalDate;




@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
	List<Producto> findByCategoriaContaining(String categoria);
	List<Producto> findByUrlImagenProductoContaining(String urlImagenProducto);
	List<Producto> findByFechaReposicionBetween(LocalDate fechaInicial, LocalDate fechaFinal);
	List<Producto> findByOrdenesCompra_OrdenCompra_EstadoDeOrden(String estado);
	/*Necesito dtos para que esto funcione, puede devolver más de un resultado
	 * @Query("Select p.nombre, p.stock FROM Producto p Where nombre like %:nombre%")
	String findStockByNombre(String nombre);*/

}
