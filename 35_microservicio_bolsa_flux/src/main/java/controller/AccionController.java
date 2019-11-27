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
	@GetMapping (value = "/acciones", produces="text/event-stream")
	public Flux<Accion> obtenerAcciones() {
		List<Accion> lista= sAccion.getAcciones();
		lista.add(new Accion(0, "EOF", 0));
		return Flux.fromIterable(lista);		
	}
	
	@CrossOrigin(origins="*")
	@GetMapping(value="/continuo",produces="text/event-stream")
	public Flux<List<Accion>> getAcciones(){
		return Flux.create(fs->{
			List<Accion> anterior=null;
			while(true) {
				List<Accion> lista=sAccion.getAcciones();
				if(cambio(anterior,lista)) {
					fs.next(lista);
				}
				anterior=lista;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
	}
	private boolean cambio(List<Accion> anterior,List<Accion> actual ) {
		
		if(anterior==null) {
			return true;
		}else {
			for(int i=0;i<actual.size();i++) {
				if(anterior.get(i).getValor()!=actual.get(i).getValor()){
					return true;
				}
			}
		}
		return false;
	}
}