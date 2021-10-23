package co.edu.poli.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "Administradores")
public class Admin {
	
	
	
		@Id
		private int id_admin;
		private String administrador;
		private String contraseña;
		private String correo;
		private boolean activo;
		@OneToMany(mappedBy = "admin")
		@JsonIgnore
		private List<Peticion> peticion;
		@OneToMany(mappedBy = "admin")
		@JsonIgnore
		private List<Post> post;
		@OneToMany(mappedBy = "admin")
		@JsonIgnore
		private List<CentrosReciclaje> centros;
		@OneToMany(mappedBy = "admin")
		@JsonIgnore
		private List<Usuario> usuarios;
	
	
	
	public Admin() {
		
	}



	public Admin(int id_admin, String administrador, String contraseña, String correo, boolean activo,
			List<Peticion> peticion, List<Post> post, List<CentrosReciclaje> centros, List<Usuario> usuarios) {
		super();
		this.id_admin = id_admin;
		this.administrador = administrador;
		this.contraseña = contraseña;
		this.correo = correo;
		this.activo = activo;
		this.peticion = peticion;
		this.post = post;
		this.centros = centros;
		this.usuarios = usuarios;
	}



	public int getId_admin() {
		return id_admin;
	}



	public void setId_admin(int id_admin) {
		this.id_admin = id_admin;
	}



	public String getAdministrador() {
		return administrador;
	}



	public void setAdministrador(String administrador) {
		this.administrador = administrador;
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



	public List<CentrosReciclaje> getCentros() {
		return centros;
	}



	public void setCentros(List<CentrosReciclaje> centros) {
		this.centros = centros;
	}



	public List<Usuario> getUsuarios() {
		return usuarios;
	}



	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}



	

}
