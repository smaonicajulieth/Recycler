package co.edu.poli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.model.CentrosReciclaje;
import co.edu.poli.repository.Centro_repository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/proyect/centroReciclaje")
public class CentroController {

	@Autowired
	private Centro_repository centro_repository;

	public CentroController() {

	}

	@PostMapping("/envioDato")
	@ApiOperation(value = "Guardar Centro de reciclaje", notes = "Guarda en la base un centro nuevo de reciclaje")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error al guardar"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "El centro ha sido registrado")})
	public String insertCentro(@RequestBody CentrosReciclaje centrosReciclaje) {
		centro_repository.save(centrosReciclaje);
		return "el dato ha sido enviado a BD (งツ)ว(งツ)ว(งツ)ว";
	}

	@PostMapping("/envioDatos")
	@ApiOperation(value = "Guardar unas lista de Centro de reciclaje", notes = "Guarda en la base una lista de centros nuevos de reciclaje")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error al guardar"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "Los centros han sido registrado")})
	public String insertCentros(@RequestBody List<CentrosReciclaje> centrosReciclaje) {
		centro_repository.saveAll(centrosReciclaje);
		return "los datos han sido enviados a BD  (งツ)ว(งツ)ว(งツ)ว";
	}

	@GetMapping("/obtenerDato/{code}")
	@ApiOperation(value = "Obtener un Centro de reciclaje", notes = "Buscar y obtener un Centro de reciclaje dependiendo el codigo")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "Se han retornado los datos")})
	public CentrosReciclaje selectCentro(@PathVariable String id_centrosReciclaje) {
		return centro_repository.findById(id_centrosReciclaje).get();
	}
	
	@GetMapping("/obtenerDatos")
	@ApiOperation(value = "Obtener Centros de reciclaje", notes = "Busca y retorna todos los centros de reciclaje que estan creados")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error al buscar"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "La lista se ha devuelto con exito")})
	public List<CentrosReciclaje> selectCentros() {
		return centro_repository.findAll();
	}

	@PutMapping("/actualizarDato/{code}")
	@ApiOperation(value = "Editar Centros de reciclaje", notes = "Edita uno de los centros de reciclaje dependiendo el codigo que se ingrese")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error editar"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "Se ha editado con exito el centro de reciclaje")})
	public String updateCentro(@PathVariable String id_centrosReciclaje,
			@RequestBody CentrosReciclaje centrosReciclaje) {

		CentrosReciclaje centrosReciclajeUpdate = centro_repository.findById(id_centrosReciclaje).get();
		centrosReciclajeUpdate.setNombre(centrosReciclaje.getNombre());
		centrosReciclajeUpdate.setDescripcion(centrosReciclaje.getDescripcion());
		centrosReciclajeUpdate.setDireccion(centrosReciclaje.getDireccion());
		centrosReciclajeUpdate.setCorreo(centrosReciclaje.getCorreo());
		centrosReciclajeUpdate.setPaginaWeb_link(centrosReciclaje.getPaginaWeb_link());
		centrosReciclajeUpdate.setRedSocial_link(centrosReciclaje.getRedSocial_link());
		centro_repository.save(centrosReciclajeUpdate);
		return "dato actualizado en BD  (งツ)ว(งツ)ว(งツ)ว";
	}
	
	
	@DeleteMapping("/eliminarDato/{code}")
	@ApiOperation(value = "Eliminar Centros de reciclaje", notes = "Elimina uno de los centros de recoclaje dependiendo el codigo que se ingrese")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error eliminar"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "Se ha eliminado con exito el centro de reciclaje")})
	public String deleteCentro(@PathVariable String id_centrosReciclaje) {
		centro_repository.deleteById(id_centrosReciclaje);
		return "se elimino el dato en BD (งツ)ว(งツ)ว(งツ)ว";
	}
	@ApiOperation(value = "Buscar Centros de reciclaje por nombre", notes = "Busca uno de los centros de recoclaje segun el nombre que se ingrese")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "Se ha editado con exito el centro de reciclaje")})
	@GetMapping("/buscarCentro/{nombre}")
	public List<CentrosReciclaje> buscarCentros(@PathVariable String nombre) {
		return centro_repository.buscarCentros(nombre);
	}

}
