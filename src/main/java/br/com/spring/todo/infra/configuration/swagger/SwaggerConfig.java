package br.com.spring.todo.infra.configuration.swagger;

import br.com.spring.todo.infra.configuration.swagger.security.SwaggerSecurity;
import br.com.spring.todo.infra.configuration.swagger.security.factory.SwaggerSecurityFactory;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {


    private SwaggerEnvironment swaggerEnvironment;

    private SwaggerSecurityFactory swaggerSecurityFactory;


    @Autowired
    SwaggerConfig(SwaggerEnvironment swaggerEnvironment, SwaggerSecurityFactory swaggerSecurityFactory){
        this.swaggerEnvironment = swaggerEnvironment;
        this.swaggerSecurityFactory = swaggerSecurityFactory;
    }

    public SwaggerConfig() {
    }

    @Bean
    public OpenAPI openAPI() throws Exception {
        Server devServer = new Server();
        devServer.setUrl(this.swaggerEnvironment.getSwaggerDevUrl());
        devServer.setDescription("Server URL in Development environment");

        Server prodServer = new Server();
        prodServer.setUrl(this.swaggerEnvironment.getSwaggerProdUrl());
        prodServer.setDescription("Server URL in Production environment");

        Contact contact = new Contact();
        contact.setEmail("fernandopires_longo@hotmail.com");
        contact.setName("Fernando Pires");

        SwaggerSecurity swaggerSecurity = this.swaggerSecurityFactory.getSecurityProvider();

        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().
                addList(swaggerSecurity.getDescription())).components(
                    swaggerSecurity.createComponent()
                )
                .info(new Info()
                .title("TODO API")
                .description("This api exposes TODO Operations")
                .version("1.0")
                .contact(contact)).servers(List.of(devServer, prodServer));
    }
}
