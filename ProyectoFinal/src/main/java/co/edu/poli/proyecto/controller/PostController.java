package co.edu.poli.proyecto.controller;

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
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.proyecto.model.Posteo;
import co.edu.poli.proyecto.repository.Post_repository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/proyect/post")
public class PostController {

	@Autowired
	private Post_repository post_repository;

	public PostController() {

	}
	/*
	 * Metodo para insertar un post
	 */

	@PostMapping("/envioDato")
	@ApiOperation(value = "Guardar el post del usuario", notes = "Guardar la informacion del post en la base de datos")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error al enviar"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "El post se ha enviado")})
	public Posteo insertPost(@RequestBody Posteo post) {
		post_repository.save(post);
		return post;
	}

	@PostMapping("/envioDatos")
	@ApiOperation(value = "Guardar los posts de los usuarios", notes = "Guarda la informacion de los posts en la base de datos")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error al enviar"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "Los post se han enviado")})
	public String insertPost(@RequestBody List<Posteo> post) {
		post_repository.saveAll(post);
		return "los datos han sido enviados a BD  (งツ)ว(งツ)ว(งツ)ว";
	}
	/*
	 * Metodo para obtener un post   
	 */

	@GetMapping("/obtenerDato/{code}")
	@ApiOperation(value = "Obtener dato del  post del usuario", notes = "Obtiene un post del usuario")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error al obtener"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "Se ha obtenido el post")})
	public Posteo selectPost(@PathVariable String id_post) {
		return post_repository.findById(id_post).get();
	}

	@GetMapping("/obtenerDatos")
	@ApiOperation(value = "Obtener datos de los posts del usuario ", notes = "Busca y obtiene los posts del usuario ")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error al obtener los posts"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "se ha obtenidos los posts")})
	public List<Posteo> selectPost() {
		return post_repository.findAll();
	}
	/*
	 * Metodo para actualizar un post 
	 */

	@PutMapping("/actualizarDato/{code}")
	@ApiOperation(value = "Actualizar post del usuario ", notes = "Actualiza los datos necesarios del post del usuario ")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error al actualizar"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "Se ha actualizado el post")})
	public String updatePost(@PathVariable String id_usuario, @RequestBody Posteo post) {

		Posteo usuarioUpdate = post_repository.findById(id_usuario).get();
		usuarioUpdate.setTitulo(post.getTitulo());
		usuarioUpdate.setDescripcion(post.getDescripcion());
		usuarioUpdate.setCategoria(post.getCategoria());
		usuarioUpdate.setUsuario(post.getUsuario());
		post_repository.save(usuarioUpdate);
		return "dato actualizado en BD  (งツ)ว(งツ)ว(งツ)ว";
	}
	/*
	 * Metodo para eliminar un post
	 */

	@DeleteMapping("/eliminarDato/{code}")
	@ApiOperation(value = "Elimina el post del usuario", notes ="Elimina el post del usuario en la base de datos")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error al eliminar"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "El post se ha eliminado")})
	public String deletePost(@PathVariable String id_post) {
		post_repository.deleteById(id_post);
		return "se elimino el dato en BD (งツ)ว(งツ)ว(งツ)ว";
	}

	@GetMapping("/filtroPosts/{categoria}")
	@ApiOperation(value = "Mostrar los posts segun la categoria  ", notes = "Muesta la informacion del los posts pertenecientes a esa categoria")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Error al mostrar post"),@ApiResponse(code = 403, message = "No tiene permiso para realizar esta accion"),
			@ApiResponse(code = 200, message = "Retonrna lista de post")})
	public List<Posteo> mostrarPost(@PathVariable String categoria) {
		return post_repository.mostrarPost(categoria);
	}

}
