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
@Table(name = "CentrosDeReciclaje")
public class CentrosReciclaje {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy="native")
	private int id_centrosReciclaje;
	private String nombre;
	private String descripcion;
	private String direccion;
	private String correo;
	private String paginaWeb_link;
	private String redSocial_link;
	@ManyToOne
	@JoinColumn(name = "id_admin")
	private Admin admin;
	public CentrosReciclaje() {

	}
	
	public CentrosReciclaje(int id_centrosReciclaje, String nombre, String descripcion, String direccion, String correo,
			String paginaWeb_link, String redSocial_link, Admin admin) {
		super();
		this.id_centrosReciclaje = id_centrosReciclaje;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.correo = correo;
		this.paginaWeb_link = paginaWeb_link;
		this.redSocial_link = redSocial_link;
		this.admin = admin;
	}

	public int getId_centrosReciclaje() {
		return id_centrosReciclaje;
	}
	public void setId_centrosReciclaje(int id_centrosReciclaje) {
		this.id_centrosReciclaje = id_centrosReciclaje;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
	
	
	
}
