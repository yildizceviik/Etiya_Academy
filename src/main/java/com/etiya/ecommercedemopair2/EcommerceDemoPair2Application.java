package com.etiya.ecommercedemopair2;

import com.etiya.ecommercedemopair2.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemopair2.core.util.results.ErrorDataResult;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestControllerAdvice
public class EcommerceDemoPair2Application {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceDemoPair2Application.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}

	//Global Exception handling-handler
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult handleValidationException(MethodArgumentNotValidException exception){
		//TODO: ErrorDataResult olarak ilgili hataları döndür.
		Map<String,String> errors = new HashMap<>();

		for(FieldError fieldError : exception.getBindingResult().getFieldErrors()){
			errors.put(fieldError.getField(),fieldError.getDefaultMessage());
		}

		return new ErrorDataResult(errors,"Validation Error.");
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult handleBusinessException(BusinessException exception){
		// Result sistemi kullanılacak.
		return new ErrorDataResult(exception.getMessage(),"Business Error");
	}


	//fonk oluştur => @ExceptionHandler ile handler old. söyle
	//=> Parametre olarak yakalayacağı exception olarak ver
}
