package br.com.spring.todo.usecase.board.active;

public sealed interface BoardActiveUseCase permits BoardActiveUseCaseImpl {
    void execute(Long id) throws Exception;
}
