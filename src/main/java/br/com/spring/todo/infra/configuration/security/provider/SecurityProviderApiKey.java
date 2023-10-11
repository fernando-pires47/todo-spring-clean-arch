package br.com.spring.todo.infra.configuration.security.provider;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;

public class SecurityProviderApiKey extends AbstractAuthenticationToken {

    private final String tokenValue;

    public SecurityProviderApiKey(String tokenKey, String tokenDefault, HttpServletRequest request) {
        super(AuthorityUtils.NO_AUTHORITIES);
        this.tokenValue = request.getHeader(tokenKey);

        if (this.tokenValue != null && this.tokenValue.equals(tokenDefault)) {
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
