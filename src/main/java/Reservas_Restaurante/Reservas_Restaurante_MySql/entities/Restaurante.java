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
@Table(name = "restaurantes")
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurante_id;
    private String nombre;
    private String direccion;
    private String telefono;
    @OneToMany(mappedBy = "restaurante")
    @JsonIgnore
    private List<Mesa> mesas;
}
