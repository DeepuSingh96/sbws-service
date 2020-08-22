package com.tcs.sbws.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.tcs.sbws.filters.JwtRequestFilter;
import com.tcs.sbws.service.UserService;




@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	
	 @Autowired
	 UserService userService;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		
		auth.userDetailsService(userService);
	}
	
	protected void configure(HttpSecurity http) throws Exception {
	
//		
//		http.csrf().disable()
//	    .authorizeRequests().anyRequest().authenticated()
//	    .and().httpBasic()
//	    .and().sessionManagement().disable().
//	    exceptionHandling().and().sessionManagement()
//		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		
		
		http.csrf().disable()
		.cors().and()
		.authorizeRequests().antMatchers("/login").permitAll()
		 .antMatchers("/admin","/dashboard/**").hasRole("ADMIN")
	        .antMatchers("/user","/dashboard/**").hasAnyRole("ADMIN", "USER")
				.anyRequest().authenticated().and().
				exceptionHandling().and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		  
    // http.csrf().disable();
    //	  http.headers().frameOptions().disable();
          
         
		
//		http.csrf().disable()
//		//.authorizeRequests().antMatchers("/hello").permitAll()
//		.authorizeRequests().antMatchers("/login1","/hello").permitAll()
//		 .antMatchers("/h2-console/**").permitAll()
//		.anyRequest().authenticated().and().
//		exceptionHandling().and().sessionManagement()
//		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//		http.csrf().disable();
//		http.headers().frameOptions().disable();
	}
	
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	 return new BCryptPasswordEncoder();
	}
}
