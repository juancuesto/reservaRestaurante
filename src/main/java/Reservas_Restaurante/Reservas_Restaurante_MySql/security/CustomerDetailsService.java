package Reservas_Restaurante.Reservas_Restaurante_MySql.security;

import Reservas_Restaurante.Reservas_Restaurante_MySql.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import Reservas_Restaurante.Reservas_Restaurante_MySql.entities.Cliente;

import java.util.ArrayList;
import java.util.Objects;

@Slf4j
@Service
public class CustomerDetailsService implements UserDetailsService {
    @Autowired
    private ClienteRepository clienteRepository;
    private Cliente clienteDetail;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("dentro de loadUserByUsername {}",username);
        clienteDetail=clienteRepository.findByEmail(username);
        if(!Objects.isNull(clienteDetail)){
            return new org.springframework.security.core.userdetails.User(clienteDetail.getEmail(),
                    clienteDetail.getPassword(),new ArrayList<>());
        }else {
            throw new UsernameNotFoundException("usuario no encontrado");
        }
    }
    public  Cliente getUserDetail(){
        return clienteDetail;
    }
}
