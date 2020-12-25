package com.project.news.prajathathva;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class SecuirtyConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		 .antMatchers("/image/favicon.png","/image/prajathathva-news-kannada-logo-s-1.png","/","/home","/astrology","/covid19",
				 "/devotional","/education","/Findbyid",
				 "/national","/sports","/state","/world",
				 "/upload/image/**","/news/**","/assets/**").permitAll()
		 .anyRequest().authenticated()
		 .and()
		 .formLogin()
		 .loginPage("/login").defaultSuccessUrl("/newspub", true)
		 .permitAll().and()
		 .logout().permitAll() ;
	}
	
	
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
}
