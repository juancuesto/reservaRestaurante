package Reservas_Restaurante.Reservas_Restaurante_MySql.error;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends Exception {
    private String message;

    public BadRequestException(String message) {
        super(String.format("El id del recurso %s debe ser introducido o su formato es incorrecto",message));
        this.message = message;
    }

//    public BadRequestException(String message) {
//        super(String.format("El id del recurso %s debe ser introducido o su formato es incorrecto",message));
//        this.message = message;
//    }

}
