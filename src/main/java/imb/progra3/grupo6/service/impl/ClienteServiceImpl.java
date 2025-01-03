package imb.progra3.grupo6.service.impl;

import imb.progra3.grupo6.entity.Cliente;
import imb.progra3.grupo6.repository.ClienteRepository;
import imb.progra3.grupo6.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public boolean exists(Long id) {
        return clienteRepository.existsById(id);
    }
    
    @Override
    public List<Cliente> findByApellidoPrefix(String letra) {
        return clienteRepository.findByApellidoStartingWith(letra);
    }
    
    @Override
    public boolean activarCliente(Long id) {
        return clienteRepository.findById(id).map(cliente -> {
            cliente.setActivo(true);
            clienteRepository.save(cliente);
            return true;
        }).orElse(false);
    }

    
}
