package br.com.spring.todo.infra.configuration.security;

import br.com.spring.todo.infra.configuration.security.provider.factory.SecurityProviderFactory;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
import java.io.PrintWriter;

@Service
@Primary
public class SecurityAuthenticationFilter extends GenericFilterBean {

    private final SecurityProviderFactory securityProviderFactory;

    SecurityAuthenticationFilter(SecurityProviderFactory securityProviderFactory){
        this.securityProviderFactory = securityProviderFactory;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        try {
            Authentication authentication = this.securityProviderFactory.getAuthentication((HttpServletRequest) request, (HttpServletResponse) response);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception exp) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            httpResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
            PrintWriter writer = httpResponse.getWriter();
            writer.print(exp.getMessage());
            writer.flush();
            writer.close();
            throw new RuntimeException(exp);
        }
        filterChain.doFilter(request, response);
    }
}
