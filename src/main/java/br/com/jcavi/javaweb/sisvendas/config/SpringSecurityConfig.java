package br.com.jcavi.javaweb.sisvendas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ImplementsUserDetailsService implementsUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.headers().frameOptions().disable();
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/dashboard/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/categoria/listar").hasAnyRole("ADMIN", "USER")
                .antMatchers("/categoria/adicionar").hasAnyRole("ADMIN")
                .antMatchers("/cliente/listar").hasAnyRole("ADMIN", "USER")
                .antMatchers("/cliente/adicionar").hasAnyRole("ADMIN")
                .antMatchers("/endereco/**").hasAnyRole("ADMIN")
                .antMatchers("/venda/adicionar").hasAnyRole("ADMIN, USER")
                .antMatchers("/venda/listar").hasAnyRole("ADMIN", "USER")
                .antMatchers("/produto/adicionar").hasAnyRole("ADMIN")
                .antMatchers("/produto/listar").hasAnyRole("ADMIN", "USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/dashboard")
               // .failureUrl("/login.html?error=true")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(implementsUserDetailsService);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}
