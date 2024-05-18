package imb.progra3.grupo6.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producto {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 	
	 	private String descripcion;

	 	private Long precio;
	 	
	 	private String stock;
	 	
	 	private String categoria;
	 	
	 	private String detalles_tecnicos;
	 	
	 	private String url_imagen_producto;
	 	
	   private LocalDate fecha_reposicion;
	    
	    /*
		@Column(name = "proveedor")
	 	private String proveedor;
	    

	    @Column(name = "idcliente")
	    private Long idCliente;

	    @Column(name = "idcarrito")
	    private Long idCarrito;*/

	   
		public Producto() {
			 
		}

		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public Long getPrecio() {
			return precio;
		}

		public void setPrecio(Long precio) {
			this.precio = precio;
		}

		public String getStock() {
			return stock;
		}

		public void setStock(String stock) {
			this.stock = stock;
		}

		public String getCategoria() {
			return categoria;
		}

		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}

		public String getDetalles_tecnicos() {
			return detalles_tecnicos;
		}

		public void setDetalles_tecnicos(String detalles_tecnicos) {
			this.detalles_tecnicos = detalles_tecnicos;
		}

		public String getUrl_imagen_producto() {
			return url_imagen_producto;
		}

		public void setUrl_imagen_producto(String url_imagen_producto) {
			this.url_imagen_producto = url_imagen_producto;
		}

		public LocalDate getFecha_reposicion() {
			return fecha_reposicion;
		}

		public void setFecha_reposicion(LocalDate fecha_reposicion) {
			this.fecha_reposicion = fecha_reposicion;
		}
	   
		


	    

}
