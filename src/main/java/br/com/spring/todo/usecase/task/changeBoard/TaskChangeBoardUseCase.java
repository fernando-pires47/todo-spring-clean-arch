package br.com.spring.todo.usecase.task.changeBoard;

public sealed interface TaskChangeBoardUseCase permits TaskChangeBoardUseCaseImpl{
    void execute(Long idTask, Long idBoard) throws Exception;
}
