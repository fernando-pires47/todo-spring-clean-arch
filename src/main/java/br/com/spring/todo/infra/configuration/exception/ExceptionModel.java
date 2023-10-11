package br.com.spring.todo.infra.configuration.exception;

public class ExceptionModel {

    public ExceptionModel(String exceptionMessage){
        this.exceptionMessage = exceptionMessage;
    }

    private ExceptionModel(){
    }

    public ExceptionModel(String exceptionMessage, String internalCodeError){
        this.exceptionMessage = exceptionMessage;
        this.internalCodeError = internalCodeError;
    }

    private String exceptionMessage;
    private String internalCodeError;

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public String getInternalCodeError() {
        return internalCodeError;
    }
}
