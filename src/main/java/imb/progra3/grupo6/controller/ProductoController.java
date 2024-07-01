package imb.progra3.grupo6.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import imb.progra3.grupo6.service.IProductoService;
import imb.progra3.grupo6.util.*;
import imb.progra3.grupo6.entity.Producto;


@RestController("/")
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/productos")
	public ResponseEntity<APIResponse<List<Producto>>> showAllProducts() {
		
		List<Producto> productos= productoService.getAll();
		return productos.isEmpty()? ResponseUtil.notFound("No hay productos para mostrar.") : ResponseUtil.success(productos);
	}
	
	@GetMapping("/productos/{id}")
	public ResponseEntity<APIResponse<Producto>> showProductByID(@PathVariable Long id) {
		
		return productoService.exists(id)? ResponseUtil.success(productoService.getById(id)):ResponseUtil.notFound("No se encontró el producto con id {0}.", id);
	}
	
	@PostMapping("/productos")
	public ResponseEntity<APIResponse<Producto>> crearProducto(@RequestBody Producto producto){
		
		return productoService.exists(producto.getId())? ResponseUtil.badRequest("El producto ya existe con id {0}",producto.getId()) : ResponseUtil.success(productoService.save(producto)) ;
	}
	
	
	@PutMapping("/productos/{id}")
	public ResponseEntity<APIResponse<Producto>> modificarProducto(@RequestBody Producto producto){
		
		
		return productoService.exists(producto.getId())? ResponseUtil.success(productoService.save(producto)) : ResponseUtil.notFound("No se encontró el producto que desea modificar con id {0}",producto.getId()) ;
	}
	
	@DeleteMapping("/productos/{id}")
	public ResponseEntity<APIResponse<Producto>> deleteProducto(@PathVariable Long id) {
		
		return productoService.exists(id) ? ResponseUtil.successDeleted("El producto con id {0} ha sido borrado.", id) : ResponseUtil.badRequest("No pudo ser borrado el producto con id {0}", id) ;
	}
	
	

}
