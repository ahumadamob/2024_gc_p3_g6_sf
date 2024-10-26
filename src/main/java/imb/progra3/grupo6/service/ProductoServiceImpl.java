package imb.progra3.grupo6.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.progra3.grupo6.entity.Producto;
import imb.progra3.grupo6.exception.ProductoNotFoundException;
import imb.progra3.grupo6.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;
	

	@Override
	public List<Producto> getAll() {
		return  productoRepository.findAll();
	}

	@Override
	public Producto getById(Long id) {
		
		return productoRepository.findById(id).orElseThrow(() -> new ProductoNotFoundException("No se halló un producto con el id {0}"));
	}

	@Override
	public Producto save(Producto producto) {
		return productoRepository.save(producto);
		
	}

	@Override
	public void delete(Long id) {
		productoRepository.deleteById(id);
		
	}

	@Override
	public boolean exists(Long id) {
		return id == null ? false:productoRepository.existsById(id);
		
	}
	
	public List<Producto> buscarPorCategoria(String categoria){
		return productoRepository.findByCategoriaContaining(categoria);
	}
	
	public List<Producto> buscarPorFotoProducto(String url_imagen_producto){
		return productoRepository.findByUrlImagenProductoContaining(url_imagen_producto);
	}
	
	public List<Producto> buscarPorFechaReposicionEntre(LocalDate fechaInicial, LocalDate fechaFinal){
		return productoRepository.findByFechaReposicionBetween(fechaInicial, fechaFinal);
	}
	
	public List<Producto> buscarPorEstadoDeOrden(String estado){
		return productoRepository.findByOrdenesCompra_OrdenCompra_EstadoDeOrden(estado);
	}
	
	/*public String buscarStock(String nombreProducto) {
		return productoRepository.findStockByNombre(nombreProducto);
	}*/

}
