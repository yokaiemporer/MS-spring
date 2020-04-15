package Exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@EnableWebMvc
@ControllerAdvice
@RestController
public class CustomizedResponsebebe extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex,WebRequest wr)
	{
		ExceptionResponse resp= new ExceptionResponse(new Date(),ex.getMessage(),wr.getDescription(false));
		return new ResponseEntity<Object>(resp,HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundExceptions(UserNotFoundException ex,WebRequest wr)
	{
		ExceptionResponse resp= new ExceptionResponse(new Date(),ex.getMessage(),wr.getDescription(false));
		return new ResponseEntity<Object>(resp,HttpStatus.INTERNAL_SERVER_ERROR);	
	}
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException me,HttpHeaders headers,HttpStatus status,WebRequest request)
	{
		ExceptionResponse resp= new ExceptionResponse(new Date(),"Validation Failed",me.getBindingResult().toString());
		return new ResponseEntity(resp,HttpStatus.BAD_REQUEST);
	}
	
}
