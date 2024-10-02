package imb.progra3.grupo6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import imb.progra3.grupo6.entity.OrdenCompra;
import imb.progra3.grupo6.exception.OrdenCompraNotFound;
import imb.progra3.grupo6.service.IOrdenCompraService;
import imb.progra3.grupo6.util.APIResponse;
import imb.progra3.grupo6.util.ResponseUtil;

@RestController
public class OrdenCompraController {
	@Autowired
	private IOrdenCompraService ordenCompraService;
	
	
	@GetMapping("/ordenesCompra")
	public ResponseEntity<APIResponse<List<OrdenCompra>>> showAllOrders() {
		
		List<OrdenCompra> ordenCompra= ordenCompraService.getAll();
		return ordenCompra.isEmpty()? ResponseUtil.notFound("No hay órdenes de compra para mostrar.") : ResponseUtil.success(ordenCompra);
	}


	@GetMapping("/ordenesCompra/{id}")
	public ResponseEntity<OrdenCompra> showOrderByID(@PathVariable Long id) {
    
    OrdenCompra ordenCompra = ordenCompraService.getById(id);
    	if (ordenCompra == null) {
    	    throw new OrdenCompraNotFound(id);
   	 	}
    	return ResponseEntity.ok(ordenCompra);
		}


	@PostMapping("/ordenesCompra")
	public ResponseEntity<APIResponse<OrdenCompra>> crearOrden(@RequestBody OrdenCompra ordenCompra){
		
		return ordenCompraService.exists(ordenCompra.getId())? ResponseUtil.badRequest("La orden de compra ya existe con id {0}",ordenCompra.getId()) : ResponseUtil.success(ordenCompraService.save(ordenCompra)) ;
	}

	@PutMapping("/ordenesCompra/{id}")
	public ResponseEntity<OrdenCompra> modificarOrden(@PathVariable Long id, @RequestBody OrdenCompra ordenCompraDetails) {
		if (!ordenCompraService.exists(id)) {
			throw new OrdenCompraNotFound(id);
		}
    
    
    	ordenCompraDetails.setId(id);
    
    
    	OrdenCompra updatedOrdenCompra = ordenCompraService.save(ordenCompraDetails);
    
    	return ResponseEntity.ok(updatedOrdenCompra);
	}
	
	@DeleteMapping("/ordenesCompra/{id}")
	public ResponseEntity<Void> deleteOrden(@PathVariable Long id) {
		
		if (!ordenCompraService.exists(id)) {
			throw new OrdenCompraNotFound(id);
		}
		
		
		ordenCompraService.delete(id);
		
		return ResponseEntity.noContent().build();
	}


	@GetMapping("/buscarMetodoDePago")
	public ResponseEntity<List<OrdenCompra>> searchOrdenesByMetodoDePago(@RequestParam String metodoDePago) {
		List<OrdenCompra> ordenesCompra = ordenCompraService.findByMetodoDePago(metodoDePago);
		
		if (ordenesCompra.isEmpty()) {
			throw new OrdenCompraNotFound("No se encontraron órdenes de compra con el método de pago: " + metodoDePago);
		}
		
		return ResponseEntity.ok(ordenesCompra);
	}


}
