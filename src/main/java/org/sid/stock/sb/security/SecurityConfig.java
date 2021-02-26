/*package org.sid.stock.sb.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private DataSource dataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception { 
		
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select login as principal, password as credentials, true from pharmacien where login=?")
		.authoritiesByUsernameQuery("select pharmacien_login as principal, roles_role as role from users_roles where pharmacien_login=?" ) 
		.passwordEncoder(new Md5PasswordEncoder())
		.rolePrefix("ROLE_");
	}

		
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests().antMatchers("/css/**","/js/**","/images/**").permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/login").defaultSuccessUrl("/blank")
		.failureUrl("/login").permitAll();
	}
}
*/