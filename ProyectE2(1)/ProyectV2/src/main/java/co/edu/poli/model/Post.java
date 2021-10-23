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
@Table(name = "posteos")
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy="native")
	private int id_post;
	private String titulo;
	private String descripcion;
	private String imagen_path;
	private String categoria;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "id_admin")
	private Admin admin;
	
	public Post() {

	}

	public int getId_post() {
		return id_post;
	}

	public void setId_post(int id_post) {
		this.id_post = id_post;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen_path() {
		return imagen_path;
	}

	public void setImagen_path(String imagen_path) {
		this.imagen_path = imagen_path;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
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

	public Post(int id_post, String titulo, String descripcion, String imagen_path, String categoria, Usuario usuario,
			Admin admin) {
		super();
		this.id_post = id_post;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imagen_path = imagen_path;
		this.categoria = categoria;
		this.usuario = usuario;
		this.admin = admin;
	}

	
	

}
