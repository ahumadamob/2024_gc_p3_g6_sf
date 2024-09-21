package imb.progra3.grupo6.service;

import imb.progra3.grupo6.entity.Cliente;
import java.util.List;

public interface IClienteService {
    List<Cliente> getAll();
    Cliente getById(Long id);
    Cliente save(Cliente cliente);
    void delete(Long id);
    boolean exists(Long id);
 // Método mágico para buscar clientes por prefijo de apellido
    List<Cliente> findByApellidoPrefix(String letra);
}
