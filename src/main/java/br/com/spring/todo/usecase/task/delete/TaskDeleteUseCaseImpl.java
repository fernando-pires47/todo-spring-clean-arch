package br.com.spring.todo.usecase.task.delete;

import br.com.spring.todo.core.domain.task.gateway.TaskGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public non-sealed class TaskDeleteUseCaseImpl implements TaskDeleteUseCase {
    private final TaskGateway taskGateway;

    @Autowired
    public TaskDeleteUseCaseImpl(TaskGateway taskGateway) {
        this.taskGateway = taskGateway;
    }

    @Transactional
    public void execute(Long id) {
        this.taskGateway.delete(id);
    }
}
