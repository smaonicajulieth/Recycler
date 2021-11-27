package co.edu.poli.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.poli.proyecto.model.CentroReciclaje;

public interface Centro_repository extends JpaRepository<CentroReciclaje, String> {
	
		//buscar listado de centros que contengan los caracteres que se soliciten
		@Query(value = "SELECT * FROM Centros_De_Reciclaje WHERE nombre LIKE ?1%", nativeQuery = true)
		List<CentroReciclaje> buscarCentros(String lyrics);
		
		@Query(value = "UPDATE Centros_De_Reciclaje SET estado=?1 WHERE id=?2", nativeQuery = true)
		CentroReciclaje editarEstado(String estado, int id);
		
		@Query(value = "SELECT * FROM Centros_De_Reciclaje WHERE estado = ?1", nativeQuery = true)
		List<CentroReciclaje> buscarEstados(String estado);
		
}
