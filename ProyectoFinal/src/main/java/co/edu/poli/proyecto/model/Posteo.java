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


@Entity
@Table(name = "posteo")
public class Posteo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy="native")
	private int id;
	private String categoria;
	private String descripcion;
	private String titulo;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private User usuario;



	public Posteo() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*
	 * constructor de la clase Posteo con todos sus atributos
	 */

	public Posteo(int id, String categoria, String descripcion, String titulo) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.titulo = titulo;
	}

	/*
	 * getters y setters para el acceso a los atributos de la clase posteo 
	 */
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public User getUsuario() {
		return usuario;
	}


	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}





}
