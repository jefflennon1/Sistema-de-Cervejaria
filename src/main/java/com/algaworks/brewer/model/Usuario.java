package com.algaworks.brewer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Preencha o campo nome")
	private String nome;
	
	@NotBlank(message = "Preencha o campo e-mail")
	private String email;
	
	@NotBlank(message = "Preencha a data de nascimento")
	@Column(name = "data_nasc")
	private String data;
	
	@Column(name = "pwd")
	@NotBlank(message = "Preencha o campo Senha")
	private String senha;
	
	
	@Column(name = "pws_confirmar")
	@NotBlank(message = "Confirme a  Senha")
	private String senhaconfirmar;
	
	@Column(name="situacao")
	private  String status;
	
	
	@Column(name="grupo_usuario")
	@Enumerated(EnumType.STRING)
	private Grupos  grupos;
	
	

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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	public String getSenhaconfirmar() {
		return senhaconfirmar;
	}

	public void setSenhaconfirmar(String senhaconfirmar) {
		this.senhaconfirmar = senhaconfirmar;
	}

	public Grupos getGrupos() {
		return grupos;
	}

	public void setGrupos(Grupos grupos) {
		this.grupos = grupos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
}
