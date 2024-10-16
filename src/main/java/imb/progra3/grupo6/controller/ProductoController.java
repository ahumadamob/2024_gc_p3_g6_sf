package imb.progra3.grupo6.controller;


import java.time.LocalDate;
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
import imb.progra3.grupo6.exception.ProductoNotFoundException;
import imb.progra3.grupo6.repository.ProductoRepository;


@RestController("/")
public class ProductoController {
	
	private IProductoService productoService;
	
	private ProductoRepository productoRepository;
	
	
	public ProductoController(IProductoService productoService, ProductoRepository productoRepository) {
		super();
		this.productoService = productoService;
		this.productoRepository = productoRepository;
	}


	
	@GetMapping("/productos")
	public ResponseEntity<APIResponse<List<Producto>>> showAllProducts() {
		
		List<Producto> productos= productoService.getAll();
		if(productos.isEmpty()) {
			throw new ProductoNotFoundException("No hay productos para mostrar.");
		}
		return ResponseUtil.success(productos);
	}
	
	@GetMapping("/productos/{id}")
	public ResponseEntity<APIResponse<Producto>> showProductByID(@PathVariable Long id) {
		Producto producto = productoService.getById(id);
		
		return  ResponseUtil.success(producto);
			
	}
	
	@PostMapping("/productos")
	public ResponseEntity<APIResponse<Producto>> crearProducto(@RequestBody Producto producto){
		
		return productoService.exists(producto.getId())? ResponseUtil.success(productoService.save(producto)):
					ResponseUtil.badRequest("El producto ya existe con id {0}",producto.getId());
	}
	
	
	@PutMapping("/productos/{id}")
	public ResponseEntity<APIResponse<Producto>> modificarProducto(@PathVariable Long id, @RequestBody Producto producto) {
	   
	    if (!productoService.exists(id)) {
	        return ResponseUtil.notFound("No se encontró el producto que desea modificar con id {0}", id);
	    }

	    if (!producto.getId().equals(id)) {
	        return ResponseUtil.badRequest("El ID del producto en la URL no coincide con el ID del cuerpo del producto.");
	    }

	    Producto productoModificado = productoService.save(producto);
	    return ResponseUtil.success(productoModificado);
	}

	
	@DeleteMapping("/productos/{id}")
	public ResponseEntity<APIResponse<Producto>> deleteProducto(@PathVariable Long id) {
		//Corrobora que el producto esté sino lanza la excepción desde el servicio
		productoService.getById(id);
		
		productoService.delete(id);
		
		
		return  ResponseUtil.successDeleted("El producto con id {0} ha sido borrado.", id);
	}
	
	@GetMapping("/productos/categoria/{categoria}")
	public ResponseEntity<APIResponse<List<Producto>>>  showByCategoria(@PathVariable String categoria){
		
		List<Producto> productos = productoRepository.findByCategoriaContaining(categoria);
		
		if(productos.isEmpty()) {
	    	throw new ProductoNotFoundException("No se encontró la categoría.");
	    }
		return ResponseUtil.success(productos);
	}
	
	@GetMapping("/productos/url-imagen/{urlImagenProducto}")
	public ResponseEntity<APIResponse<List<Producto>>> showByUrlImagenProducto(@PathVariable String urlImagenProducto) {
	    List<Producto> productos = productoRepository.findByUrlImagenProductoContaining(urlImagenProducto);
	    
	    if(productos.isEmpty()) {
	    	throw new ProductoNotFoundException("No se encontró imagen del producto.");
	    }
	    
	    return ResponseUtil.success(productos);
	}
	
	@GetMapping("/productos/fecha-reposicion")
	public ResponseEntity<APIResponse<List<Producto>>> showByFechaReposicionBetween(@RequestParam LocalDate fechaInicial, @RequestParam LocalDate fechaFinal) {
		  
		List<Producto> productos = productoRepository.findByFechaReposicionBetween(fechaInicial, fechaFinal);
		    
		    if (productos.isEmpty()) {
		        throw new ProductoNotFoundException("entre las fechas " + fechaInicial + " y " + fechaFinal);
		    }
		    
		    return ResponseUtil.success(productos);
	}
	
	@GetMapping("/productos/estado-orden/{estado}")
	public ResponseEntity<APIResponse<List<Producto>>> showByEstadoOrden(@PathVariable String estado) {
	    List<Producto> productos = productoRepository.findByOrdenesCompra_OrdenCompra_EstadoDeOrden(estado);
	    
	    if (productos.isEmpty()) {
	        throw new ProductoNotFoundException("No se encontraron productos con ese estado de orden.");
	    }
	    
	    return ResponseUtil.success(productos);
	}
	
	/*@GetMapping("/productos/stock/{nombre}")
	public ResponseEntity<APIResponse<String>> showStockByNombre(@PathVariable String nombre) {
	    String stock = productoRepository.findStockByNombre(nombre);
	    
	    return (stock == null || stock.isEmpty()) ? ResponseUtil.badRequest("No se encontró el stock para el producto con ese nombre.") : ResponseUtil.success(stock);
	}*/




	
	

}
