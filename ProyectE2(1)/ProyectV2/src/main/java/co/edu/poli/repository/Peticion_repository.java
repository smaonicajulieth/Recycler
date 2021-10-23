package co.edu.poli.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.poli.model.Peticion;


public interface Peticion_repository extends JpaRepository<Peticion, String> {

}
