package imb.progra3.grupo6.service;

import java.util.List;

import imb.progra3.grupo6.entity.Producto;

public interface IProductoService {
    List<Producto> getAll();
    Producto getById(Long id);
    Producto save(Producto producto);
    void delete(Long id);
    boolean exists(Long id);
}
