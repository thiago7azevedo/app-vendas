package br.com.jcavi.javaweb.sisvendas.config;

import br.com.jcavi.javaweb.sisvendas.entity.Cliente;
import br.com.jcavi.javaweb.sisvendas.entity.UserSS;
import br.com.jcavi.javaweb.sisvendas.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.User;

import javax.transaction.Transactional;
import java.util.Objects;

@Component
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService {

    private final ClienteService clienteService;


    @Autowired
    public ImplementsUserDetailsService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Cliente cliente = clienteService.findByEmail(login);
        if (Objects.isNull(cliente)) {
            throw new UsernameNotFoundException("Cliente não encontrado");
        }
        return new UserSS(cliente.getId(), cliente.getEmail(), cliente.getSenha(), cliente.getRoles());
    }
}
