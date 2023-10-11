package br.com.spring.todo.infra.configuration.messageSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class messageSourceConfig {

    @Bean
    public ResourceBundleMessageSource messageSource() {
        var source = new ResourceBundleMessageSource();
        source.setBasenames("messages/translate");
        source.setUseCodeAsDefaultMessage(true);
        return source;
    }
}
