package Reservas_Restaurante.Reservas_Restaurante_MySql.repository;

import Reservas_Restaurante.Reservas_Restaurante_MySql.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva,Long> {
}
