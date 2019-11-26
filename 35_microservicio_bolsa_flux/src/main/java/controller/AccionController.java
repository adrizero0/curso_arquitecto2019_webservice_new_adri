package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Accion;
import reactor.core.publisher.Flux;
import service.AccionService;

@CrossOrigin(origins = "*")
@RestController
public class AccionController {
	@Autowired
	AccionService sAccion;
	
	@CrossOrigin(origins = "*")
	@GetMapping (value = "/vuelos/{plazas}", produces="text/event-stream")
	public Flux<Accion> obtenerAcciones() {
		List<Accion> lista= sAccion.getAcciones();
		return Flux.fromIterable(lista);		
	}
}