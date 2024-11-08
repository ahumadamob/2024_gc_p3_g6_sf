package imb.progra3.grupo6.service;
import java.util.List;

import imb.progra3.grupo6.entity.DetalleCarrito;
import jakarta.persistence.EntityNotFoundException;

public interface IDetalleCarritoService {
    List<DetalleCarrito> getAll();
    DetalleCarrito getById(Long id);
    DetalleCarrito save(DetalleCarrito detalleCarrito);
    void delete(Long id);
    boolean exists(Long id);
    void removerProducto(Long detalleCarritoId, Long productoId) throws EntityNotFoundException;

}

