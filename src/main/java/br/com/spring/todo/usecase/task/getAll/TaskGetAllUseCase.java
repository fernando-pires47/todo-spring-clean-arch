package br.com.spring.todo.usecase.task.getAll;

import br.com.spring.todo.usecase.task.getAll.dto.TaskGetAllOutputDto;

import java.util.List;

public sealed interface TaskGetAllUseCase permits TaskGetAllUseCaseImpl {
    List<TaskGetAllOutputDto> execute();
}
