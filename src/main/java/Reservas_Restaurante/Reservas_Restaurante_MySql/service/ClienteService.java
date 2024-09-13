package Reservas_Restaurante.Reservas_Restaurante_MySql.service;

import Reservas_Restaurante.Reservas_Restaurante_MySql.entities.Cliente;
import Reservas_Restaurante.Reservas_Restaurante_MySql.error.BadRequestException;
import Reservas_Restaurante.Reservas_Restaurante_MySql.error.ResourceNotFoundException;
import Reservas_Restaurante.Reservas_Restaurante_MySql.repository.ClienteRepository;
import Reservas_Restaurante.Reservas_Restaurante_MySql.security.CustomerDetailsService;
import Reservas_Restaurante.Reservas_Restaurante_MySql.security.jw.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

//@Slf4j
@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

//    @Autowired
//    private AuthenticationManager authenticationManager;
//    @Autowired
//    private CustomerDetailsService customerDetailsService;
//    @Autowired
//    private JwtUtil jwtUtil;
//
//
//    public ResponseEntity<String> login(Map<String, String> requestMap) {
//        log.info("dentro de login");
//        try{
//            log.info("dentro de loginaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(requestMap.get("email"),requestMap.get("password"))
//            );
//            if (authentication.isAuthenticated()){
//                log.info("estoy Autenticado");
//                if (customerDetailsService.getUserDetail().getActivo()==true){
//                    return new ResponseEntity<String>("{\"token\":\""+jwtUtil.generatedToken(
//                            customerDetailsService.getUserDetail().getEmail()
//                            ,customerDetailsService.getUserDetail().getRole())+"\"}",HttpStatus.OK);
//                }else {
//                    log.info("ppendiente aprovacion administrador");
//                    return new ResponseEntity<String>("{\"mensaje\":"+"Espere la aprobacion del administrador"+"\"}",HttpStatus.BAD_REQUEST);
//                }
//            }
//
//        }catch (Exception exception){
//            log.error("{estas equivocado}",exception);
//
//        }
//
//        return new ResponseEntity<>("{\"mensaje\":"+"Credenciales incorrectas"+"\"}",HttpStatus.BAD_REQUEST);
//    }
//
//    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
//
//        log.info("Estoy dentro de signup{} ", requestMap);
//        try {
//            if (validateSignUpMap(requestMap)) {
//                Cliente cliente = clienteRepository.findByEmail(requestMap.get("email"));
//                if (Objects.isNull(cliente)) {
//                    clienteRepository.save(getClienteFromMap(requestMap));
//                    return new ResponseEntity<>("Usuario guardado correctamente ", HttpStatus.CREATED);
//
//                } else {
//                    return new ResponseEntity<>("El usuario con este email, ya existe  ", HttpStatus.BAD_REQUEST);
//                }
//            } else {
//                return new ResponseEntity<>("Datos invalidos  ", HttpStatus.BAD_REQUEST);
//            }
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }
//        return new ResponseEntity<>("Algo ha salido mal ", HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    private Cliente getClienteFromMap(Map<String, String> requestMap) {
//        Cliente cliente = new Cliente();
//
//        cliente.setNombre(requestMap.get("nombre"));
//        cliente.setApellidos(requestMap.get("apellidos"));
//        cliente.setEmail(requestMap.get("email"));
//        cliente.setPassword(requestMap.get("password"));
//        cliente.setActivo(true);
//        cliente.setRole("user");
//
//        return cliente;
//    }
//
//    public Boolean validateSignUpMap(Map<String, String> requestMap) {
//        if (requestMap.containsKey("nombre") && requestMap.containsKey("apellidos") && requestMap.containsKey("password") && requestMap.containsKey("email")) {
//            return true;
//        } else {
//            return false;
//        }
//    }


    /**
     * Guarda un cliente nuevo en base de datos
     *
     * @param cliente el cliente a guardar
     * @return el cliente guardado
     */
    public ResponseEntity<String> crearCliente(Cliente cliente) {
        clienteRepository.save(cliente);
        return new ResponseEntity<>("Cliente creado correctamente",HttpStatus.BAD_REQUEST);
    }

    /**
     * Devuelve el cliente buscado
     *
     * @param id el id del cliente a buscar
     * @return el cliente buscado si no lo encuentra lanza una excepción segun el caso
     * @throws ResourceNotFoundException lanza esta excepcion sino lo encuentra en base de datos
     * @throws BadRequestException       lanza esta excepcion si el id no existe o su formato no es correcto
     */
    public Cliente getClienteById(Long id) throws ResourceNotFoundException, BadRequestException, MethodArgumentTypeMismatchException, NoResourceFoundException {
        if (id == null) {
            System.out.println("El formato del id es incorrecto se esta ejecutando methodArgumentTypeMismatchException");
        }
        if (!(id instanceof Long)) {
            System.out.println("Falta introducir el ID se esta ejecutando NoResourceFoundException");
        }
        if (id == 1) {
            System.out.println("el Id valeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee 1");
        }
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isEmpty()) {
            throw new ResourceNotFoundException(" /clientes ", " No se ha encontrado el cliente buscado ");
        }
        return cliente.get();

    }

    /**
     * devuelve una lista con todos los cientes en base de datos
     *
     * @return listado de clientes en base de datos
     */
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    /**
     * actualiza un cliente existente en base de datos
     *
     * @param cliente datos para actualizar el cliente
     * @param id      el id del cliente a actualizar
     * @return el cliente actualizado
     * @throws ResourceNotFoundException lanza esta excepcion sino lo encuentra en base de datos
     * @throws BadRequestException       lanza esta excepcion si el id no existe o su formato no es correcto
     */
    public Cliente actualizarCliente(Cliente cliente, Long id) throws ResourceNotFoundException, BadRequestException, MethodArgumentTypeMismatchException, NoResourceFoundException {
        if (id == null) {
            System.out.println("El formato del id es incorrecto se esta ejecutando methodArgumentTypeMismatchException");
        }
        if (!(id instanceof Long)) {
            System.out.println("Falta introducir el ID se esta ejecutando NoResourceFoundException");
        }
        if (id == 1) {
            System.out.println("el Id valeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee 1");
        }
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isEmpty()) {
            throw new ResourceNotFoundException(" /mesas ", " No se ha encontrado el cliente a actualizar");
        } else {
            cliente.setCliente_id(clienteOptional.get().getCliente_id());
            return clienteRepository.save(cliente);
        }
    }

    public void deleteClienteById(Long id) throws ResourceNotFoundException, BadRequestException {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isEmpty()) {
            throw new ResourceNotFoundException(" /mesas ", " No se ha encontrado el cliente a borrar");
        }
        if (!(id instanceof Long) || (id == null)) {
            throw new BadRequestException("el formato del id es incorrecto o no se ha introducido");
        }
        clienteRepository.deleteById(id);
    }
}
