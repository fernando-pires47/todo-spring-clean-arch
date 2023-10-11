package br.com.spring.todo.usecase.task.save;

import br.com.spring.todo.usecase.task.save.dto.TaskSaveInputDto;

public sealed interface TaskSaveUseCase permits TaskSaveUseCaseImpl {
    void execute(TaskSaveInputDto input);
}
