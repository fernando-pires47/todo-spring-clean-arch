package br.com.spring.todo.infra.configuration.restHttpResponse;

public class RestHttpResponseModel {
    private Object data;

    private RestHttpResponseModel(){
    }

    public RestHttpResponseModel(Object data){
        this.data = data;
    }

    public Object getData() {
        return data;
    }
}
