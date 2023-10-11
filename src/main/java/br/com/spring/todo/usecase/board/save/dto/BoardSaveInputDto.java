package br.com.spring.todo.usecase.board.save.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record BoardSaveInputDto(
        @Schema(description = "Board name")
        @NotNull String name) {
}
