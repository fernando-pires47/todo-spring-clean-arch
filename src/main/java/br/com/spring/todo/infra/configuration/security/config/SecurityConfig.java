package br.com.spring.todo.infra.configuration.security.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;

public interface SecurityConfig {
    RequestMatcher getAutorizedUrls();
    SecurityFilterChain configure(HttpSecurity http) throws Exception;
}
