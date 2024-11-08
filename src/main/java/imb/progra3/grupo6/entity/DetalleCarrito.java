package imb.progra3.grupo6.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import java.util.Optional;


@Entity
public class DetalleCarrito extends BaseEntity{
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id")
    private Producto producto;
	
	private Integer cantidad;
	private double precioUnitario;
	private double subtotal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "carrito_id", nullable = false)
	
	private Carrito carrito;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orden_compra_id")
    private OrdenCompra ordenCompra; 


	
	public Producto getProducto_id() {
		return producto;

	}
	public void setProducto(Producto producto) {
		this.producto = producto;
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
	
	public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }
    
    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

	public boolean eliminarProducto(Long productoId) {

		if (producto != null && producto.getId().equals(productoId)) {
			this.producto = null;
			return true;
		}
		return false;
	}
    }
