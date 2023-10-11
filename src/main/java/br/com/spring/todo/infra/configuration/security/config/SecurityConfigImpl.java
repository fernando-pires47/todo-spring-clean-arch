package br.com.spring.todo.infra.configuration.security.config;

import br.com.spring.todo.infra.configuration.security.SecurityAuthenticationFilter;
import br.com.spring.todo.infra.configuration.security.handler.SecurityAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfigImpl implements SecurityConfig {
    private final SecurityAuthenticationFilter securityAuthenticationFilter;

    @Autowired
    SecurityConfigImpl(SecurityAuthenticationFilter securityAuthenticationFilter){
        this.securityAuthenticationFilter = securityAuthenticationFilter;
    }

    @Override
    public RequestMatcher getAutorizedUrls() {
        return new OrRequestMatcher(
                new AntPathRequestMatcher("/h2-console/**"),
                new AntPathRequestMatcher("/swagger-ui/**"),
                new AntPathRequestMatcher("/v3/api-docs/**")
        );
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
        .authorizeHttpRequests((authorize) -> authorize
        .requestMatchers(this.getAutorizedUrls()).permitAll()
        .anyRequest().authenticated()
        )
        .addFilterBefore(this.securityAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .exceptionHandling(exception -> exception.accessDeniedHandler(new SecurityAccessDeniedHandler()))
        .csrf(AbstractHttpConfigurer::disable)
        .cors(AbstractHttpConfigurer::disable)
        .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));

        return http.build();
    }
}
