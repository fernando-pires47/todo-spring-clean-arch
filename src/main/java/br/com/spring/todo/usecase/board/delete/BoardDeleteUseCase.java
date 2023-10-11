package br.com.spring.todo.usecase.board.delete;

public sealed interface BoardDeleteUseCase permits BoardDeleteUseCaseImpl {
    void execute(Long id);
}
