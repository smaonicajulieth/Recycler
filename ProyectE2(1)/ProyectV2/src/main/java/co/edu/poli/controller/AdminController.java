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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.model.Admin;
import co.edu.poli.model.Mail;
import co.edu.poli.repository.Admin_repository;
import co.edu.poli.services.MailService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/proyect/administrador")
public class AdminController {
	@Autowired
	private Admin_repository admin_repository;
	
	public AdminController() {

	}

	@PostMapping("/envioDato")
	@ApiOperation(value = "Guardar Admin", notes = "Guarda en la base un nuevo administrador")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error al guardar"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "El admin ha sido registrado")})
	public String insertAdmin(@RequestBody Admin admin) {
		admin_repository.save(admin);
		return "el dato ha sido enviado a BD (งツ)ว(งツ)ว(งツ)ว";
	}

	@PostMapping("/envioDatos")
	@ApiOperation(value = "Guardar unas lista de Admins", notes = "Guarda en la base una lista de administradores nuevos")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error al guardar"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "Los administradores han sido registrados")})
	public String insertAdmin(@RequestBody List<Admin> admin) {
		admin_repository.saveAll(admin);
		return "los datos han sido enviados a BD  (งツ)ว(งツ)ว(งツ)ว";
	}

	@GetMapping("/obtenerDato/{code}")
	@ApiOperation(value = "Obtener un Administrador", notes = "Buscar y obtener un Administrador dependiendo el codigo")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "Se han retornado los datos")})
	public Admin selectAdmin(@PathVariable String id_admin) {
		return admin_repository.findById(id_admin).get();
	}

	@GetMapping("/obtenerDatos")
	@ApiOperation(value = "Obtener Administradores", notes = "Busca y retorna todos los administradores que estan creados")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error al buscar"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "La lista se ha devuelto con exito")})
	public List<Admin> selectAdmin() {
		return admin_repository.findAll();
	}

	@PutMapping("/actualizarDato/{code}")
	@ApiOperation(value = "Editar Admin", notes = "Edita uno de Administradores dependiendo el codigo que se ingrese")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error editar"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "Se ha editado con exito el administrador")})
	public String updateAdmin(@PathVariable String id_admin, @RequestBody Admin admin) {

		Admin adminUpdate = admin_repository.findById(id_admin).get();
		adminUpdate.setAdministrador(admin.getAdministrador());
		adminUpdate.setContraseña(admin.getContraseña());
		adminUpdate.setCorreo(admin.getCorreo());
		adminUpdate.setActivo(admin.isActivo());
		adminUpdate.setPeticion(admin.getPeticion());
		adminUpdate.setPost(admin.getPost());
		adminUpdate.setCentros(admin.getCentros());
		adminUpdate.setUsuarios(admin.getUsuarios());
		admin_repository.save(adminUpdate);
		return "dato actualizado en BD  (งツ)ว(งツ)ว(งツ)ว";
	}

	@DeleteMapping("/eliminarDato/{code}")
	@ApiOperation(value = "Eliminar Administrador", notes = "Elimina uno de los administradores dependiendo el codigo que se ingrese")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error eliminar"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "Se ha eliminado con exito el administrador")})
	public String deleteAdmin(@PathVariable String id_admin) {
		admin_repository.deleteById(id_admin);
		return "se elimino el dato en BD (งツ)ว(งツ)ว(งツ)ว";
	}
	
	@Autowired
	private MailService notificationService;
	

	@RequestMapping(value = "/enviarMail", method=RequestMethod.GET)
	@ApiOperation(value = "Enviar mensaje", notes = "Envia un correo electronico a los usuarios")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error al enviar"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "Se ha enviado con exito el mail")})
	public String sendEmail(@RequestBody Mail mail){
		notificationService.sendEmail(mail);
		return "Email sent successfully";
	}
	
	
}
