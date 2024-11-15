package imb.progra3.grupo6.dto;

import jakarta.validation.constraints.NotEmpty;

public class DescontinuarProducto {
	@NotEmpty(message = "El motivo de la descontinuación no puede estar vacío.")
    private String motivo;

    // Constructor, getters y setters
    public DescontinuarProducto() {
    }

    public DescontinuarProducto(String motivo) {
        this.motivo = motivo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
