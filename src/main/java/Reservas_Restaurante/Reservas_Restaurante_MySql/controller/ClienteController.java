package Reservas_Restaurante.Reservas_Restaurante_MySql.controller;

import Reservas_Restaurante.Reservas_Restaurante_MySql.entities.Cliente;
import Reservas_Restaurante.Reservas_Restaurante_MySql.error.BadRequestException;
import Reservas_Restaurante.Reservas_Restaurante_MySql.error.ResourceNotFoundException;
import Reservas_Restaurante.Reservas_Restaurante_MySql.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

//    @PostMapping("/signup")
//    public ResponseEntity<String> signUp(@RequestBody Map<String,String> requestMap){
//
//        try {
//            return clienteService.signUp(requestMap);
//        }catch (Exception exception){
//            exception.printStackTrace();
//        }
//        return new ResponseEntity<>("Algo ha salido mal",HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody Map<String,String> requestMap){
//        try {
//            return clienteService.login(requestMap);
//
//        }catch (Exception exception){
//            exception.printStackTrace();
//        }
//        return new ResponseEntity<>("Algo ha salido mal",HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @PostMapping
    public ResponseEntity<?> crearCliente(@RequestBody Cliente cliente){
        return new ResponseEntity<>(clienteService.crearCliente(cliente), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getClienteById(@PathVariable Long id) throws ResourceNotFoundException,BadRequestException , MethodArgumentTypeMismatchException, NoResourceFoundException {
        return new ResponseEntity<>(clienteService.getClienteById(id),HttpStatus.FOUND);
    }
    @GetMapping
    public  ResponseEntity<?> getAllClientes(){
        return new ResponseEntity<>(clienteService.listarClientes(),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<?> actualizarCliente(@RequestBody Cliente cliente,@PathVariable Long id)  throws ResourceNotFoundException,BadRequestException, MethodArgumentTypeMismatchException, NoResourceFoundException {
        return new ResponseEntity<>(clienteService.actualizarCliente(cliente,id),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void deleteClienteById(@PathVariable Long id)  throws ResourceNotFoundException,BadRequestException{
        clienteService.deleteClienteById(id);
    }
}
