package Reservas_Restaurante.Reservas_Restaurante_MySql.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reserva_id;
    private Date fechaReserva;
    @ManyToMany
    @JoinTable(name = "reserva_mesa",
    joinColumns = @JoinColumn(name = "reserva_id"),
    inverseJoinColumns = @JoinColumn(name = "mesa_id"))
    @JsonIgnore
    private List<Mesa> mesas;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    private int numComensales;

    public void afegirMesaAReserva(Mesa mesa){
        mesas.add(mesa);
    }

}
