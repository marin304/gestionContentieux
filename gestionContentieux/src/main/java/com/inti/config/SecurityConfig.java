package com.inti.config;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import com.inti.service.interfaces.IAppUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private IAppUserDetailsService appUserDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(appUserDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/gestionContentieux/**").hasRole("ADMIN") // Il y avait "/affaires/**" dans antMatchers
				.antMatchers("/phases/**").hasRole("AVOCAT") // Il y avait "/phases/**" dans antMatchers
				.antMatchers("/login*").permitAll()
				.anyRequest().authenticated()
			.and()
			.cors()
			.and()
			.formLogin()
				.loginProcessingUrl("/login")
			.and()
			.logout()
				.logoutUrl("/logout")
				.deleteCookies("JSESSIONID").permitAll()
			.and()
			.httpBasic()
			.and();
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSourc() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		
		config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		config.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH"));
		config.setAllowCredentials(true);
		config.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
		source.registerCorsConfiguration("/**", config);
		
		return source;
	}
}