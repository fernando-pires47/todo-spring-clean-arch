package br.com.spring.todo.usecase.task.getAll.dto;

import br.com.spring.todo.core.domain.board.entity.Board;
import br.com.spring.todo.core.domain.task.enumerator.TaskStatus;

import java.util.Date;

public record TaskGetAllOutputDto(String title,
                                  String description,
                                  TaskStatus status,
                                  Board board,
                                  Date date_start,
                                  Date date_end) {
}
