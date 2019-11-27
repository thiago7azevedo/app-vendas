package br.com.jcavi.javaweb.sisvendas.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6768547572566111009L;

	@Column(nullable=false, updatable=false)
	@CreatedDate
	private long dataCriacao;
	
	// configuração nullable=false para o atributo marcado com @CreatedBy
	// deu exceção de usuário não pode ser nulo (na criação do cadastro)
	@Column(updatable=false)
	@CreatedBy
	private String usuarioCriacao;
	
	@LastModifiedDate
	private long dataUltimaModificacao;
	
	@LastModifiedBy
	private String usuarioUltimaModificacao;

}