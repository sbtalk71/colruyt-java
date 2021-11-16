package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource ds;
    @Autowired
    AuthenticationService authenticationService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/app/**")
                .hasAnyRole("CLIENT","USER","ADMIN")
                .antMatchers("/all/*").permitAll()
                .antMatchers("/services/**").authenticated()
                .and()
                .csrf().disable()
                .httpBasic();
               // .formLogin();
    }
/*
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception{
        builder.inMemoryAuthentication().withUser("shantanu").password("$2a$10$4J11btA92rm58PRIEiPMEO0s1sYnZslqUXUzAtic3r9ieVrvagkRu").roles("USER");
        builder.inMemoryAuthentication().withUser("pavan").password("$2a$10$4J11btA92rm58PRIEiPMEO0s1sYnZslqUXUzAtic3r9ieVrvagkRu").roles("CLIENT");
        builder.inMemoryAuthentication().withUser("mahesh").password("$2a$10$4J11btA92rm58PRIEiPMEO0s1sYnZslqUXUzAtic3r9ieVrvagkRu").roles("ADMIN");
    }*/


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception{
       builder.userDetailsService(authenticationService).passwordEncoder(encoder());
       // builder.jdbcAuthentication().dataSource(ds).passwordEncoder(encoder());
             // .usersByUsernameQuery("select username,password,enabled from users where username=?")
              //.authoritiesByUsernameQuery("select username,authority from authorities where username=?");
       }

    /*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception{
        builder.ldapAuthentication()
                .contextSource()
                .url("ldap://localhost:10389/dc=jboss,dc=com")
                .managerDn("uid=admin,ou=system")
                .managerPassword("secret")
                .and()
                .userSearchBase("ou=users")
                .userSearchFilter("uid={0}")
                .groupSearchBase("ou=roles")
                .groupSearchFilter("uniqueMember={0}")
                .groupRoleAttribute("cn")
                .passwordCompare()
                .passwordEncoder(new LdapShaPasswordEncoder())
                .passwordAttribute("userPassword");
        System.out.println("LDAP initialized...");
    }
*/

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

}
