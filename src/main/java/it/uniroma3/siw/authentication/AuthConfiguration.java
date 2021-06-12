package it.uniroma3.siw.authentication;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

import static it.uniroma3.siw.spring.model.Credentials.ADMIN_ROLE;
//import static it.uniroma3.siw.spring.model.Credentials.DEFAULT_ROLE;

/**
 * The AuthConfiguration is a Spring Security Configuration.
 * It extends WebSecurityConfigurerAdapter, meaning that it provides the settings for Web security.
 */
@Configuration //il framework la carica al momento dell'avvio dell'applicazione
@EnableWebSecurity //classe legata alla sicurezza dell'applicazione
public class AuthConfiguration extends WebSecurityConfigurerAdapter {

	/**
	 * The datasource is automatically injected into the AuthConfiguration (using its getters and setters)
	 * and it is used to access the DB to get the Credentials to perform authentication and authorization
	 */
	@Autowired
	DataSource datasource; //sorgente nella quale memorizziamo le credenziali

	/**
	 * This method provides the whole authentication and authorization configuration to use.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		// authorization paragraph: qui definiamo chi può accedere a cosa
		.authorizeRequests()
		// chiunque (autenticato o no) può accedere a queste risorse
		.antMatchers(HttpMethod.GET, "/", "/index", "/login", "/register", "/artisti", "/artista/**", 
				"/opera", "/collezioni", "/collezione", "/informazioni", "/css/**", "/js/**", 
				"/fonts/**", "/img/**", "/fragments/**", "/risorse").permitAll()
		
		// chiunque (autenticato o no) può mandare richieste POST
		.antMatchers(HttpMethod.POST, "/login", "/register").permitAll()
		
		// solo gli utenti autenticati con ruolo ADMIN possono accedere a risorse con path /admin/**
		.antMatchers(HttpMethod.GET, "/admin/**").hasAnyAuthority(ADMIN_ROLE)
		.antMatchers(HttpMethod.POST, "/admin/**").hasAnyAuthority(ADMIN_ROLE)

		// tutti gli utenti autenticati possono accere alle pagine rimanenti 
		.anyRequest().authenticated()

		// login paragraph: qui definiamo come è gestita l'autenticazione
		// usiamo il protocollo formlogin 
		.and().formLogin() //qui si potrebbe mettere il servizio di un ente esterno come Google o Amazon
		// la pagina di login si trova a /login
		// NOTA: Spring gestisce il post di login automaticamente dopo la pressione del bottone della pagina di login
		.loginPage("/login")
		// se il login ha successo, si viene rediretti al path /default
		.defaultSuccessUrl("/default")

		//in caso di fallimento
		/*.failureUrl("/login-error")*/

		// logout paragraph: qui definiamo il logout
		.and().logout() //.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		
		// il logout è attivato con una richiesta GET a "/logout"
		.logoutUrl("/logout")
		// in caso di successo, si viene reindirizzati alla /index page
		.logoutSuccessUrl("/index")        
		.invalidateHttpSession(true) //la sessione viene cancellata (i dati dell'utente autenticato)
		.clearAuthentication(true).permitAll(); //operazione permessa a chiunque
	}


	/*@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("user").password(passwordEncoder().encode("password")).roles("USER")
		.and()
		.withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");
	}*/



	/**
	 * This method provides the SQL queries to get username and password.
	 */
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		//use the autowired datasource to access the saved credentials
		.dataSource(this.datasource)
		//retrieve username and role
		.authoritiesByUsernameQuery("SELECT username, role FROM credentials WHERE username=?")
		//retrieve username, password and a boolean flag specifying whether the user is enabled or not (always enabled in our case)
		.usersByUsernameQuery("SELECT username, password, 1 as enabled FROM credentials WHERE username=?");
	}

	/**
	 * This method defines a "passwordEncoder" Bean.
	 * The passwordEncoder Bean is used to encrypt and decrpyt the Credentials passwords.
	 */
	@Bean //radice dei componenti di un'applicazione springboot
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); //oggetto usato per codificare le password
	}
}