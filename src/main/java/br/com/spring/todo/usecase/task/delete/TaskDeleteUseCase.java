package br.com.spring.todo.usecase.task.delete;

public sealed interface TaskDeleteUseCase permits TaskDeleteUseCaseImpl {
    void execute(Long id);
}
