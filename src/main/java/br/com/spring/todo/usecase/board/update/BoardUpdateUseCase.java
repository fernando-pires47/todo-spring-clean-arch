package br.com.spring.todo.usecase.board.update;

import br.com.spring.todo.usecase.board.update.dto.BoardUpdateInputDto;

public sealed interface BoardUpdateUseCase permits BoardUpdateUseCaseImpl {
    void execute(BoardUpdateInputDto boardSaveInputDto) throws Exception;
}
