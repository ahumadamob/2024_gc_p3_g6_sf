package imb.progra3.grupo6.Entities;



import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity (name = "productos")
public class Producto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproducto")
    private Long idProducto;

    @Column(name = "idcliente")
    private Long idCliente;

    @Column(name = "idcarrito")
    private Long idCarrito;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "cantidad")
    private String cantidad;

    @Column(name = "precio")
    private Long precio;
    
	public Producto() {
		
	}
	

	public Producto(Long idProducto, Long idCliente, Long idCarrito, LocalDate fecha, String cantidad, Long precio) {
		super();
		this.idProducto = idProducto;
		this.idCliente = idCliente;
		this.idCarrito = idCarrito;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.precio = precio;
	}



	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(Long idCarrito) {
		this.idCarrito = idCarrito;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public Long getPrecio() {
		return precio;
	}

	public void setPrecio(Long precio) {
		this.precio = precio;
	}


	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", idCliente=" + idCliente + ", idCarrito=" + idCarrito
				+ ", fecha=" + fecha + ", cantidad=" + cantidad + ", precio=" + precio + "]";
	}
	
	
	

}
