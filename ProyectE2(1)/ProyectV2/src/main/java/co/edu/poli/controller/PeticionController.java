package co.edu.poli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.model.Peticion;
import co.edu.poli.repository.Peticion_repository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/proyect/peticion")
public class PeticionController {

	@Autowired
	private Peticion_repository peticion_repository;

	public PeticionController() {

	}

	@PostMapping("/envioDato")
	@ApiOperation(value = "Guardar formulario de petición ", notes = "Guarda la informacion del formulario de peticiones en la base de datos")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error al guardar"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "La peticion se ha enviado")})
	public String insertPeticion(@RequestBody Peticion peticion) {
		peticion_repository.save(peticion);
		return "el dato ha sido enviado a BD (งツ)ว(งツ)ว(งツ)ว";
	}

	@PostMapping("/envioDatos")
	@ApiOperation(value = "Guardar formularios de peticiónes ", notes = "Guarda la informacion de los formulario de peticiones en la base de datos")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error al guardar"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "La peticion se ha enviado")})
	
	public String insertPeticiones(@RequestBody List<Peticion> peticion) {
		peticion_repository.saveAll(peticion);
		return "los datos han sido enviados a BD  (งツ)ว(งツ)ว(งツ)ว";
	}

	@GetMapping("/obtenerDato/{id_peticion}")
	@ApiOperation(value = "Obtener  formulario solicitado ", notes = "obtiene la informacion del formulario deseado")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error al obtener el formulario"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "El formulado solicitado ha sido descargado")})
	public Peticion selectPeticion(@PathVariable String id_peticion) {
		return peticion_repository.findById(id_peticion).get();
	}

	@GetMapping("/obtenerDatos")
	@ApiOperation(value = "Obtener fomularios  de petición ", notes = "obtiene la informacion de los formularios")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error al obtener los datos"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "Los datos han sido descargados")})
	public List<Peticion> selectPeticiones() {
		return peticion_repository.findAll();
	}

	/*
	 * @PutMapping("/actualizarDato/{code}") public String
	 * updatePeticion(@PathVariable String id_peticion, @RequestBody Peticion
	 * peticion) {
	 * 
	 * Peticion peticionUpdate = peticion_repository.findById(id_peticion).get();
	 * peticionUpdate.setEstado(peticion.getEstado());
	 * peticionUpdate.setNombre(peticion.getNombre());
	 * peticionUpdate.setDireccion(peticion.getDireccion());
	 * peticionUpdate.setDescripcion(peticion.getDescripcion());
	 * peticionUpdate.setCorreo(peticion.getCorreo());
	 * peticionUpdate.setPaginaWeb_link(peticion.getPaginaWeb_link());
	 * peticionUpdate.setRedSocial_link(peticion.getRedSocial_link());
	 * peticionUpdate.setUsuario(peticion.getUsuario());
	 * peticion_repository.save(peticionUpdate); return
	 * "dato actualizado en BD  (งツ)ว(งツ)ว(งツ)ว"; }
	 */

	@DeleteMapping("/eliminarDato/{id_peticion}")
	@ApiOperation(value = "Elimina el formulario de  petición ", notes = "elimina la informacion del formulario de peticiones en la base de datos")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error al eliminar"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "La peticion ha sido eliminada")})
	public String deletePeticion(@PathVariable String id_peticion) {
		peticion_repository.deleteById(id_peticion);
		return "se elimino el dato en BD (งツ)ว(งツ)ว(งツ)ว";
	}

}
