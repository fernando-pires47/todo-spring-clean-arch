package br.com.spring.todo.infra.configuration.security.provider.factory;

import br.com.spring.todo.infra.configuration.security.provider.SecurityProviderApiKey;
import br.com.spring.todo.infra.configuration.security.provider.SecurityProviderBearer;
import br.com.spring.todo.infra.configuration.security.SecurityEnvironment;
import br.com.spring.todo.infra.configuration.security.provider.SecurityProviderType;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class SecurityProviderFactoryImpl implements SecurityProviderFactory {
    private final SecurityEnvironment securityEnvironment;

    SecurityProviderFactoryImpl(SecurityEnvironment securityEnvironment){
        this.securityEnvironment = securityEnvironment;
    }

    @Override
    public Authentication getAuthentication(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(this.securityEnvironment.getAuthProvider() == SecurityProviderType.APIKEY){
            return new SecurityProviderApiKey(this.securityEnvironment.getAuthTokenKey(),this.securityEnvironment.getAuthTokenValue(),request);
        }else if(this.securityEnvironment.getAuthProvider() == SecurityProviderType.BEARER) {
            return new SecurityProviderBearer(this.securityEnvironment.getAuthTokenValue(), request);
        }else{
            throw new Exception("Provider type not implemented");
        }
    }
}
