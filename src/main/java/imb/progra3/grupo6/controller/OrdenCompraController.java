package imb.progra3.grupo6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ResponseEntity<APIResponse<List<OrdenCompra>>> showAllProducts() {
		
		List<OrdenCompra> ordenCompra= ordenCompraService.getAll();
		return ordenCompra.isEmpty()? ResponseUtil.notFound("No hay órdenes de compra para mostrar.") : ResponseUtil.success(ordenCompra);
	}

}
