package co.edu.poli.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.poli.model.CentrosReciclaje;

public interface Centro_repository extends JpaRepository<CentrosReciclaje, String> {
	
		//buscar listado de centros que contengan los caracteres que se soliciten
		@Query(value = "SELECT * FROM CentrosDeReciclaje WHERE nombre LIKE ?1%", nativeQuery = true)
		List<CentrosReciclaje> buscarCentros(String lyrics);

}
