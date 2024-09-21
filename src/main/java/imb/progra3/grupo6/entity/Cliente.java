package imb.progra3.grupo6.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List; 

@Entity
public class Cliente extends BaseEntity {
    
	
	
	private String apellido;
	private String nombre;
	private String correoElectronico;
	private String direccionEnvio;
	private String numeroTelefono;
	 
	@OneToOne(mappedBy = "cliente")
	
    private Carrito carrito;

    @OneToMany(mappedBy = "cliente")
    private List<Carrito> carritos;
	    
   

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
    

	 public Carrito getCarrito() {
    return carrito;
	}

	public void setCarrito(Carrito carrito) {
    this.carrito = carrito;
	}

      public List<Carrito> getCarritos() {
        return carritos;
    }

    public void setCarritos(List<Carrito> carritos) {
        this.carritos = carritos;
    }    
	    
	    
	    
	    
	    
}