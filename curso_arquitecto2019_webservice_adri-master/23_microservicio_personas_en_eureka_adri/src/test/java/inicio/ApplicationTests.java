package inicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import controller.PersonasController;
import model.Persona;
@RunWith(SpringRunner.class)
@SpringBootTest(classes=PersonasController.class)
class ApplicationTests {
	@Autowired
	//private TestRestTemplate restTemplate;
	PersonasController controller;
	
	@Test
	void testPersonas() {
		//Persona[] res=restTemplate.getForObject("http://localhost:9000/lista", Persona[].class);
		List<Persona> personas= controller.recuperarPersonas();
		assertEquals(personas.size(), 3);
	}

}
