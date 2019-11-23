package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter{
	@Bean
	public AuthenticationManager authMg() throws Exception {
		return super.authenticationManagerBean();
	}
	
	//DEFINICIÓN ROLES Y USUARIOS
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
        .inMemoryAuthentication()
        .withUser("user1")
          .password("{noop}user1") //lo de {noop} se pone para no obligar a usar mecanismo de encriptación
          .roles("USER")
          .and()
        .withUser("admin")
          .password("{noop}admin")
          .roles("USER", "ADMIN");
		
		/*lo siguiente sería para el caso de que
		 * quisiéramos encriptar la password:
		 * auth
	        .inMemoryAuthentication()
	        .withUser("user1")
	          .password(new BCryptPasswordEncoder().encode("user1"))
	          .roles("USER")
	          .and()
	        .withUser("admin")
	          .password(new BCryptPasswordEncoder().encode("admin"))
	          .roles("USER", "ADMIN");
		 */
		
		/*LA SEGUIENTE CONFIGURACIÓN SERÍA PARA EL CASO DE USUARIOS EN UNA BASE DE DATOS
		 * auth.jdbcAuthentication().dataSource(dataSource)
        	.usersByUsernameQuery("select username, password, enabled from users where username=?")
        	.authoritiesByUsernameQuery("select username, authority from authorities where username=?");
		 */
	}

//	DEFINICION DE POLITICAS DE SEGURIDAD
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET,"/lista").hasRole("ADMIN")	//QUE EL ROL ADMIN SOLO PUEDE ENTRAR AL METODO GET DE LISTA
		.antMatchers("/lista").authenticated()	//QUE AL RESTO DE LOS REQUEST PUEDE ENTRAR CUALQUIERA AUTENTICADO MENOS EL GET
//		.antMatchers("/**").authenticated()		//QUE CUALQUIER PERSONA AUTENTICADA PUEDE ENTRAR A CUALQUIER RUTA Y METODO
		.and()
		.httpBasic();	//TIPO DE AUTENTICACION
	}	
}
