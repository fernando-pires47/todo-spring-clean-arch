package br.com.spring.todo.infra.configuration.exception;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionRestControllerAdvice {
    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request, HttpServletResponse res) throws Exception {
       String translatedMessage = messageSource.getMessage("teste2",null,ex.getMessage(), LocaleContextHolder.getLocale());
        return ResponseEntity.internalServerError().body(new ExceptionModel(translatedMessage));
    }
}
