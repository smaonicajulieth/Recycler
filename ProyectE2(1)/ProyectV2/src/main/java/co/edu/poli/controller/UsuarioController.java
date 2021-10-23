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

import co.edu.poli.model.Usuario;
import co.edu.poli.repository.Usuario_repository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/proyect/usuario")
public class UsuarioController {

	@Autowired
	private Usuario_repository usuario_repository;

	public UsuarioController() {

	}

	@PostMapping("/envioDato")
	@ApiOperation(value = "Guardar Usuario", notes = "Guarda en la base un usuario nuevo")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error al guardar"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "El centro ha sido registrado")})
	public String insertUsuario(@RequestBody Usuario usuario) {
		usuario_repository.save(usuario);
		return "el dato ha sido enviado a BD (งツ)ว(งツ)ว(งツ)ว";
	}

	@PostMapping("/envioDatos")
	@ApiOperation(value = "Guardar una lista de Usuarios", notes = "Guarda en la base una lista de usuarios nuevos")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error al guardar"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "Los centros han sido registrado")})
	public String insertUsuario(@RequestBody List<Usuario> usuario) {
		usuario_repository.saveAll(usuario);
		return "los datos han sido enviados a BD  (งツ)ว(งツ)ว(งツ)ว";
	}

	@GetMapping("/obtenerDato/{code}")
	@ApiOperation(value = "Obtener un Usuario", notes = "Buscar y obtener un usuario dependiendo el id")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "Se han retornado los datos")})
	public Usuario selectUsuario(@PathVariable String id_usuario) {
		return usuario_repository.findById(id_usuario).get();
	}

	@GetMapping("/obtenerDatos")
	@ApiOperation(value = "Obtener Usuarios", notes = "Busca y retorna todos los usuarios que estan registrados")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error al buscar"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "La lista se ha devuelto con exito")})
	public List<Usuario> selectAuto() {
		return usuario_repository.findAll();
	}

	@PutMapping("/actualizarDato/{code}")
	@ApiOperation(value = "Editar Usuario", notes = "Edita uno de los usuarios dependiendo el codigo que se ingrese")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error editar"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "Se ha editado con exito el centro de reciclaje")})
	public String updateUsuario(@PathVariable String id_usuario, @RequestBody Usuario usuario) {

		Usuario usuarioUpdate = usuario_repository.findById(id_usuario).get();
		usuarioUpdate.setUsuario(usuario.getUsuario());
		usuarioUpdate.setContraseña(usuario.getContraseña());
		usuarioUpdate.setCorreo(usuario.getCorreo());
		usuarioUpdate.setActivo(usuario.isActivo());
		usuarioUpdate.setPeticion(usuario.getPeticion());
		usuarioUpdate.setPost(usuario.getPost());
		usuario_repository.save(usuarioUpdate);
		return "dato actualizado en BD  (งツ)ว(งツ)ว(งツ)ว";
	}

	@DeleteMapping("/eliminarDato/{code}")
	@ApiOperation(value = "Eliminar Usuario", notes = "Elimina uno de los Usuarios dependiendo el codigo que se ingrese")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error editar"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "Se ha eliminado con exito el centro de reciclaje")})
	public String deleteUsuario(@PathVariable String id_usuario) {
		usuario_repository.deleteById(id_usuario);
		return "se elimino el dato en BD (งツ)ว(งツ)ว(งツ)ว";
	}

}
