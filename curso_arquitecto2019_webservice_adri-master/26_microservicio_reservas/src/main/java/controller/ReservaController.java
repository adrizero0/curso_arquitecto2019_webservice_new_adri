package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import model.Reserva;
import model.ReservaView;
import service.ServiceReservas;

@CrossOrigin(origins = "*")
@RestController
public class ReservaController {
	@Autowired
	ServiceReservas sReservas;
	
	@Autowired
	RestTemplate template;
	
	@Value("${client.url.vuelos}")
	String url;
	
	@GetMapping(value = "/reservas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Reserva> obtenerReservas(){
		return sReservas.getReservas();		
	}
	
	@PostMapping (value = "/reservas", consumes =MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> reservar(@RequestBody ReservaView reservaV) {
		HttpStatus estado;	
	    ResponseEntity<String> responseVuelos = template.exchange(url+reservaV.getReserva().getVuelo()+"/"+reservaV.getPlazas(), 
	    													HttpMethod.PUT, null, String.class);
		if(responseVuelos.getStatusCodeValue()==200) {
			sReservas.reservar(reservaV.getReserva());
			estado= HttpStatus.OK;
		}else {
			estado= HttpStatus.BAD_REQUEST;
		}
		ResponseEntity <String> response=new ResponseEntity<String> ("reserva", new HttpHeaders(),estado);
		return response;
	}

	
}