package br.com.spring.todo.infra.configuration.swagger.security;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityScheme;

public non-sealed class SwaggerSecurityBearer implements SwaggerSecurity{
    @Override
    public Components createComponent() {
        return new Components().addSecuritySchemes
        (this.getDescription(), new SecurityScheme()
        .type(SecurityScheme.Type.HTTP)
        .scheme("bearer")
        .in(SecurityScheme.In.HEADER)
        .description("Provide the authentication bearer"));
    }

    @Override
    public String getDescription() {
        return "Bearer Authentication";
    }
}
