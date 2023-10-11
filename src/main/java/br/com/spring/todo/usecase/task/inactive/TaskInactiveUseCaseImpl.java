package br.com.spring.todo.usecase.task.inactive;

import br.com.spring.todo.core.domain.task.entity.Task;
import br.com.spring.todo.core.domain.task.gateway.TaskGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public non-sealed class TaskInactiveUseCaseImpl implements TaskInactiveUseCase {
    private final TaskGateway taskGateway;

    @Autowired
    public TaskInactiveUseCaseImpl(TaskGateway taskGateway) {
        this.taskGateway = taskGateway;
    }

    @Transactional
    public void execute(Long id) throws Exception {
        Task task = this.taskGateway.getObject(id);
        if(task == null){
            throw new Exception("Task not exist");
        }
        task.inactive();
        this.taskGateway.save(task);
    }
}
