package br.com.spring.todo.usecase.board.update.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record BoardUpdateInputDto(
        @Schema(description = "Board id")
        @NotNull Long id,

        @Schema(description = "Board name")
        @NotNull String name) {
}
