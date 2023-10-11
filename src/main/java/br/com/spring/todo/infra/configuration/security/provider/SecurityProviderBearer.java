package br.com.spring.todo.infra.configuration.security.provider;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;

public class SecurityProviderBearer extends AbstractAuthenticationToken {
    private final String tokenValue;

    public SecurityProviderBearer(String tokenDefault, HttpServletRequest request) {
        super(AuthorityUtils.NO_AUTHORITIES);
        this.tokenValue = request.getHeader("Authorization");
        if (this.tokenValue != null && this.tokenValue.startsWith("Bearer") && this.tokenValue.substring(7).equals(tokenDefault)) {
            this.setAuthenticated(true);
        }
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.tokenValue;
    }
}
