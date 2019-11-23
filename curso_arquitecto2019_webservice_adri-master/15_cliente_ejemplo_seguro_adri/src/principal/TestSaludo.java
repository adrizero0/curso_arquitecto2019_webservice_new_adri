package principal;

import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

import model.Item;

public class TestSaludo {

	public static void main(String[] args) {
//		DEFINIMOS LA URL
		String url= "http://localhost:8080/14_ejemplo_rest_seguro_adri/saludo";
		RestTemplate template=new RestTemplate();
		
		//CREAMOS INTERCEPTOR DE AUTENTICACION
		BasicAuthenticationInterceptor intercep=new BasicAuthenticationInterceptor("user2", "user2");
		
		//ASOCIAMOS EL INTERCEPTOR A REST TEMPLATE
		template.getInterceptors().add(intercep);
		
		//LLAMADA AL 1ER RECURSO
		String resultado=template.getForObject(url, String.class);
		System.out.println("Respuesta primer recurso "+resultado);
		
		//LAMADA AL 2DO RECURSO
		String resultado2=template.getForObject(url+"/profe", String.class);
		System.out.println("Respuesta segundo recurso "+resultado2);

		//LAMADA AL 3ER RECURSO
		Item item=template.getForObject(url, Item.class);
		System.out.println("Respuesta tercer recurso "+item.getNombre()+"-"+item.getEmail());
		
		//LAMADA AL 4TO RECURSO
		Item it=new Item("adri prueba zz", "zz@dfv.com", 12);
		String resultado3=template.postForObject(url, it, String.class);
		System.out.println("Respuesta cuarto recurso "+resultado3);
		
		//LLAMADA AL 5TO RECURSO
		template.delete(url+"/testing");
		
	}

}
