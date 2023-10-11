package br.com.spring.todo.usecase.board.getObject;

import br.com.spring.todo.usecase.board.getObject.dto.BoardGetObjectOutputDto;

public sealed interface BoardGetObjectUseCase permits BoardGetObjectUseCaseImpl {
    BoardGetObjectOutputDto execute(Long id);
}
