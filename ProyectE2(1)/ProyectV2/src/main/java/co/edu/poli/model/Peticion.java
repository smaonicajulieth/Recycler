package co.edu.poli.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "Peticiones")
public class Peticion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy="native")
	private int id_peticion;
	private String estado;
	private String nombre;
	private String direccion;
	private String descripcion;
	private String correo;
	private String paginaWeb_link;
	private String redSocial_link;
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	@ManyToOne
	@JoinColumn(name = "id_admin")
	private Admin admin;
		
		
	public Peticion() {
		
	}


	public Peticion(int id_peticion, String estado, String nombre, String direccion, String descripcion, String correo,
			String paginaWeb_link, String redSocial_link, Usuario usuario, Admin admin) {
		super();
		this.id_peticion = id_peticion;
		this.estado = estado;
		this.nombre = nombre;
		this.direccion = direccion;
		this.descripcion = descripcion;
		this.correo = correo;
		this.paginaWeb_link = paginaWeb_link;
		this.redSocial_link = redSocial_link;
		this.usuario = usuario;
		this.admin = admin;
	}


	public int getId_peticion() {
		return id_peticion;
	}


	public void setId_peticion(int id_peticion) {
		this.id_peticion = id_peticion;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getPaginaWeb_link() {
		return paginaWeb_link;
	}


	public void setPaginaWeb_link(String paginaWeb_link) {
		this.paginaWeb_link = paginaWeb_link;
	}


	public String getRedSocial_link() {
		return redSocial_link;
	}


	public void setRedSocial_link(String redSocial_link) {
		this.redSocial_link = redSocial_link;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Admin getAdmin() {
		return admin;
	}


	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
	

}
