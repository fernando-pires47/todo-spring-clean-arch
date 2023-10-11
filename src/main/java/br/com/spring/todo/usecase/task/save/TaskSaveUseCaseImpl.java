package br.com.spring.todo.usecase.task.save;

import br.com.spring.todo.core.domain.board.entity.Board;
import br.com.spring.todo.core.domain.board.gateway.BoardGateway;
import br.com.spring.todo.core.domain.task.builder.TaskBuilder;
import br.com.spring.todo.core.domain.task.entity.Task;
import br.com.spring.todo.core.domain.task.gateway.TaskGateway;
import br.com.spring.todo.usecase.task.save.dto.TaskSaveInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public non-sealed class TaskSaveUseCaseImpl implements TaskSaveUseCase {

    private final TaskGateway taskGateway;
    private final BoardGateway boardGateway;


    @Autowired
    public TaskSaveUseCaseImpl(TaskGateway taskGateway,BoardGateway boardGateway) {
        this.taskGateway = taskGateway;
        this.boardGateway = boardGateway;
    }

    @Transactional()
    public void execute(TaskSaveInputDto input) {
        Board board = this.boardGateway.getObject(input.board());
        Task task = new TaskBuilder().create(input.title(),input.description(),board,input.date_start(),input.date_end()).build();
        this.taskGateway.save(task);
    }
}
