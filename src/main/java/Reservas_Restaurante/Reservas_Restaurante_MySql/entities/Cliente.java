package Reservas_Restaurante.Reservas_Restaurante_MySql.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NamedQuery(name = "Cliente.findByEmail",query = "select c from Cliente c where c.email=: email")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cliente_id;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String password;
    private Boolean activo;
    private String email;
    private String role;
    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Reserva> reservas;
}
