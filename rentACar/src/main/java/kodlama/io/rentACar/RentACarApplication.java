package kodlama.io.rentACar;

import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.core.utilities.exceptions.ProblemDetails;
import kodlama.io.rentACar.core.utilities.exceptions.ValidationProblemDetails;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Field;
import java.util.HashMap;

@SpringBootApplication
@RestControllerAdvice //bütün controllerlar exceptionhandlera tabi tutulur

public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);

	}
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException)//Bad Request alırsa eğer ProblemDetails sınıfı çalışır ve sadece hatanın adı verilir
	{
	ProblemDetails problemDetails=new ProblemDetails();
	problemDetails.setMessage(businessException.getMessage()); //Yukarda anlattığım gibi sadece hatanın adı döner
	return  problemDetails;
	}
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleValidException(MethodArgumentNotValidException methodArgumentNotValidException)//Bad Request alırsa eğer ProblemDetails sınıfı çalışır ve sadece hatanın adı verilir
	{
	ValidationProblemDetails validationProblemDetails=new ValidationProblemDetails();
	validationProblemDetails.setMessage("VALIDATION.EXCEPTION"); //Yukarda anlattığım gibi sadece hatanın adı döner
	validationProblemDetails.setValidationErrors(new HashMap<String ,String >());

	for(FieldError fieldError:methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
		validationProblemDetails.getValidationErrors().put(fieldError.getField(),fieldError.getDefaultMessage());
	}
	return  validationProblemDetails;
	}


	@Bean //IOC'ye modelMapper ekledi
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}

}
