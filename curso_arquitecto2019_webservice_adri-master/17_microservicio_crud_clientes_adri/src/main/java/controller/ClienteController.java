package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Cliente;
import service.ServiceCliente;

@RestController
public class ClienteController {
	@Autowired
	ServiceCliente sCliente;
	
	@GetMapping (value = "/opercliente/{usuario}/{password}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <Cliente> autenticar(@PathVariable("usuario") String usuario,
							  					@PathVariable("password") String password) {
		Cliente cliente= sCliente.autenticar(usuario, password);
		HttpStatus estado;
		if(cliente!=null) {
			estado= HttpStatus.ACCEPTED;
		}else {
			estado=HttpStatus.BAD_REQUEST;
		}
		ResponseEntity<Cliente> response=new ResponseEntity<Cliente>(cliente, new HttpHeaders(),estado);
		return response;
	}
	
	@DeleteMapping (value = "/opercliente/{idCliente}")
	public void eliminarPorId(@PathVariable("idCliente") int idCliente) {
		if(sCliente.buscarPorDni(idCliente)) {
		sCliente.eliminar(idCliente);
		}
	}
	
	@PostMapping (value = "/opercliente", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Cliente alta(@RequestBody Cliente cliente) {
		sCliente.alta(cliente);
		return cliente;
	}
	
	

}
