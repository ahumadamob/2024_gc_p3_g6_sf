package imb.progra3.grupo6.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "producto")
public class Producto {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_producto")
	    private Long idProducto;
	 	
	 	@Column (name= "descripcion")
	 	private String descripcion;

	 	@Column(name = "precio")
	 	private Long precio;
	 	
	 	@Column(name = "stock")
	 	private String stock;
	 	
	 	@Column(name = "categoria")
	 	private String categoria;
	 	
	 	@Column(name = "detalles_tecnicos")
	    private String detalles_tecnicos;
	 	
	 	@Column(name = "url_imagen_producto")
	 	private String url_imagen_producto;
	 	
	    @Column(name = "fecha_reposicion")
	    private LocalDate fecha_reposicion;
	    
	    /*
		@Column(name = "proveedor")
	 	private String proveedor;
	    

	    @Column(name = "idcliente")
	    private Long idCliente;

	    @Column(name = "idcarrito")
	    private Long idCarrito;*/

		public Producto(Long idProducto, String descripcion, Long precio, String stock, String categoria,
				String detalles_tecnicos, String url_imagen_producto, LocalDate fecha_reposicion) {
			super();
			this.idProducto = idProducto;
			this.descripcion = descripcion;
			this.precio = precio;
			this.stock = stock;
			this.categoria = categoria;
			this.detalles_tecnicos = detalles_tecnicos;
			this.url_imagen_producto = url_imagen_producto;
			this.fecha_reposicion = fecha_reposicion;
		}

		public Long getIdProducto() {
			return idProducto;
		}

		public void setIdProducto(Long idProducto) {
			this.idProducto = idProducto;
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
