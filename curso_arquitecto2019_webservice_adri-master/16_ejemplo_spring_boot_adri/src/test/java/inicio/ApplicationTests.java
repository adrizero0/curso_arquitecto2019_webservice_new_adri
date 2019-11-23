package inicio;



import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import controller.SaludoController;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = {SaludoController.class})
class ApplicationTests {
	@Autowired
	SaludoController saludo;
	
	@Test
	void contextLoads() {
		assertEquals(saludo.contar("hola"),"4");
	}
}
