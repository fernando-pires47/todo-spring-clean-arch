package br.com.spring.todo.usecase.task.getObject;

import br.com.spring.todo.usecase.task.getObject.dto.TaskGetObjectOutputDto;

public sealed interface TaskGetObjectUseCase permits TaskGetObjectUseCaseImpl {
    TaskGetObjectOutputDto execute(Long id);
}
