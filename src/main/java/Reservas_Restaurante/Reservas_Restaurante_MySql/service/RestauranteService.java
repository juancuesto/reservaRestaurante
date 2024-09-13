package Reservas_Restaurante.Reservas_Restaurante_MySql.service;

import Reservas_Restaurante.Reservas_Restaurante_MySql.entities.Reserva;
import Reservas_Restaurante.Reservas_Restaurante_MySql.entities.Restaurante;
import Reservas_Restaurante.Reservas_Restaurante_MySql.error.BadRequestException;
import Reservas_Restaurante.Reservas_Restaurante_MySql.error.ResourceNotFoundException;
import Reservas_Restaurante.Reservas_Restaurante_MySql.repository.ReservaRepository;
import Reservas_Restaurante.Reservas_Restaurante_MySql.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class RestauranteService {
    @Autowired
    private RestauranteRepository restauranteRepository;


    /**
     *Guarda una Restaurante nuevo en base de datos
     * @param restaurante el Restaurante a guardar
     * @return el Restaurante guardado
     */
    public Restaurante crearRestaurante(Restaurante restaurante){
        return restauranteRepository.save(restaurante);
    }

    /**
     * Devuelve el Restaurante buscada
     * @param id el id de el Restaurante a buscar
     * @return el Restaurante buscado si no lo encuentra lanza una excepción segun el caso
     * @throws ResourceNotFoundException lanza esta excepcion sino lo encuentra en base de datos
     * @throws BadRequestException lanza esta excepcion si el id no existe o su formato no es correcto
     */
    public Restaurante getRestauranteById(Long id) throws ResourceNotFoundException, BadRequestException, MethodArgumentTypeMismatchException, NoResourceFoundException {
        if (id==null){
            System.out.println("El formato del id es incorrecto se esta ejecutando methodArgumentTypeMismatchException");
        }
        if(!(id instanceof  Long)){
            System.out.println("Falta introducir el ID se esta ejecutando NoResourceFoundException");
        }
        if (id==1){
            System.out.println("el Id valeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee 1");
        }
        Optional<Restaurante> restaurante=restauranteRepository.findById(id);
        if (restaurante.isEmpty()){
            throw new ResourceNotFoundException(" /Restaurantes "," No se ha encontrado el restaurante buscado");
        }
        return restaurante.get();

    }

    /**
     * devuelve una lista con todos los Restaurantee en base de datos
     * @return listado de Restaurantes en base de datos
     */
    public List<Restaurante> listarRestaurantes(){
        return restauranteRepository.findAll();
    }

    /**
     * actualiza un Restaurante existente en base de datos
     * @param restaurante datos para actualizar el Restaurante
     * @param id el id del Restaurantea actualizar
     * @return el Restaurante actualizado
     * @throws ResourceNotFoundException lanza esta excepcion sino lo encuentra en base de datos
     * @throws BadRequestException lanza esta excepcion si el id no existe o su formato no es correcto
     */
    public Restaurante actualizarRestaurante(Restaurante restaurante, Long id) throws ResourceNotFoundException,BadRequestException, MethodArgumentTypeMismatchException, NoResourceFoundException {
        if (id==null){
            System.out.println("El formato del id es incorrecto se esta ejecutando methodArgumentTypeMismatchException");
        }
        if(!(id instanceof  Long)){
            System.out.println("Falta introducir el ID se esta ejecutando NoResourceFoundException");
        }
        if (id==1){
            System.out.println("el Id valeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee 1");
        }
        Optional<Restaurante> restauranteOptional=restauranteRepository.findById(id);
        if (restauranteOptional.isEmpty()){
            throw new ResourceNotFoundException(" /Restaurantes "," No se ha encontrado el restaurante a actualizar");
        }else {
            restaurante.setRestaurante_id(restauranteOptional.get().getRestaurante_id());
            return restauranteRepository.save(restaurante);
        }
    }
    public void deleteRestauranteById(Long id) throws ResourceNotFoundException, BadRequestException{
        Optional<Restaurante> restaurante=restauranteRepository.findById(id);
        if (restaurante.isEmpty()){
            throw new ResourceNotFoundException(" /Restaurantes "," No se ha encontrado el Restaurante a borrar");
        }
        if (!(id instanceof Long)||(id==null)){
            throw new BadRequestException("el formato del id es incorrecto o no se ha introducido");
        }
        restauranteRepository.deleteById(id);
    }
}
