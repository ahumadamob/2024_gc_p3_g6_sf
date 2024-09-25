package imb.progra3.grupo6.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobaExceptionHandler {
	
	@ExceptionHandler(ProductoNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ResponseEntity<String> handleProductoNotFoundException(ProductoNotFoundException producto){
		return new ResponseEntity<String>(producto.getMessage(),HttpStatus.NOT_FOUND);
	}
		
}
