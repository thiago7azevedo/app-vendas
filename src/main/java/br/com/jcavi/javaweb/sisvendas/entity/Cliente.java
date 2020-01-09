package br.com.jcavi.javaweb.sisvendas.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


import java.util.*;

@Entity
@Table(name = "cliente")
public class Cliente {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@NotNull(message = "Please enter id")
	private Long id;

	// 		@NotEmpty(message="Nome é obrigatório")
	private String nome;

	//	@NotEmpty(message="E-mail é obrigatório")
	@Email(message = "E-mail inválido")
	@Column(unique = true)
	private String email;

	private String senha;

	private String sobrenome;

	//	@NotNull(message="Idade é obrigatório")
//	@Min(value=18,message="Não são permitidos cadastros de clientes menores de 18 anos")
	private Integer idade;

	//	@NotEmpty(message="Profissão é obrigatório")
//	@Length(min=3,max=200, message="Profissão deve conter pelo menos 3 caracteres")
	private String profissao;

	private String telefone;

	@ManyToMany
	@JoinTable(name = "cliente_role",
			joinColumns = @JoinColumn(name = "id_clientes"),
			inverseJoinColumns = @JoinColumn(name = "id_roles"))
	private List<Role> roles;

	// mappedBy -> indica o nome do atributo na classe (entidade) ManyToOne da relação
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	//@NotEmpty(message="Pelo menos 1 endereço é obrigatório")
	private List<Endereco> enderecos = new ArrayList<>();

	@OneToMany(mappedBy = "cliente")
	private Set<Pedido> pedidos = new HashSet<>();

	public Cliente() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Cliente{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", email='" + email + '\'' +
				", senha='" + senha + '\'' +
				", sobrenome='" + sobrenome + '\'' +
				", idade=" + idade +
				", profissao='" + profissao + '\'' +
				", telefone='" + telefone + '\'' +
				", roles=" + roles +
				", enderecos=" + enderecos +
				", pedidos=" + pedidos +
				'}';
	}
}
