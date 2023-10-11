package br.com.spring.todo.infra.configuration.swagger.security;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityScheme;

public non-sealed class SwaggerSecurityBasic implements SwaggerSecurity{
    @Override
    public Components createComponent() {
        return new Components().addSecuritySchemes
        (this.getDescription(), new SecurityScheme()
        .type(SecurityScheme.Type.HTTP)
        .scheme("basic")
        .in(SecurityScheme.In.HEADER)
        .description("Provide the authentication basic"));
    }

    @Override
    public String getDescription() {
        return "Basic Authentication";
    }
}
