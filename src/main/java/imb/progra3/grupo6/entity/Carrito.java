package imb.progra3.grupo6.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;

@Entity
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cliente;
    private LocalDate fechaCreacion;
    private String estado;
    private String metodoEnvioPreferido;
    
    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleCarrito> detalles;
    
    
    

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Cliente getClienteOneToMany() {
        return clienteOneToMany;
    }

    public void setClienteOneToMany(Cliente clienteOneToMany) {
        this.clienteOneToMany = clienteOneToMany;
    }

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMetodoEnvioPreferido() {
		return metodoEnvioPreferido;
	}
	public void setMetodoEnvioPreferido(String metodoEnvioPreferido) {
		this.metodoEnvioPreferido = metodoEnvioPreferido;
	}
    

	public List<DetalleCarrito> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleCarrito> detalles) {
        this.detalles = detalles;
    }



