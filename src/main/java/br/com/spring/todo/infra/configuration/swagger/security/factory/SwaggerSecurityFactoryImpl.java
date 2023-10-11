package br.com.spring.todo.infra.configuration.swagger.security.factory;

import br.com.spring.todo.infra.configuration.security.provider.SecurityProviderType;
import br.com.spring.todo.infra.configuration.security.SecurityEnvironment;
import br.com.spring.todo.infra.configuration.swagger.security.SwaggerSecurity;
import br.com.spring.todo.infra.configuration.swagger.security.SwaggerSecurityApiKey;
import br.com.spring.todo.infra.configuration.swagger.security.SwaggerSecurityBearer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SwaggerSecurityFactoryImpl implements SwaggerSecurityFactory{

    private SecurityEnvironment securityEnvironment;

    @Autowired
    SwaggerSecurityFactoryImpl(SecurityEnvironment securityEnvironment){
        this.securityEnvironment = securityEnvironment;
    }

    @Override
    public SwaggerSecurity getSecurityProvider() throws Exception {
        if(this.securityEnvironment.getAuthProvider() == SecurityProviderType.APIKEY){
            return new SwaggerSecurityApiKey(this.securityEnvironment.getAuthTokenKey());
        }else if(this.securityEnvironment.getAuthProvider() == SecurityProviderType.BEARER){
            return new SwaggerSecurityBearer();
        }else{
            throw new Error("Provider not implemented");
        }
    }
}
