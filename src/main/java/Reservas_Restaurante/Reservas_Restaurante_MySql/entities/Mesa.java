package Reservas_Restaurante.Reservas_Restaurante_MySql.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mesas")
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mesa_id;
    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;
    @ManyToMany
    @JoinTable(name = "reserva_mesa",
    joinColumns = @JoinColumn(name = "mesa_id"),
    inverseJoinColumns  =@JoinColumn(name = "reserva_id"))

    private List<Reserva> reservas;
    private Boolean disponibilidad;
    private int cantidadComensalesMesa;
}
