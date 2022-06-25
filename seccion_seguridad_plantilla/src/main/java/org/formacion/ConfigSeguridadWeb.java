package org.formacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Clase de configuracion especifica para los aspectos de seguridad
 * 
 * @EnableWebSecurity hace que spring añada la configuracion de seguridad cuando crea la aplicacion web

 * ExtenderWebSecurityConfigurerAdapter nos permite actuar en la configuracion de la seguridad web. En nuestro caso
 * actuaremos sobre el objeto HttpSecurity (parametro del metodo configuer) para definir que URLs queremos proteger
 * y con que restricciones
 */
@Configuration
@EnableWebSecurity
public class ConfigSeguridadWeb extends WebSecurityConfigurerAdapter {

	/**
	 * Configura la seguridad HTTP en dos aspectos:
	 *   - que rol exigimos para acceder a cada URL
	 *   - que mecanismo de autenticacion usamos. Es decir, como recogemos las credenciales del usuario
	 */
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()  // pasamos a detallar que urls protegemos y como
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/gestion/**").hasAnyRole("ADMIN","GESTOR")
                .and()
            .httpBasic() // autenticacion via BASIC (pop up del navegador). Pordia ser de otra forma, p.e. pagina de login
            .and()
               // Por defecto, el logout solo se hace con peticiones POST. Si queremos que tambien acepte peticiones
               // GET hemos de añadir el logoutRequestMatcher.
               // Cuando se realice el logout, ira a la pagina /public.xml
            .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/public.txt")
               .deleteCookies("JSESSIONID")
               .invalidateHttpSession(true)
            ;
    }
	
    @Autowired
    public void configuracionGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                  // en un cambio hecho con posterioridad al curso, Spring Security ha hecho obligatorio proporcionar
                  // el codificador de passords usado. En este ejemplo, usamos un NoOp que, evidentement solo se usaria
                  // para pruebas. 
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("gestor").password("gestor").roles("GESTOR").and()
                .withUser("admin").password("admin").roles("ADMIN");
    }

}
