package br.com.spring.todo.usecase.task.active;

public sealed interface TaskActiveUseCase permits TaskActiveUseCaseImpl {
    void execute(Long id) throws Exception;
}
