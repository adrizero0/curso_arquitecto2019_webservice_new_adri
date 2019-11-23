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
	String url="http://localhost:8080/07_crud_contactos_rest/contactos";
	@GetMapping(value="/toAlta")
	public String inicio(Model model) {
		Contacto cl=new Contacto();
		model.addAttribute("contacto",cl);
		return "alta";
	}
	//es ejecutado al producirse el submit del formulario
	//de la página de registro
	@PostMapping(value="/doAlta")
	public String alta(@ModelAttribute("contacto") Contacto contacto) {
		template.postForLocation(url, contacto);
		return "menu";
	}
	
}
