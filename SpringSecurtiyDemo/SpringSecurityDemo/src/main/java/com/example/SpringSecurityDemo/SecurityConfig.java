package com.example.SpringSecurityDemo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		auth.inMemoryAuthentication().withUser("usr").password("{noop}pwd").authorities("USER").and()
			.withUser("adm").password("{noop}pwd").authorities("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/getAdminPage").hasAuthority("ADMIN")
				.antMatchers("/getNormalUserPage").hasAnyAuthority("ADMIN","USER")
				.antMatchers("/getOnlyNormalUserPage").hasAuthority("USER")
				.anyRequest().authenticated()
				.and()
			.formLogin().loginPage("/loginCustomPage").permitAll().defaultSuccessUrl("/getMyPage").failureForwardUrl("/loginFailed").and()
			.csrf().disable()
			.httpBasic();
	}
}
