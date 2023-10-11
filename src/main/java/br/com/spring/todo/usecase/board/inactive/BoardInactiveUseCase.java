package br.com.spring.todo.usecase.board.inactive;

public sealed interface BoardInactiveUseCase permits BoardInactiveUseCaseImpl {
    void execute(Long id) throws Exception;
}
