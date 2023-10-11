package br.com.spring.todo.infra.configuration.security;

import br.com.spring.todo.infra.configuration.security.provider.SecurityProviderType;

public interface SecurityEnvironment {
    String getAuthTokenKey();
    SecurityProviderType getAuthProvider() throws Exception;
    String getAuthTokenValue();
}
