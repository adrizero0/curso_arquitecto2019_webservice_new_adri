package inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = {"controller"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public RestTemplate getTemplate() {
		RestTemplate template=new RestTemplate();
		//CREAMOS INTERCEPTOR DE AUTENTICACIÓN
		BasicAuthenticationInterceptor intercep=new BasicAuthenticationInterceptor("admin", "admin");
		//ASOCIAMOS INTERCEPTOR A RESTTEMPLATE
		template.getInterceptors().add(intercep);
		return template;
	}

}
