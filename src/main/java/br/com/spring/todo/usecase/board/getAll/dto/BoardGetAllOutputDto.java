package br.com.spring.todo.usecase.board.getAll.dto;

import br.com.spring.todo.core.domain.board.enumerator.BoardStatus;

public record BoardGetAllOutputDto(String name, BoardStatus status) {
}
