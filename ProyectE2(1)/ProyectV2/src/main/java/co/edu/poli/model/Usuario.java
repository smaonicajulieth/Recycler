package co.edu.poli.model;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private int id_usuario;
	private String usuario;
	private String contraseña;
	private String correo;
	private boolean activo;

	@OneToMany(mappedBy = "usuario")
	@JsonIgnore
	private List<Peticion> peticion;

	@OneToMany(mappedBy = "usuario")
	@JsonIgnore
	private List<Post> post;

	@ManyToOne
	@JoinColumn(name = "id_admin")
	private Admin admin;

	public Usuario() {

	}

	public Usuario(int id_usuario, String usuario, String contraseña, String correo, boolean activo,
			List<Peticion> peticion, List<Post> post, Admin admin) {
		super();
		this.id_usuario = id_usuario;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.correo = correo;
		this.activo = activo;
		this.peticion = peticion;
		this.post = post;
		this.admin = admin;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public List<Peticion> getPeticion() {
		return peticion;
	}

	public void setPeticion(List<Peticion> peticion) {
		this.peticion = peticion;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

}
