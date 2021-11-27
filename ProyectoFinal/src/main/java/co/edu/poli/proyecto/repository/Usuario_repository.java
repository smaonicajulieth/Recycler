package co.edu.poli.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.poli.proyecto.model.CentroReciclaje;
import co.edu.poli.proyecto.model.User;

public interface Usuario_repository extends JpaRepository<User, String> {

	@Query(value = "SELECT correo FROM user", nativeQuery = true)
	String[] buscarCorreos();
}
