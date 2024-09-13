package Reservas_Restaurante.Reservas_Restaurante_MySql.service;

import Reservas_Restaurante.Reservas_Restaurante_MySql.entities.Cliente;
import Reservas_Restaurante.Reservas_Restaurante_MySql.entities.Mesa;
import Reservas_Restaurante.Reservas_Restaurante_MySql.error.BadRequestException;
import Reservas_Restaurante.Reservas_Restaurante_MySql.error.ResourceNotFoundException;
import Reservas_Restaurante.Reservas_Restaurante_MySql.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;
import java.util.Optional;
@Service
public class MesaService {
    @Autowired
    private MesaRepository mesaRepository;

    /**
     *Guarda un Mesa nuevo en base de datos
     * @param mesa el Mesa a guardar
     * @return el Mesa guardado
     */
    public Mesa crearMesa(Mesa mesa){
        return mesaRepository.save(mesa);
    }

    /**
     * Devuelve el Mesa buscado
     * @param id el id d la Mesa a buscar
     * @return la Mesa buscado si no lo encuentra lanza una excepción segun el caso
     * @throws ResourceNotFoundException lanza esta excepcion sino lo encuentra en base de datos
     * @throws BadRequestException lanza esta excepcion si el id no existe o su formato no es correcto
     */
    public Mesa getMesaById(Long id) throws ResourceNotFoundException, BadRequestException, MethodArgumentTypeMismatchException, NoResourceFoundException {
        if (id==null){
            System.out.println("El formato del id es incorrecto se esta ejecutando methodArgumentTypeMismatchException");
        }
        if(!(id instanceof  Long)){
            System.out.println("Falta introducir el ID se esta ejecutando NoResourceFoundException");
        }
        if (id==1){
            System.out.println("el Id valeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee 1");
        }
        Optional<Mesa> mesa=mesaRepository.findById(id);
        if (mesa.isEmpty()){
            throw new ResourceNotFoundException(" /mesas "," No se ha encontrado la mesa buscada ");
        }
        return mesa.get();

    }

    /**
     * devuelve una lista con todos los Mesas en base de datos
     * @return listado de Mesas en base de datos
     */
    public List<Mesa> listarMesas(){
        return mesaRepository.findAll();
    }

    /**
     * actualiza un Mesa existente en base de datos
     * @param mesa datos para actualizar el cliente
     * @param id el id de la Mesa a actualizar
     * @return la Mesa actualizada
     * @throws ResourceNotFoundException lanza esta excepcion sino lo encuentra en base de datos
     * @throws BadRequestException lanza esta excepcion si el id no existe o su formato no es correcto
     */
    public Mesa actualizarCliente(Mesa mesa, Long id) throws ResourceNotFoundException,BadRequestException, MethodArgumentTypeMismatchException, NoResourceFoundException {
        if (id==null){
            System.out.println("El formato del id es incorrecto se esta ejecutando methodArgumentTypeMismatchException");
        }
        if(!(id instanceof  Long)){
            System.out.println("Falta introducir el ID se esta ejecutando NoResourceFoundException");
        }
        if (id==1){
            System.out.println("el Id valeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee 1");
        }
        Optional<Mesa> mesaOptional=mesaRepository.findById(id);
        if (mesaOptional.isEmpty()){
            throw new ResourceNotFoundException("/mesas "," No se ha encontrado la mesa a actualizar ");
        }else {
            mesa.setMesa_id(mesaOptional.get().getMesa_id());
            return mesaRepository.save(mesa);
        }
    }
    public void deleteMesaById(Long id) throws ResourceNotFoundException, BadRequestException{
        Optional<Mesa> mesa=mesaRepository.findById(id);
        if (mesa.isEmpty()){
            throw new ResourceNotFoundException("/mesas "," No se ha encontrado la mesa a borrar");
        }
        if (!(id instanceof Long)||(id==null)){
            throw new BadRequestException("el formato del id es incorrecto o no se ha introducido");
        }
        mesaRepository.deleteById(id);
    }
}
