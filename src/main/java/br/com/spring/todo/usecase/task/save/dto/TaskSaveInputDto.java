package br.com.spring.todo.usecase.task.save.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record TaskSaveInputDto(
        @Schema(description = "Task Title")
        @NotNull String title,
        @Schema(description = "Task Description")
        @NotNull String description,
        @Schema(description = "Task Current Board")
        @NotNull Long board,
        @Schema(description = "Task Date Start")
        Date date_start,
        @Schema(description = "Task Date End")
        Date date_end
        ) {
}
