package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import model.Hotel;
import model.Reserva;
import model.ReservaView;
import model.Vuelo;

@RestController
public class BuscadorController {
	@Autowired
	RestTemplate template;
	
	@Value("${client.url.vuelos}")
	String urlVuelos;
	
	@Value("${client.url.hoteles}")
	String urlHoteles;
	
	@Value("${client.url.reservas}")
	String urlReservas;	
	
	@GetMapping(value= "/{plazas}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> obtenerVuelos(@PathVariable("plazas") int plazas) {
		return (List<Vuelo>) template.getForEntity(urlVuelos, Vuelo[].class);		
	}
	
	@GetMapping(value= "/lista", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> obtenerHoteles() {
		return (List<Hotel>) template.getForEntity(urlHoteles, Hotel[].class);		
	}
	
	@GetMapping(value= "/reservas", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Reserva> obtenerReservas() {
		return (List<Reserva>) template.getForEntity(urlReservas, Reserva[].class);
	}
	
	@PostMapping (value = "/reservas", consumes =MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> reservar(@RequestBody ReservaView reservaV) {
		HttpStatus estado;
	    ResponseEntity<String> responseReserva = template.postForEntity(urlReservas, null, String.class);
		if(responseReserva.getStatusCodeValue()==200) {
			estado= HttpStatus.OK;
		}else {
			estado= HttpStatus.BAD_REQUEST;
		}
		ResponseEntity <String> response=new ResponseEntity<String> ("reservado", new HttpHeaders(),estado);
		return response;
	}
	
	
	
}
