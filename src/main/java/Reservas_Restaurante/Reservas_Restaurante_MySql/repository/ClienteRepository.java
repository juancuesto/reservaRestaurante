package Reservas_Restaurante.Reservas_Restaurante_MySql.repository;


import Reservas_Restaurante.Reservas_Restaurante_MySql.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    Cliente findByEmail(@Param("email") String email);
}
