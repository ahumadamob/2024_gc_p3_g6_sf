package imb.progra3.grupo6.service;
import java.util.List;

import imb.progra3.grupo6.entity.OrdenCompra;

public interface IOrdenCompraService {
    List<OrdenCompra> getAll();
    OrdenCompra getById(Long id);
    OrdenCompra save(OrdenCompra ordenCompra);
    void delete(Long id);
    boolean exists(Long id);
}
