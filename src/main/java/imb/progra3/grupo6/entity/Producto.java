package imb.progra3.grupo6.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Producto {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 	
	 	private String nombre;

	 	private String descripcion;

	 	private Double precio;
	 	
	 	private String stock;
	 	
	 	private String categoria;
	 	
	 	private String detallesTecnicos;
	 	
	 	private String urlImagenProducto;
	 	
	   private LocalDate fechaReposicion;
	   
	   @OneToMany(mappedBy = "producto")
	   @JsonManagedReference
	    private Set<ProductoOrdenCompra> ordenesCompra = new HashSet<>();

	    
	    /*
		@Column(name = "proveedor")
	 	private String proveedor;
	    

	    @Column(name = "idcliente")
	    private Long idCliente;

	    @Column(name = "idcarrito")
	    private Long idCarrito;*/

	   
		public Producto() {
			 
		}
		 
		public Producto(String nombre, Double precio) {
		        this.nombre = nombre;
		        this.precio = precio;
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

		public Double getPrecio() {
			return precio;
		}

		public void setPrecio(Double precio) {
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
			return detallesTecnicos;
		}

		public void setDetalles_tecnicos(String detalles_tecnicos) {
			this.detallesTecnicos = detalles_tecnicos;
		}

		public String getUrl_imagen_producto() {
			return urlImagenProducto;
		}

		public void setUrl_imagen_producto(String url_imagen_producto) {
			this.urlImagenProducto = url_imagen_producto;
		}

		public LocalDate getFecha_reposicion() {
			return fechaReposicion;
		}

		public void setFecha_reposicion(LocalDate fecha_reposicion) {
			this.fechaReposicion = fecha_reposicion;
		}
	   
		public String getNombre() {
		        return nombre;
		    }

		public void setNombre(String nombre) {
		        this.nombre = nombre;
		    }
		
		 public Set<ProductoOrdenCompra> getOrdenesCompra() {
		        return ordenesCompra;
		    }

		 public void setOrdenesCompra(Set<ProductoOrdenCompra> ordenesCompra) {
		        this.ordenesCompra = ordenesCompra;
		    }

	    

}
