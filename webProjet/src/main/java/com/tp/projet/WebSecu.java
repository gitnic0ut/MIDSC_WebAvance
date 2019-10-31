package com.tp.projet;

import javax.inject.Inject;

import com.tp.projet.utilisateur.UserService;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecu extends WebSecurityConfigurerAdapter {

        @Inject
        UserService userDetailsService;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
                http.authorizeRequests().antMatchers("/home", "/connection", "/registration").permitAll()
                                .antMatchers("/member").hasRole("USER");
                http.formLogin().loginPage("/connection").usernameParameter("username").passwordParameter("password")
                                .and().logout() // NB: CSRF will disallow visiting GET /logout manually
                                .and().csrf().ignoringAntMatchers("/h2-console/**")// don't apply CSRF protection to
                                                                                   // /h2-console
                ;
                http.headers().frameOptions().sameOrigin();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
                auth.userDetailsService(userDetailsService).passwordEncoder(userDetailsService.encoder);
        }
        
        
}