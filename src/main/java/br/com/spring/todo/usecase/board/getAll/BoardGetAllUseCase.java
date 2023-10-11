package br.com.spring.todo.usecase.board.getAll;

import br.com.spring.todo.usecase.board.getAll.dto.BoardGetAllOutputDto;

import java.util.List;

public sealed interface BoardGetAllUseCase permits BoardGetAllUseCaseImpl {
    List<BoardGetAllOutputDto> execute();
}
