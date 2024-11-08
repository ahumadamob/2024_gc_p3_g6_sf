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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
public class Producto extends BaseEntity {
	
	 	
	 	
	    @NotEmpty(message = "El nombre no puede estar vacío.")
	    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres.")
	 	private String nombre;
	 	
	 	@Size(max = 500, message = "La descripción no debe exceder los 500 caracteres.")
	 	private String descripcion;
	 	
	    @NotNull(message = "El precio no puede ser nulo.")
	    @Positive(message = "El precio debe ser un valor positivo.")
	 	private Double precio;
	 	
	   // @NotNull(message = "El stock no puede ser nulo.")
	    @PositiveOrZero(message = "El stock debe ser un valor positivo.")
	   // @Pattern(regexp = "\\d+", message = "El stock debe ser un número entero.")
	 	private int stock;
	 	
	    @NotEmpty(message = "La categoría no puede estar vacía.")
	    @Size(min = 3, max = 50, message = "La categoría debe tener entre 3 y 50 caracteres.")
	 	private String categoria;
	 	
	 	@Size(max = 1000, message = "Los detalles técnicos no deben exceder los 1000 caracteres.")
	 	private String detallesTecnicos;
	 	
	    @NotNull(message = "La URL de la imagen no puede ser nula.")
	    @Pattern(regexp = "(http(s?):)([/|.|\\w|\\s|-])*\\.(?:jpg|gif|png)", 
	             message = "Debe ser una URL válida de imagen (jpg, gif, png).")
	 	private String urlImagenProducto;
	 	
	   private LocalDate fechaReposicion;
	   
	   @OneToMany(mappedBy = "producto")
	   @JsonManagedReference
	    private Set<ProductoOrdenCompra> ordenesCompra = new HashSet<>();
	   
	  
	   private boolean descontinuado;
	   
	   private String motivoDescontinuacion;

	    
	    public boolean isDescontinuado() {
	        return descontinuado;
	    }

	    public void setDescontinuado(boolean descontinuado) {
	        this.descontinuado = descontinuado;
	    }

	    public String getMotivoDescontinuacion() {
	        return motivoDescontinuacion;
	    }

	    public void setMotivoDescontinuacion(String motivoDescontinuacion) {
	        this.motivoDescontinuacion = motivoDescontinuacion;
	    }

	    
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

		public int getStock() {
			return stock;
		}

		public void setStock(int stock) {
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
