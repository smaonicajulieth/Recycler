package co.edu.poli.proyecto.model;
/*
 * @author Julian Camargo,Cesar Reyes,Monica Rodriguez 
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
/*
 * Crea la tabla Centros de  reciclaje en las bases de datos 
 */
@Entity
@Table(name = "CentrosDeReciclaje")
public class CentroReciclaje {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy="native")
	private String id;
	private String nombre;
	private String correo;
	private String descripcion;
	private String direccion;
	private String estado;
	
	public CentroReciclaje() {
		
	}
	/*
	 * 	Constructor de centros de reciclaje con los atributos
	 */
	
	public CentroReciclaje(String id, String correo, String descripcion, String direccion, String estado, String nombre) {
		super();
		this.id = id;
		this.correo = correo;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.estado = estado;
		this.nombre = nombre;
	
	}
 
	/*
	 * getters y setters para el acceso a los atributos de la clase 
	 * centros de reciclaje 
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
	
	
	
	
}
