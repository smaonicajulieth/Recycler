package co.edu.poli.proyecto.controller;
/*
 * @author Julian Camargo,Cesar Reyes,Monica Rodriguez 
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.proyecto.model.Mail;
import co.edu.poli.proyecto.model.CentroReciclaje;
import co.edu.poli.proyecto.repository.Centro_repository;
import co.edu.poli.proyecto.services.MailService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/proyect/centroReciclaje")
public class CentroController {
	
	@Autowired
	private Centro_repository centro_repository;

	public CentroController() {

	}


	/*
	 * Metodo para insertar un centro de reciclaje
	 */
	@PostMapping("/envioDato")
	@ApiOperation(value = "Guardar Centro de reciclaje", notes = "Guarda en la base un centro nuevo de reciclaje")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error al guardar"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "El centro ha sido registrado")})
	public String insertCentro(@RequestBody CentroReciclaje CentroReciclaje) {
		centro_repository.save(CentroReciclaje);
		return "el dato ha sido enviado a BD (งツ)ว(งツ)ว(งツ)ว";
	}

	@PostMapping("/envioDatos")
	@ApiOperation(value = "Guardar unas lista de Centro de reciclaje", notes = "Guarda en la base una lista de centros nuevos de reciclaje")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error al guardar"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "Los centros han sido registrado")})
	public String insertCentros(@RequestBody List<CentroReciclaje> CentroReciclaje) {
		centro_repository.saveAll(CentroReciclaje);
		return "los datos han sido enviados a BD  (งツ)ว(งツ)ว(งツ)ว";
	}

	@GetMapping("/obtenerDato/{code}")
	@ApiOperation(value = "Obtener un Centro de reciclaje", notes = "Buscar y obtener un Centro de reciclaje dependiendo el codigo")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "Se han retornado los datos")})

	/*
	 * Metodo para obtener un centro de reciclaje 
	 */
	public CentroReciclaje selectCentro(@PathVariable String code) {
		return centro_repository.findById(code).get();
	}

	@GetMapping("/obtenerDatos")
	@ApiOperation(value = "Obtener Centros de reciclaje", notes = "Busca y retorna todos los centros de reciclaje que estan creados")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error al buscar"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "La lista se ha devuelto con exito")})
	public List<CentroReciclaje> selectCentros() {
		return centro_repository.findAll();
	}
	/*
	 * Metodo para actualizar un centro de reciclaje 
	 */
	@PutMapping("/actualizarDato/{code}")
	@ApiOperation(value = "Editar Centros de reciclaje", notes = "Edita uno de los centros de reciclaje dependiendo el codigo que se ingrese")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error editar"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "Se ha editado con exito el centro de reciclaje")})
	public String updateCentro(@PathVariable String code,
			@RequestBody CentroReciclaje CentroReciclaje) {

		CentroReciclaje CentroReciclajeUpdate = centro_repository.findById(code).get();
		CentroReciclajeUpdate.setNombre(CentroReciclaje.getNombre());
		CentroReciclajeUpdate.setDescripcion(CentroReciclaje.getDescripcion());
		CentroReciclajeUpdate.setDireccion(CentroReciclaje.getDireccion());
		CentroReciclajeUpdate.setCorreo(CentroReciclaje.getCorreo());
		centro_repository.save(CentroReciclajeUpdate);
		return "dato actualizado en BD  (งツ)ว(งツ)ว(งツ)ว";
	}
	
	/* 
	 * Metodo para eliminar un centro de reciclaje 
	 */


	@DeleteMapping("/eliminarDato/{code}")
	@ApiOperation(value = "Eliminar Centros de reciclaje", notes = "Elimina uno de los centros de recoclaje dependiendo el codigo que se ingrese")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error eliminar"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "Se ha eliminado con exito el centro de reciclaje")})
	public CentroReciclaje deleteCentro(@PathVariable String code) {
		CentroReciclaje centrodb = centro_repository.findById(code).get();
		centro_repository.delete(centrodb);
		return centrodb;
	}
	@ApiOperation(value = "Buscar Centros de reciclaje por nombre", notes = "Busca uno de los centros de reciclaje segun el nombre que se ingrese")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "Se buscado con exito el centro de reciclaje")})
	@GetMapping("/buscarCentro/{nombre}")
	public List<CentroReciclaje> buscarCentros(@PathVariable String nombre) {
		return centro_repository.buscarCentros(nombre);
	}

	@PutMapping("/actualizarEstado/{code}")
	@ApiOperation(value = "Editar Centros de reciclaje", notes = "Edita uno de los centros de reciclaje dependiendo el codigo que se ingrese")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error editar"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "Se ha editado con exito el centro de reciclaje")})
	public String updateEstado(@PathVariable String code,
			@RequestBody CentroReciclaje CentroReciclaje) {

		CentroReciclaje CentroReciclajeUpdate = centro_repository.findById(code).get();
		CentroReciclajeUpdate.setNombre(CentroReciclaje.getNombre());
		CentroReciclajeUpdate.setDescripcion(CentroReciclaje.getDescripcion());
		CentroReciclajeUpdate.setDireccion(CentroReciclaje.getDireccion());
		CentroReciclajeUpdate.setCorreo(CentroReciclaje.getCorreo());
		CentroReciclajeUpdate.setEstado(CentroReciclaje.getEstado());

		centro_repository.save(CentroReciclajeUpdate);
		return "dato actualizado en BD  (งツ)ว(งツ)ว(งツ)ว";
	}

	@GetMapping("/obtenerDatosEstados/{estado}")
	@ApiOperation(value = "Obtener Centros de reciclaje segun estado", notes = "Busca y retorna todos los centros de reciclaje que tienen el tipo de estado solicitado")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error al buscar"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "La lista se ha devuelto con exito")})
	public List<CentroReciclaje> selectCentrosEstados(@PathVariable String estado) {
		return centro_repository.buscarEstados(estado);
	}

	@Autowired
	private MailService notificationService;

	@RequestMapping(value = "/enviarMail", method=RequestMethod.POST)
	@ApiOperation(value = "Enviar mensaje", notes = "Envia un correo electronico a los usuarios")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error al enviar"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "Se ha enviado con exito el mail")})
	public String sendEmail(@RequestBody Mail mail){
		notificationService.sendEmail(mail);
		return "Email sent successfully";
	}



}
