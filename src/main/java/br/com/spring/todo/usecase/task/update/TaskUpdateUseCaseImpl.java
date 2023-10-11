package br.com.spring.todo.usecase.task.update;

import br.com.spring.todo.core.domain.task.entity.Task;
import br.com.spring.todo.core.domain.task.gateway.TaskGateway;
import br.com.spring.todo.usecase.task.update.dto.TaskUpdateInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public non-sealed class TaskUpdateUseCaseImpl implements TaskUpdateUseCase {

    private final TaskGateway taskGateway;

    @Autowired
    public TaskUpdateUseCaseImpl(TaskGateway taskGateway) {
        this.taskGateway = taskGateway;
    }

    @Transactional()
    public void execute(TaskUpdateInputDto input) throws Exception {
        Task task = this.taskGateway.getObject(input.id());
        if(task == null){
            throw new Exception("Record not found");
        }
        task.update(input.title(),input.description(),input.date_start(),input.date_end());
        this.taskGateway.save(task);
    }
}
