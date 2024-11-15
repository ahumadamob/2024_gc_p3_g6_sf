package imb.progra3.grupo6.service;

import java.time.LocalDate;
import java.util.List;

import imb.progra3.grupo6.entity.Producto;

public interface IProductoService {
    List<Producto> getAll();
    Producto getById(Long id);
    Producto save(Producto producto);
    void delete(Long id);
    boolean exists(Long id);
	void marcarComoDescontinuado(Long id, String motivo);
	List<Producto> buscarPorCategoria(String categoria);
	List<Producto> buscarPorFotoProducto(String url_imagen_producto);
	List<Producto> buscarPorFechaReposicionEntre(LocalDate fechaInicial, LocalDate fechaFinal);
	List<Producto> buscarPorEstadoDeOrden(String estado);
}
