package br.com.spring.todo.usecase.task.active;

import br.com.spring.todo.core.domain.task.entity.Task;
import br.com.spring.todo.core.domain.task.gateway.TaskGateway;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public non-sealed class TaskActiveUseCaseImpl implements TaskActiveUseCase {
    private final TaskGateway taskGateway;

    @Autowired
    public TaskActiveUseCaseImpl(TaskGateway taskGateway) {
        this.taskGateway = taskGateway;
    }

    @Transactional
    public void execute(Long id) throws Exception {
        Task task = this.taskGateway.getObject(id);
        if(task == null){
            throw new Exception("Task not exist");
        }
        task.active();
        this.taskGateway.save(task);
    }
}
