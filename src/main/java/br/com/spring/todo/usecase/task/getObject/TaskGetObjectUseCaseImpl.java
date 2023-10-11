package br.com.spring.todo.usecase.task.getObject;

import br.com.spring.todo.core.domain.task.entity.Task;
import br.com.spring.todo.core.domain.task.gateway.TaskGateway;
import br.com.spring.todo.usecase.task.getObject.dto.TaskGetObjectOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public non-sealed class TaskGetObjectUseCaseImpl implements TaskGetObjectUseCase {
    private final TaskGateway taskGateway;

    @Autowired
    public TaskGetObjectUseCaseImpl(TaskGateway taskGateway) {
        this.taskGateway = taskGateway;
    }

    public TaskGetObjectOutputDto execute(Long id) {
        Task task = this.taskGateway.getObject(id);
        return task == null ? null : new TaskGetObjectOutputDto(
                task.getTitle(),task.getDescription(),task.getStatus(),task.getBoard(),task.getDate_start(),task.getDate_end());
    }
}
