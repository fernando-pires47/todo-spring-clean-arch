package br.com.spring.todo.infra.configuration.swagger.security;

import io.swagger.v3.oas.models.Components;

public sealed interface SwaggerSecurity permits SwaggerSecurityApiKey,SwaggerSecurityBasic, SwaggerSecurityBearer {

    Components createComponent();

    String getDescription();
}
