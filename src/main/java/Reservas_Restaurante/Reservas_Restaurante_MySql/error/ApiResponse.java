package Reservas_Restaurante.Reservas_Restaurante_MySql.error;

public class ApiResponse {
    private String mensaje;

    public ApiResponse() {
    }

    public ApiResponse(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
