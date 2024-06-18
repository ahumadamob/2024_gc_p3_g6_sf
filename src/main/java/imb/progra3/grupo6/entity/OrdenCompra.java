package imb.progra3.grupo6.entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class OrdenCompra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long cliente_id;
	private LocalDate fechaDeOrden;
	private String estadoDeOrden;
	private double Total;
	private String metodoDePago;
	private String metodoDeEnvio;
	private LocalDate fechaEntregaEstimada;
	private String detalleSeguimiento;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<DetalleCarrito> detalleCarritoId;
	
	
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
}
