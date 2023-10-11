package br.com.spring.todo.infra.configuration.security.provider.factory;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;

public interface SecurityProviderFactory {
    Authentication getAuthentication(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
