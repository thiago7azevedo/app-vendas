package br.com.jcavi.javaweb.sisvendas.auth;

import br.com.jcavi.javaweb.sisvendas.entity.Cliente;
import br.com.jcavi.javaweb.sisvendas.entity.UserSS;
import org.springframework.security.core.context.SecurityContextHolder;


public class ClienteLogado {

    public static UserSS authenticated() {
        try {
            return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            return null;
        }
        }
    }