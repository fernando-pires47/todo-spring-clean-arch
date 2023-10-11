package br.com.spring.todo.usecase.board.getObject.dto;

import br.com.spring.todo.core.domain.board.enumerator.BoardStatus;

public record BoardGetObjectOutputDto(String name, BoardStatus status) {
}
