package br.com.spring.todo.infra.configuration.environment;

import br.com.spring.todo.infra.configuration.security.SecurityEnvironment;
import br.com.spring.todo.infra.configuration.security.provider.SecurityProviderType;
import br.com.spring.todo.infra.configuration.swagger.SwaggerEnvironment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnvironmentDefault implements SwaggerEnvironment, SecurityEnvironment {

    @Value("${custom.openapi.dev-url}")
    private String swaggerDevUrl;

    @Value("${custom.openapi.prod-url}")
    private String swaggerProdUrl;

    @Value("${custom.token.key}")
    private String authTokenKey;

    @Value("${custom.token.value}")
    private String authTokenValue;

    @Value("${custom.security.provider}")
    private String authProvider;

    @Value("${server.servlet.context-path}")
    private String contextPath;



    @Override
    public String getSwaggerDevUrl() {
        return this.swaggerDevUrl + contextPath;
    }

    @Override
    public String getSwaggerProdUrl() {
        return this.swaggerProdUrl + contextPath;
    }

    @Override
    public String getAuthTokenKey() {
        return this.authTokenKey;
    }

    @Override
    public SecurityProviderType getAuthProvider() throws Exception {
        if(this.authProvider.equals("api-key")){
            return SecurityProviderType.APIKEY;
        }else if(this.authProvider.equals("bearer")){
            return SecurityProviderType.BEARER;
        }else{
            throw new Exception("provider-not-implemented");
        }
    }

    @Override
    public String getAuthTokenValue() {
        return this.authTokenValue;
    }
}
