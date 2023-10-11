package br.com.spring.todo.usecase.task.update;

import br.com.spring.todo.usecase.task.update.dto.TaskUpdateInputDto;

public sealed interface TaskUpdateUseCase permits TaskUpdateUseCaseImpl {
    void execute(TaskUpdateInputDto input) throws Exception;
}
