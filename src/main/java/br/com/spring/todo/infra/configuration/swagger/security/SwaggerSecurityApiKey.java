package br.com.spring.todo.infra.configuration.swagger.security;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityScheme;
public non-sealed class SwaggerSecurityApiKey implements SwaggerSecurity{

    private final String authTokenKey;

    public SwaggerSecurityApiKey(String authTokenKey){
        this.authTokenKey = authTokenKey;
    }

    @Override
    public Components createComponent() {
        return new Components().addSecuritySchemes
        (this.getDescription(), new SecurityScheme()
        .type(SecurityScheme.Type.APIKEY)
        .in(SecurityScheme.In.HEADER)
        .name(this.authTokenKey)
        .description("Provide the authorization token"));
    }

    @Override
    public String getDescription() {
        return "Token Authorization";
    }
}
