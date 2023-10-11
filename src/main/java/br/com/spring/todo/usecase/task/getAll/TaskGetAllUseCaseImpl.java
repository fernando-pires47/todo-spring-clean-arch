package br.com.spring.todo.usecase.task.getAll;

import br.com.spring.todo.core.domain.task.entity.Task;
import br.com.spring.todo.core.domain.task.gateway.TaskGateway;
import br.com.spring.todo.usecase.task.getAll.dto.TaskGetAllOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public non-sealed class TaskGetAllUseCaseImpl implements TaskGetAllUseCase {
    private final TaskGateway taskGateway;

    @Autowired
    public TaskGetAllUseCaseImpl(TaskGateway taskGateway) {
        this.taskGateway = taskGateway;
    }

    public List<TaskGetAllOutputDto> execute() {
        List<Task> tasks =  this.taskGateway.getAll();
        return tasks.stream().map(p ->
                new TaskGetAllOutputDto(p.getTitle(),p.getDescription(),p.getStatus(),p.getBoard(),p.getDate_start(),p.getDate_end())).toList();
    }
}
