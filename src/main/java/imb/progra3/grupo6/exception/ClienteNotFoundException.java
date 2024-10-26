package imb.progra3.grupo6.exception;

public class ClienteNotFoundException extends RuntimeException {
    public ClienteNotFoundException(Long id) {
        super("Cliente con ID " + id + " no fue encontrado.");
    }
    
    public ClienteNotFoundException(String mensaje) {
        super(mensaje);
    }
}
