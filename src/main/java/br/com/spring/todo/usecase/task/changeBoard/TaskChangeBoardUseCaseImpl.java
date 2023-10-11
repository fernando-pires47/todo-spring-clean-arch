package br.com.spring.todo.usecase.task.changeBoard;

import br.com.spring.todo.core.domain.board.entity.Board;
import br.com.spring.todo.core.domain.board.gateway.BoardGateway;
import br.com.spring.todo.core.domain.task.entity.Task;
import br.com.spring.todo.core.domain.task.gateway.TaskGateway;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public non-sealed class TaskChangeBoardUseCaseImpl implements TaskChangeBoardUseCase {

    private final TaskGateway taskGateway;

    private final BoardGateway boardGateway;


    @Autowired
    public TaskChangeBoardUseCaseImpl(TaskGateway taskGateway, BoardGateway boardGateway) {
        this.taskGateway = taskGateway;
        this.boardGateway = boardGateway;
    }

    @Transactional
    public void execute(Long idTask, Long idBoard) throws Exception {
        Task task = this.taskGateway.getObject(idTask);
        Board board = this.boardGateway.getObject(idBoard);
        if(task == null){
            throw new Exception("Task not exist");
        }
        if(board == null){
            throw new Exception("Board not exist");
        }
        task.changeBoard(board);
        this.taskGateway.save(task);
    }
}
