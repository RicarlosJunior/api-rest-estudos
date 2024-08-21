package rest.api.adv.controller.exception;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private final Logger logger  = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> handle(Throwable throwable){
		var message = "Ocorreu uma exceção inesperada!";
	    logger.error(message, throwable);
		return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<String> handleIllegalArgumentException(BusinessException businessException){
		return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
	}
}
