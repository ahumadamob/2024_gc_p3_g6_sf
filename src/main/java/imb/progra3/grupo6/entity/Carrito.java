package imb.progra3.grupo6.entity;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import imb.progra3.grupo6.entity.Cliente; 

@Entity

public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@OneToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

	@ManyToOne
    @JoinColumn(name = "cliente_one_to_many_id")
    private Cliente clienteOneToMany;

    private LocalDate fechaCreacion;
    private String estado;
    private String metodoEnvioPreferido;


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
    
    
}
