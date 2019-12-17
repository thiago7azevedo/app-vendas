package br.com.jcavi.javaweb.sisvendas.repository;


import br.com.jcavi.javaweb.sisvendas.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}