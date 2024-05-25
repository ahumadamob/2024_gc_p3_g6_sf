package imb.progra3.grupo6.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	 private String apellido;
	 private String nombre;
	 private String correoElectronico;
	 private String direccionEnvio;
	 private String numeroTelefono;
	 
	 
	    
	    public Cliente() {}
	    
	    
	    
	
	    
	    
	    
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
	    
	    
	    
}

