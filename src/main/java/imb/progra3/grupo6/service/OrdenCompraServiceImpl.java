package imb.progra3.grupo6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.progra3.grupo6.entity.OrdenCompra;
import imb.progra3.grupo6.repository.OrdenCompraRepository;

@Service
public class OrdenCompraServiceImpl implements IOrdenCompraService {
	
	@Autowired
	private OrdenCompraRepository ordenCompraRepository;

	@Override
	public List<OrdenCompra> getAll() {
		
		return ordenCompraRepository.findAll();
	}

	@Override
	public OrdenCompra getById(Long id) {
		
		return ordenCompraRepository.findById(id).orElse(null);
	}

	@Override
	public OrdenCompra save(OrdenCompra ordenCompra) {
		
		return ordenCompraRepository.save(ordenCompra);
	}

	@Override
	public void delete(Long id) {
		ordenCompraRepository.deleteById(id);
		
	}

	@Override
	public boolean exists(Long id) {
		
		return id == null ? false : ordenCompraRepository.existsById(id) ;
	}

	@Override
    public List<OrdenCompra> findByMetodoDePago(String metodoDePago) {
        return ordenCompraRepository.findByMetodoDePago(metodoDePago);
    }

}
