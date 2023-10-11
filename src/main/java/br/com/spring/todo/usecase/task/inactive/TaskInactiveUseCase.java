package br.com.spring.todo.usecase.task.inactive;

public sealed interface TaskInactiveUseCase permits TaskInactiveUseCaseImpl {
    void execute(Long id) throws Exception;
}
