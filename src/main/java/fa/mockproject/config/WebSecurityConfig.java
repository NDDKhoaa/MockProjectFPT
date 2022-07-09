package fa.mockproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Qualifier("userDetailsServiceImpl")
  @Autowired
  private UserDetailsService userDetailsService;

  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/listUser", "/listRole")
        .access("hasRole('ROLE_SYSTEM_ADMIN')");
    http.sessionManagement()
            .sessionFixation().migrateSession();
    http.csrf().disable().authorizeRequests().anyRequest().authenticated()
        .and().formLogin().loginPage("/login").defaultSuccessUrl("/dashboard", true).permitAll()
        .and()
            .rememberMe().tokenRepository(this.persistentTokenRepository()) //
            .tokenValiditySeconds(1 * 1 * 60)// 24h
        .and().logout().deleteCookies("JSESSIONID").permitAll();



    /*http.csrf().disable().authorizeRequests()*/
    /*http.authorizeRequests().antMatchers(HttpMethod.GET, "/addUser").permitAll()
        .antMatchers(HttpMethod.GET, "/listUser").permitAll()
        .anyRequest().authenticated()
        .and().formLogin()
        .loginPage("/login")
       *//* .defaultSuccessUrl("/home", true)
        .failureUrl("/login?error=true")
        .usernameParameter("username")
        .passwordParameter("password")*//*
        .and().logout().logoutUrl("/perform_logout")
        .deleteCookies("JSESSIONID").permitAll();*/
    // http.authorizeRequests().antMatchers("/admin").access("hasRole(" + Role.ADMIN + ")");
  }

  @Bean
  public AuthenticationManager customAuthenticationManager() throws Exception {
    return authenticationManager();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web
        .ignoring()
        .antMatchers("/resources/**", "/static/**");
  }

  @Bean
  public PersistentTokenRepository persistentTokenRepository() {
    InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();

    return memory;
  }
}
