package igoristomin.quiz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Customer data
    @Bean
    public UserDetailsService customers() {
        UserDetails admin = User.builder()
                .username("admin")
                .password("$2y$12$oicCEz3Iw1YJZiljacW/5eBu14HQ.KJNVvLA.DYBhDmGd2o0nLXsW") // admin
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(admin);
    }

    // Endpoint settings
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // Access to pages
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/**").permitAll()
                // Separator
                .and()
                // Sign in
                .formLogin()
                // Separator
                .and()
                // Sign out
                .logout()
                .logoutSuccessUrl("/");
    }

    // Password encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
