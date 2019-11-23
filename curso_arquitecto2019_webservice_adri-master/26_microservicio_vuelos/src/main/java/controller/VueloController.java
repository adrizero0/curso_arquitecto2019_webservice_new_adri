package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Vuelo;
import service.ServiceVuelos;

@CrossOrigin(origins = "*")
@RestController
public class VueloController {
	@Autowired
	ServiceVuelos sVuelos;
	
	@GetMapping (value = "/vuelos/{plazas}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> autenticar(@PathVariable("plazas") int plazas) {
		return sVuelos.getVuelosDisponibles(plazas);
	}
	
	@PutMapping (value = "/vuelos/{idVuelo}/{plazas}", produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity <String> actualizar(@PathVariable("idVuelo") int idVuelo,
									@PathVariable("plazas") int plazas) {
		HttpStatus estado;
		boolean actualizar=sVuelos.actualizarVuelo(idVuelo, plazas);
		
		if(!actualizar) {
			estado= HttpStatus.BAD_REQUEST;
		}else {
			estado= HttpStatus.OK;
		}
		ResponseEntity <String> response=new ResponseEntity<String> ("vuelos", new HttpHeaders(),estado);
		return response;
	}

}