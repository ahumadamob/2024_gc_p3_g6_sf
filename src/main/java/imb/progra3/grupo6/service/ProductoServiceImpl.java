package imb.progra3.grupo6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.progra3.grupo6.entity.Producto;
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
		
		return productoRepository.findById(id).orElse(null);
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

}
