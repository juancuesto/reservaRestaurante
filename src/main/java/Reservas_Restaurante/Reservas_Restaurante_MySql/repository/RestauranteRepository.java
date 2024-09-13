package Reservas_Restaurante.Reservas_Restaurante_MySql.repository;

import Reservas_Restaurante.Reservas_Restaurante_MySql.entities.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante,Long> {
}
