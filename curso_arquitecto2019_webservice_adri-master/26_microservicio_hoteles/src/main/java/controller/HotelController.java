package controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Hotel;
import service.ServiceHoteles;

@CrossOrigin(origins = "*")
@RestController
public class HotelController {

	@Autowired
	ServiceHoteles serviceHoteles;
	
	@GetMapping(value = "/lista", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> obtenerHotelesDisponibles(){
		return serviceHoteles.hotelesDisponibles();
		
	}
	
}
