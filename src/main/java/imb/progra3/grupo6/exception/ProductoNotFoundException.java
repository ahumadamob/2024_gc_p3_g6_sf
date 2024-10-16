package imb.progra3.grupo6.exception;

public class ProductoNotFoundException extends RuntimeException {
	public ProductoNotFoundException(String message) {
		super("No es posible realizar la petición porque: "+message);
	}
}
