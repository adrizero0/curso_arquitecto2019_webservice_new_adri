package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import model.Cliente;

@Controller
public class LoginController {
	@Autowired
	RestTemplate template;
	String url="http://localhost:8080/11_servicio_login/login";
	
	@PostMapping("/doLogin")
	public String login(@RequestParam("user") String user,
						@RequestParam("pwd") String pwd) {
		
		Cliente cliente=template.getForObject(url+"/"+user+"/"+pwd, Cliente.class);
		return cliente!=null?"menu":"login";
	}
	
	
	
}
