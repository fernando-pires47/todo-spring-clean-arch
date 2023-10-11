package br.com.spring.todo.usecase.task.update.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record TaskUpdateInputDto(

        @Schema(description = "Task Id")
        @NotNull Long id,

        @Schema(description = "Task Title")
        @NotNull String title,
        @Schema(description = "Task Description")
        @NotNull String description,
        @Schema(description = "Task Date Start")
        Date date_start,
        @Schema(description = "Task Date End")
        Date date_end
        ) {
}
