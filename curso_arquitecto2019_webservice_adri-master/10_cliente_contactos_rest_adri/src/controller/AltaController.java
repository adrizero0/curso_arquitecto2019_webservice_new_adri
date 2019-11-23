package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import model.Contacto;

@Controller
public class AltaController {
	@Autowired
	RestTemplate template;
	
	String url="http://localhost:8080/07_crud_contactos_rest_adri/contactos";
	
	@GetMapping(value = "/toAltaContacto")
	public String inicio(Model model) {
		Contacto co=new Contacto();
		model.addAttribute("contacto",co);
		return "altacontacto";
	}
	
	@PostMapping(value="/doAltaContacto")
	public String nuevoContacto(@ModelAttribute("contacto") Contacto contacto) {
		template.postForLocation(url, contacto);
		return "entrada";
	}	
	
}
