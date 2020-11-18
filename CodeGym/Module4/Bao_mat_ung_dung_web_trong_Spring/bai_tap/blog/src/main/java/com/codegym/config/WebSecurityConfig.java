package com.codegym.config;

import com.codegym.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // Sét đặt dịch vụ để tìm kiếm User trong Database.
        // Và sét đặt PasswordEncoder.
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // csrf
        http.csrf().disable();

        // login
        http.formLogin()
                .loginProcessingUrl("/checkLogin")
                .loginPage("/login")
        // login successful
                .defaultSuccessUrl("/blog")
        // login failed
                .failureUrl("/login?error=true")
        // setting username, password
                .usernameParameter("username")
                .passwordParameter("password")
        // logout
                .and().logout().logoutUrl("/logout")
        // logout successful
                .logoutSuccessUrl("/login");

        // authorization
        // guest
        http.authorizeRequests().antMatchers("/login").permitAll();

        // user
        http.authorizeRequests().antMatchers("/blog/home","/category/home","/blog/sort").hasRole("USER");

        // admin
        http.authorizeRequests().antMatchers("/blog/*", "/category/*").hasRole("ADMIN");

        // no permission
        http.exceptionHandling().accessDeniedPage("/403");

        // remember me
        http.rememberMe()
                .rememberMeParameter("rememberMe")
                .rememberMeCookieName("rememberMeCookie")
                .tokenValiditySeconds(30);
    }
}
