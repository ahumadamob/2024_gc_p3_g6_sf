package imb.progra3.grupo6.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class OrdenCompra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "El cliente_id no puede ser nulo")
    private Long cliente_id;
    
    @NotNull(message = "La fecha de orden no puede ser nula")
    private LocalDate fechaDeOrden;
    
    @NotBlank(message = "El estado de la orden no puede estar en blanco")
    private String estadoDeOrden;
    
    @Positive(message = "El total debe ser un valor positivo")
    @DecimalMin(value = "0.0", inclusive = false, message = "El total debe ser mayor que 0")
    private double Total;
    
    @NotBlank(message = "El método de pago no puede estar en blanco")
    private String metodoDePago;
    
    @NotBlank(message = "El método de envío no puede estar en blanco")
    private String metodoDeEnvio;
    
    @Future(message = "La fecha de entrega estimada debe estar en el futuro")
    private LocalDate fechaEntregaEstimada;
    
    @NotBlank(message = "El detalle de seguimiento no puede estar en blanco")
    private String detalleSeguimiento;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @NotEmpty(message = "El detalle del carrito no puede estar vacío")
    private Set<DetalleCarrito> detalleCarrito;
	
	@OneToMany(mappedBy = "ordenCompra")
	private Set<ProductoOrdenCompra> productos = new HashSet<>();	    
 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(Long cliente_id) {
		this.cliente_id = cliente_id;
	}
	public LocalDate getFechaDeOrden() {
		return fechaDeOrden;
	}
	public void setFechaDeOrden(LocalDate fechaDeOrden) {
		this.fechaDeOrden = fechaDeOrden;
	}
	public String getEstadoDeOrden() {
		return estadoDeOrden;
	}
	public void setEstadoDeOrden(String estadoDeOrden) {
		this.estadoDeOrden = estadoDeOrden;
	}
	public double getTotal() {
		return Total;
	}
	public void setTotal(double total) {
		Total = total;
	}
	public String getMetodoDePago() {
		return metodoDePago;
	}
	public void setMetodoDePago(String metodoDePago) {
		this.metodoDePago = metodoDePago;
	}
	public String getMetodoDeEnvio() {
		return metodoDeEnvio;
	}
	public void setMetodoDeEnvio(String metodoDeEnvio) {
		this.metodoDeEnvio = metodoDeEnvio;
	}
	public LocalDate getFechaEntregaEstimada() {
		return fechaEntregaEstimada;
	}
	public void setFechaEntregaEstimada(LocalDate fechaEntregaEstimada) {
		this.fechaEntregaEstimada = fechaEntregaEstimada;
	}
	public String getDetalleSeguimiento() {
		return detalleSeguimiento;
	}
	public void setDetalleSeguimiento(String detalleSeguimiento) {
		this.detalleSeguimiento = detalleSeguimiento;
	}	

    public Set<ProductoOrdenCompra> getProductos() {
        return productos;
    }

    public void setProductos(Set<ProductoOrdenCompra> productos) {
        this.productos = productos;
    }
	public Set<DetalleCarrito> getDetalleCarrito() {
		return detalleCarrito;
	}
	public void setDetalleCarrito(Set<DetalleCarrito> detalleCarrito) {
		this.detalleCarrito = detalleCarrito;
	}
    
    
    
    
}