package Reservas_Restaurante.Reservas_Restaurante_MySql.controller;

import Reservas_Restaurante.Reservas_Restaurante_MySql.entities.Mesa;
import Reservas_Restaurante.Reservas_Restaurante_MySql.error.BadRequestException;
import Reservas_Restaurante.Reservas_Restaurante_MySql.error.ResourceNotFoundException;
import Reservas_Restaurante.Reservas_Restaurante_MySql.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;

@RestController
@RequestMapping("/mesas")
public class MesaController {
    @Autowired
    private MesaService mesaService;

    @PostMapping
    public ResponseEntity<Mesa> crearMesa(@RequestBody Mesa mesa){
        return new ResponseEntity<>(mesaService.crearMesa(mesa), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Mesa> getMesaById(@PathVariable Long id)  throws ResourceNotFoundException, BadRequestException, MethodArgumentTypeMismatchException, NoResourceFoundException {
        return new ResponseEntity<>(mesaService.getMesaById(id),HttpStatus.FOUND);
    }
    @GetMapping
    public ResponseEntity<List<Mesa>> getAllMesas(){
        return new ResponseEntity<>(mesaService.listarMesas(),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Mesa> actualizarMesa(@RequestBody Mesa mesa,@PathVariable Long id)throws ResourceNotFoundException, BadRequestException, MethodArgumentTypeMismatchException, NoResourceFoundException {
        return new ResponseEntity<>(mesaService.actualizarCliente(mesa,id),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMesaById(@PathVariable Long id) throws  ResourceNotFoundException, BadRequestException{
        mesaService.deleteMesaById(id);
        return new ResponseEntity<>("Mesa borrada correctamente",HttpStatus.OK);
    }
}
