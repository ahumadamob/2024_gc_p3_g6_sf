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
	public ResponseEntity<APIResponse<OrdenCompra>> showOrderByID(@PathVariable Long id) {
		
		return ordenCompraService.exists(id)? ResponseUtil.success(ordenCompraService.getById(id)):ResponseUtil.notFound("No se encontró la orden de compra con id {0}.", id);
	}

	@PostMapping("/ordenesCompra")
	public ResponseEntity<APIResponse<OrdenCompra>> crearOrden(@RequestBody OrdenCompra ordenCompra){
		
		return ordenCompraService.exists(ordenCompra.getId())? ResponseUtil.badRequest("La orden de compra ya existe con id {0}",ordenCompra.getId()) : ResponseUtil.success(ordenCompraService.save(ordenCompra)) ;
	}

	@PutMapping("/ordenesCompra/{id}")
	public ResponseEntity<APIResponse<OrdenCompra>> modificarOrden(@RequestBody OrdenCompra ordenCompra){
		
		
		return ordenCompraService.exists(ordenCompra.getId())? ResponseUtil.success(ordenCompraService.save(ordenCompra)) : ResponseUtil.notFound("No se encontró la orden que desea modificar con id {0}",ordenCompra.getId()) ;
	}
	
	@DeleteMapping("/ordenesCompra/{id}")
	public ResponseEntity<APIResponse<OrdenCompra>> deleteOrden(@PathVariable Long id) {
		
		return ordenCompraService.exists(id) ? ResponseUtil.successDeleted("La orden de compra con id {0} ha sido borrado.", id) : ResponseUtil.badRequest("No pudo ser borrada la orden con id {0}", id) ;
	}


}
