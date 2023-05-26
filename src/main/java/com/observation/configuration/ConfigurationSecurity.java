package com.observation.configuration;

import com.observation.security.JWTAuthEntryPoint;
import com.observation.security.JWTAuthenticationFilter;
import com.observation.service.ServiceCustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration @EnableWebSecurity @RequiredArgsConstructor
public class ConfigurationSecurity {

    private final JWTAuthEntryPoint authEntryPoint;
    private final ServiceCustomUserDetails userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(authEntryPoint).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeHttpRequests()
                    .requestMatchers(HttpMethod.POST, "/auth/**").permitAll()
//                    .requestMatchers("/synopticObservation/**", "/om/**", "/researcher/**", "/platform/**", "/country/**", "/equipment/**", "/manufacturer/**", "/institution/**", "/platformCategory/**", "/station/**", "/stationOnShore/**", "/stationOffShore/**", "/observer/**").permitAll()
                //                .requestMatchers(HttpMethod.POST, "/user").hasAnyRole("ADMIN", "MODERATOR")
                .anyRequest().authenticated();
//                .authorizeHttpRequests((authorize) -> authorize
//                        .requestMatchers(HttpMethod.POST, "/auth").permitAll()
//                        .anyRequest().authenticated()
//                        // .requestMatchers(HttpMethod.POST, "/user").hasAnyRole("ADMIN", "MODERATOR")
//                );
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public JWTAuthenticationFilter jwtAuthenticationFilter() {
        return new JWTAuthenticationFilter();
    }
}