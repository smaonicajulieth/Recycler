package co.edu.poli.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.poli.proyecto.model.Posteo;


public interface Post_repository extends JpaRepository<Posteo, String> {
	
	//buscar listado de centros que contengan los caracteres que se soliciten
	@Query(value = "SELECT * FROM Posteos WHERE categoria = ?1 ", nativeQuery = true)
	List<Posteo> mostrarPost(String categoria);

}
