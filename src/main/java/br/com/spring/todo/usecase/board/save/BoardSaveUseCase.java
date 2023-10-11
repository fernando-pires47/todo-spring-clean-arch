package br.com.spring.todo.usecase.board.save;

import br.com.spring.todo.usecase.board.save.dto.BoardSaveInputDto;

public sealed interface BoardSaveUseCase permits BoardSaveUseCaseImpl {
    void execute(BoardSaveInputDto boardSaveInputDto);
}
