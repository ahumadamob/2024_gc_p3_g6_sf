package imb.progra3.grupo6.controller;

import imb.progra3.grupo6.entity.Cliente;
import imb.progra3.grupo6.exception.ClienteNotFoundException;
import imb.progra3.grupo6.service.IClienteService;
import imb.progra3.grupo6.util.APIResponse;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;
    
    public ClienteController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
       
         Cliente cliente = clienteService.getById(id);
        if (cliente == null) {
            throw new ClienteNotFoundException(id);
        }
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@Valid @RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.save(cliente);
        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/activar")
    public ResponseEntity<String> activarCliente(@PathVariable Long id) {
        boolean activado = clienteService.activarCliente(id);
        if (!activado) {
            throw new ClienteNotFoundException(id); 
        }
        return ResponseEntity.ok("Cliente activado con éxito");
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente clienteDetails) {
        if (!clienteService.exists(id)) {
            throw new ClienteNotFoundException(id);
        }
        clienteDetails.setId(id);
        Cliente updatedCliente = clienteService.save(clienteDetails);
        return ResponseEntity.ok(updatedCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        
        if (!clienteService.exists(id)) {
            throw new ClienteNotFoundException(id);
        }
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    

    // Endpoint del método mágico para buscar por prefijo de apellido
    @GetMapping("/buscarApellido")
    public ResponseEntity<List<Cliente>> searchClientesByApellidoPrefix(@RequestParam String letra) {
        List<Cliente> clientes = clienteService.findByApellidoPrefix(letra);
        if (clientes.isEmpty()) {
            //return ResponseEntity.noContent().build();
        	throw new ClienteNotFoundException("No se encontraron clientes con la letra inicial de su apellido: " + letra);
        }
        return ResponseEntity.ok(clientes);
    }
}
