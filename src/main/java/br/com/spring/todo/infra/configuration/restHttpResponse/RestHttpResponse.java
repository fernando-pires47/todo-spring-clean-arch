package br.com.spring.todo.infra.configuration.restHttpResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RestHttpResponse {

    public static ResponseEntity<RestHttpResponseModel> response(HttpStatus status, Object data){
        return ResponseEntity.status(status).body(new RestHttpResponseModel(data));
    }
}
