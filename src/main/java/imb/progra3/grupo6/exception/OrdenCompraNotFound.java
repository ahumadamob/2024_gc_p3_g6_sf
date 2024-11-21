package imb.progra3.grupo6.exception;

public class OrdenCompraNotFound extends RuntimeException {
	  public OrdenCompraNotFound(Long id) {
	        super("Orden de compra con ID " + id + " no fue encontrado.");
	    }
	    
	    public OrdenCompraNotFound(String mensaje) {
	        super(mensaje);
	    }
}
