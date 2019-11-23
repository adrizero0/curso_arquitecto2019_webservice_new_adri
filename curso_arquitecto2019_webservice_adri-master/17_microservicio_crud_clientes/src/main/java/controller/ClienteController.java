package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Cliente;
import service.ServiceClientes;

@RestController
public class ClienteController {
	@Autowired
	ServiceClientes serviceClientes;
	
	@GetMapping(value="/opercliente/{user}/{pwd}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Cliente autenticar(@PathVariable("user") String user, @PathVariable("pwd") String pwd) {
		return serviceClientes.getCliente(user, pwd);
	}
	
	@PostMapping(value="/opercliente",produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public Cliente alta(@RequestBody Cliente cliente) {
		serviceClientes.guardarCliente(cliente);
		return cliente;
	}
	@DeleteMapping(value="/opercliente/{idCliente}")
	public void eliminar(@PathVariable("idCliente") int idCliente) {
		serviceClientes.eliminarCliente(idCliente);
	}
	
	
}
