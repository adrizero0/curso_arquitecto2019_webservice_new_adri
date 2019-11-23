package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import model.Persona;

@RestController
public class BuscadorController {
	@Autowired
	RestTemplate template;
	
	@Value("${client.url.inventada}")
	String url;
	
//	String url="http://localhost:8000/personas/lista";
	
	@GetMapping(value= "/buscar/{email}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Persona buscarPersona(@PathVariable("email") String email) {
		Persona persona=null;
		Persona[] personas=template.getForObject(url, Persona[].class);
		for(Persona p:personas) {
			if(p.getEmail().equals(email)) {
				persona=p;
			}
		}
		return persona;
	}	
}
