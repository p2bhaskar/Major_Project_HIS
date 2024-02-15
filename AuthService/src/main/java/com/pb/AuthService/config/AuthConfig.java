package com.pb.AuthService.config;
import com.pb.AuthService.filter.JWTTokenGenaratorFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class AuthConfig {

    Logger logger = LoggerFactory.getLogger(AuthConfig.class);


    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        try {
            logger.info("Starting defaultSecurityFilterChain method.");

            httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .csrf(csrf-> csrf.disable())
                    .cors(cors->cors.disable())
                    .addFilterAfter(new JWTTokenGenaratorFilter(), BasicAuthenticationFilter.class)
                    .authorizeHttpRequests((requests) -> requests
                            .requestMatchers("/login2").permitAll()
                            .requestMatchers("/login").authenticated())

                   // .addFilterBefore(new JWTTokenGenaratorFilter(), BasicAuthenticationFilter.class)
                    //.formLogin(Customizer.withDefaults())
                    .httpBasic(Customizer.withDefaults());

            return httpSecurity.build();
        } catch (Exception e){
            System.out.println(e);
            throw new Exception(e);
        }
        finally {
            logger.info("Exiting defaultSecurityFilterChain method.");
        }
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
