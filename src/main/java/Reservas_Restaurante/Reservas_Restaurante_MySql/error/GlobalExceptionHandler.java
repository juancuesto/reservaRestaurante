package Reservas_Restaurante.Reservas_Restaurante_MySql.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiResponse> HandlerResourceNotFoundEception(MethodArgumentTypeMismatchException ex){
        ApiResponse response=new ApiResponse("El parametro Id tiene un formato incorrecto");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
@ExceptionHandler(value = ResourceNotFoundException.class)
public ResponseEntity<String> handlerResourceNotFoundExcepcion(ResourceNotFoundException ex,
                                                                    WebRequest webRequest){
    //ApiResponse apiResponse=new ApiResponse(ex.getMessage(),webRequest.getDescription(false));
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);

}
    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<String> HandlerBarRequestException(BadRequestException ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NoResourceFoundException.class)
    public ResponseEntity<ApiResponse> HandlerBarRequestException(NoResourceFoundException ex){
        ApiResponse response=new ApiResponse("No se ha introducido el parametro Id");
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

}
