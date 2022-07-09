package fa.mockproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @SuppressWarnings("deprecation")
	@Bean
    @Override
    public UserDetailsService userDetailsService() {

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(
                User.withDefaultPasswordEncoder()
                    .username("QuyNN")
                    .password("123456")
                    .roles("USER") 
                    .build()
        );
        return manager;
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .defaultSuccessUrl("/hello")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll()
        		.and().csrf().disable();
    }
}