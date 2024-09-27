package imb.progra3.grupo6.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List; 
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotNull;

@Entity
public class Cliente {

	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	 @NotEmpty(message = "El apellido no puede estar vacío")
	 @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
	 private String apellido;

	 @NotEmpty(message = "El nombre no puede estar vacío")
	 @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
	 private String nombre;

	 @NotEmpty(message = "El correo electrónico no puede estar vacío")
	 @Email(message = "Debe ser un correo electrónico válido")
	 private String correoElectronico;

	 @NotEmpty(message = "La dirección de envío no puede estar vacía")
	 @Size(min = 5, max = 100, message = "La dirección de envío debe tener entre 5 y 100 caracteres")
	 private String direccionEnvio;

	 @NotEmpty(message = "El número de teléfono no puede estar vacío")
	 @Pattern(regexp = "\\d{10,15}", message = "El número de teléfono debe tener entre 10 y 15 dígitos")
	 private String numeroTelefono;
	 
	@OneToOne(mappedBy = "cliente")
	
    private Carrito carrito;

    @OneToMany(mappedBy = "cliente")
    private List<Carrito> carritos;
	    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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