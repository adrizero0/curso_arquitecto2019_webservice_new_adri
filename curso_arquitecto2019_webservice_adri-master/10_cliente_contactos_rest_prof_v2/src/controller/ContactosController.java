package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import model.Contacto;

@Controller
public class ContactosController {
	@Autowired
	RestTemplate template;
	String url="http://localhost:8080/07_crud_contactos_rest/contactos";
	
	@GetMapping("/doContactos")
	public String obtenerContactos(HttpServletRequest request) {
		Contacto[] contactos=template.getForObject(url, Contacto[].class);
		request.setAttribute("contactos", contactos);
		return "contactos";
	}
	
	@GetMapping("/doEliminar")
	public String eliminar(@RequestParam("idContacto") int idContacto) {
		template.delete(url+"/"+idContacto);
		return "forward:/doContactos";
	}
	
}
