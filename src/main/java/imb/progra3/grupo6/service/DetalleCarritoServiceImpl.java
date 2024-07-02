package imb.progra3.grupo6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.progra3.grupo6.entity.DetalleCarrito;
import imb.progra3.grupo6.repository.DetalleCarritoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleCarritoServiceImpl implements IDetalleCarritoService {

    @Autowired
    private DetalleCarritoRepository detalleCarritoRepository;

    @Override
    public List<DetalleCarrito> getAll() {
        return detalleCarritoRepository.findAll();
    }

    @Override
    public DetalleCarrito getById(Long id) {
        Optional<DetalleCarrito> optional = detalleCarritoRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public DetalleCarrito save(DetalleCarrito detalleCarrito) {
        return detalleCarritoRepository.save(detalleCarrito);
    }

    @Override
    public void delete(Long id) {
        detalleCarritoRepository.deleteById(id);
    }

    @Override
    public boolean exists(Long id) {
        return detalleCarritoRepository.existsById(id);
    }

	
}

