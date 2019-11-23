package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Contacto;
import service.ServiceContacto;

@RestController
//(value = "/contactos")
public class ContactoController {
	@Autowired
	ServiceContacto sContacto;
	
	@GetMapping (value = "/contactos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Contacto> getContactos() {
		return sContacto.recuperarcontactos();
	}
	
	@GetMapping (value = "/contactos/{email}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Contacto getContactoPorEmail(@PathVariable("email") String email) {
		return sContacto.buscarPorEmail(email);		
	}
	
	@DeleteMapping (value = "/contactos/{id}")
	public void eliminarPorId(@PathVariable("id") int idContacto) {
		sContacto.eliminarPorId(idContacto);
	}
	
	@PostMapping (value = "/contactos", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void altaContacto(@RequestBody Contacto contacto) {
		sContacto.altaContacto(contacto);
	}	

//	@PutMapping (produces=MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public void actualizar(@RequestBody Contacto contacto) {
//		sContacto.altaContacto(contacto);
//	}
	
//	PARA RECIBIR PARAMENTROS A TRAVES DE QUERY STRING, SE MAPEA CON REQUEST PARAM
//	@GetMapping (value = "/contactos/actualiza")
//	public void actualiza(@RequestParam ("idcontacto") int idContacto,
//							  @RequestParam ("email") String email) {
//	}
	
}
