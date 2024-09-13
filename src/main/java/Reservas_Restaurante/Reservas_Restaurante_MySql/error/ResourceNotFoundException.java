package Reservas_Restaurante.Reservas_Restaurante_MySql.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String message;
    private String recurso;

    public ResourceNotFoundException(String recurso,String message) {
        super(String.format("En el recurso %s , %s",recurso,message));
        this.message = message;
    }

}
