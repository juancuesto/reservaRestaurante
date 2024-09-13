package Reservas_Restaurante.Reservas_Restaurante_MySql.controller;

import Reservas_Restaurante.Reservas_Restaurante_MySql.entities.Mesa;
import Reservas_Restaurante.Reservas_Restaurante_MySql.entities.Reserva;
import Reservas_Restaurante.Reservas_Restaurante_MySql.error.BadRequestException;
import Reservas_Restaurante.Reservas_Restaurante_MySql.error.ResourceNotFoundException;
import Reservas_Restaurante.Reservas_Restaurante_MySql.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public ResponseEntity<Reserva> crearReserva(@RequestBody Reserva reserva){
        return new ResponseEntity<>(reservaService.crearReserva(reserva),HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getReservaById(@PathVariable Long id) throws ResourceNotFoundException, BadRequestException, MethodArgumentTypeMismatchException, NoResourceFoundException{
        return new ResponseEntity<>(reservaService.getReservaById(id), HttpStatus.FOUND);
    }
    @GetMapping
    public ResponseEntity<List<Reserva>> getAllReservas(){
        return new ResponseEntity<>(reservaService.listarReservas(),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Reserva> actualizarReserva(@RequestBody Reserva reserva,@PathVariable Long id) throws ResourceNotFoundException, BadRequestException, MethodArgumentTypeMismatchException, NoResourceFoundException{
        return new ResponseEntity<>(reservaService.actualizarReserva(reserva,id),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>  deleteReservaById(@PathVariable Long id)throws NoResourceFoundException, BadRequestException{
        reservaService.deleteReservaById(id);
        return new ResponseEntity<>("Reserva borrada correctamente",HttpStatus.OK);
    }
}
