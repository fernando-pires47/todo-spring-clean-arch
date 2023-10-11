package br.com.spring.todo.infra.configuration.swagger.security.factory;

import br.com.spring.todo.infra.configuration.swagger.security.SwaggerSecurity;

public interface SwaggerSecurityFactory {
    SwaggerSecurity getSecurityProvider() throws Exception;

}
