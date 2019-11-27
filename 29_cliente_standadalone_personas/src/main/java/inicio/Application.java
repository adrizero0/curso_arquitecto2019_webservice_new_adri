package inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(Application.class, args);
		AccesoServicio acceso=ctx.getBean(AccesoServicio.class);
		acceso.imprimirPersonas();
		
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}

	
}
