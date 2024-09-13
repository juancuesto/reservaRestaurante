package Reservas_Restaurante.Reservas_Restaurante_MySql.service;

import Reservas_Restaurante.Reservas_Restaurante_MySql.entities.Cliente;
import Reservas_Restaurante.Reservas_Restaurante_MySql.entities.Mesa;
import Reservas_Restaurante.Reservas_Restaurante_MySql.entities.Reserva;
import Reservas_Restaurante.Reservas_Restaurante_MySql.error.BadRequestException;
import Reservas_Restaurante.Reservas_Restaurante_MySql.error.ResourceNotFoundException;
import Reservas_Restaurante.Reservas_Restaurante_MySql.repository.ClienteRepository;
import Reservas_Restaurante.Reservas_Restaurante_MySql.repository.MesaRepository;
import Reservas_Restaurante.Reservas_Restaurante_MySql.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private MesaRepository mesaRepository;


    /**
     *Guarda una Reserva nuevo en base de datos
     * @param reserva la Reserva a guardar
     * @return el Mesa guardado
     */
    public Reserva crearReserva(Reserva reserva){
            return reservaRepository.save(reserva);
    }

    /**
     * Devuelve la Reserva buscada
     * @param id el id d la Reserva a buscar
     * @return la Reserva buscado si no lo encuentra lanza una excepción segun el caso
     * @throws ResourceNotFoundException lanza esta excepcion sino lo encuentra en base de datos
     * @throws BadRequestException lanza esta excepcion si el id no existe o su formato no es correcto
     */
    public Reserva getReservaById(Long id) throws ResourceNotFoundException, BadRequestException, MethodArgumentTypeMismatchException, NoResourceFoundException {
        if (id==null){
            System.out.println("El formato del id es incorrecto se esta ejecutando methodArgumentTypeMismatchException");
        }
        if(!(id instanceof  Long)){
            System.out.println("Falta introducir el ID se esta ejecutando NoResourceFoundException");
        }
        if (id==1){
            System.out.println("el Id valeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee 1");
        }
        Optional<Reserva> reserva=reservaRepository.findById(id);
        if (reserva.isEmpty()){
            throw new ResourceNotFoundException(" /reservas "," No se ha encontrado la reserva buscada ");
        }
        return reserva.get();

    }

    /**
     * devuelve una lista con todos las Reservas en base de datos
     * @return listado de Reservas en base de datos
     */
    public List<Reserva> listarReservas(){
        return reservaRepository.findAll();
    }

    /**
     * actualiza una Reserva existente en base de datos
     * @param reserva datos para actualizar la Reserva
     * @param id el id de la Reserva a actualizar
     * @return la Reserva actualizada
     * @throws ResourceNotFoundException lanza esta excepcion sino lo encuentra en base de datos
     * @throws BadRequestException lanza esta excepcion si el id no existe o su formato no es correcto
     */
    public Reserva actualizarReserva(Reserva reserva, Long id) throws ResourceNotFoundException,BadRequestException, MethodArgumentTypeMismatchException, NoResourceFoundException {
        if (id==null){
            System.out.println("El formato del id es incorrecto se esta ejecutando methodArgumentTypeMismatchException");
        }
        if(!(id instanceof  Long)){
            System.out.println("Falta introducir el ID se esta ejecutando NoResourceFoundException");
        }
        if (id==1){
            System.out.println("el Id valeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee 1");
        }
        Optional<Reserva> reservaOptional=reservaRepository.findById(id);
        if (reservaOptional.isEmpty()){
            throw new ResourceNotFoundException(" /reservas "," No se ha encontrado la reserva a actualizar");
        }else {
            reserva.setReserva_id(reservaOptional.get().getReserva_id());
            return reservaRepository.save(reserva);
        }
    }
    public void deleteReservaById(Long id) throws ResourceNotFoundException, BadRequestException{
        Optional<Reserva> reserva=reservaRepository.findById(id);
        if (reserva.isEmpty()){
            throw new ResourceNotFoundException(" /reservas "," No se ha encontrado la reserva a borrar");
        }
        if (!(id instanceof Long)||(id==null)){
            throw new BadRequestException("el formato del id es incorrecto o no se ha introducido");
        }
        reservaRepository.deleteById(id);
    }
}
