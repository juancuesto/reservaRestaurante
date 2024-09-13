package Reservas_Restaurante.Reservas_Restaurante_MySql.controller;

import Reservas_Restaurante.Reservas_Restaurante_MySql.entities.Restaurante;
import Reservas_Restaurante.Reservas_Restaurante_MySql.error.BadRequestException;
import Reservas_Restaurante.Reservas_Restaurante_MySql.error.ResourceNotFoundException;
import Reservas_Restaurante.Reservas_Restaurante_MySql.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestauranteController {
    @Autowired
    private RestauranteService restauranteService;

    @PostMapping
    public ResponseEntity<Restaurante> crearRestaurante(@RequestBody Restaurante restaurante){
        return new ResponseEntity<>(restauranteService.crearRestaurante(restaurante), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> getRestauranteById(@PathVariable Long id)throws ResourceNotFoundException, BadRequestException, MethodArgumentTypeMismatchException, NoResourceFoundException {
        return new ResponseEntity<>(restauranteService.getRestauranteById(id),HttpStatus.FOUND);
    }
    @GetMapping
    public ResponseEntity<List<Restaurante>> getAllRestaurantes(){
        return new ResponseEntity<>(restauranteService.listarRestaurantes(),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Restaurante> actualizarRestaurante(@RequestBody Restaurante restaurante,@PathVariable Long id)throws ResourceNotFoundException, BadRequestException, MethodArgumentTypeMismatchException, NoResourceFoundException {
        return new ResponseEntity<>(restauranteService.actualizarRestaurante(restaurante,id),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRestauranteById(@PathVariable Long id) throws NoResourceFoundException, BadRequestException{
        restauranteService.deleteRestauranteById(id);
        return new ResponseEntity<>("Restaurante borrado correctamente",HttpStatus.OK);

    }
}
