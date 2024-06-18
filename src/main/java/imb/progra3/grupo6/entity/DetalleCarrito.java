package imb.progra3.grupo6.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class DetalleCarrito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long carrito_id;
	private long producto_id;
	private Integer cantidad;
	private double precioUnitario;
	private double subtotal;
	

	@ManyToOne
	private OrdenCompra ordenCompra;
	
	
	public DetalleCarrito() {
		
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCarrito_id() {
		return carrito_id;
	}
	public void setCarrito_id(Long carrito_id) {
		this.carrito_id = carrito_id;
	}
	public long getProducto_id() {
		return producto_id;
	}
	public void setProducto_id(long producto_id) {
		this.producto_id = producto_id;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	

}
