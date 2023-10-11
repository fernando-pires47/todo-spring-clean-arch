package br.com.spring.todo.infra.domain.task.web.controller;

import br.com.spring.todo.infra.configuration.restHttpResponse.RestHttpResponse;
import br.com.spring.todo.infra.configuration.restHttpResponse.RestHttpResponseModel;
import br.com.spring.todo.usecase.task.active.TaskActiveUseCase;
import br.com.spring.todo.usecase.task.changeBoard.TaskChangeBoardUseCase;
import br.com.spring.todo.usecase.task.delete.TaskDeleteUseCase;
import br.com.spring.todo.usecase.task.getAll.TaskGetAllUseCase;
import br.com.spring.todo.usecase.task.getAll.dto.TaskGetAllOutputDto;
import br.com.spring.todo.usecase.task.getObject.TaskGetObjectUseCase;
import br.com.spring.todo.usecase.task.getObject.dto.TaskGetObjectOutputDto;
import br.com.spring.todo.usecase.task.inactive.TaskInactiveUseCase;
import br.com.spring.todo.usecase.task.save.TaskSaveUseCase;
import br.com.spring.todo.usecase.task.save.dto.TaskSaveInputDto;
import br.com.spring.todo.usecase.task.update.TaskUpdateUseCase;
import br.com.spring.todo.usecase.task.update.dto.TaskUpdateInputDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/task")
@Tag(name = "Task")
public final class TaskWebRestController implements TaskWebController {

    private final TaskSaveUseCase taskSaveUseCase;
    private final TaskGetAllUseCase taskGetAllUseCase;
    private final TaskGetObjectUseCase taskGetObjectUseCase;
    private final TaskDeleteUseCase taskDeleteUseCase;
    private final TaskInactiveUseCase taskInactiveUseCase;

    private final TaskActiveUseCase taskActiveUseCase;

    private final TaskChangeBoardUseCase taskChangeBoardUseCase;

    private final TaskUpdateUseCase taskUpdateUseCase;


    @Autowired
    public TaskWebRestController(
            TaskSaveUseCase taskSaveUseCase,
            TaskGetAllUseCase taskGetAllUseCase,
            TaskGetObjectUseCase taskGetObjectUseCase,
            TaskDeleteUseCase taskDeleteUseCase,
            TaskInactiveUseCase taskInactiveUseCase,
            TaskActiveUseCase taskActiveUseCase,
            TaskChangeBoardUseCase taskChangeBoardUseCase,
            TaskUpdateUseCase taskUpdateUseCase
        ) {
        this.taskSaveUseCase = taskSaveUseCase;
        this.taskGetAllUseCase = taskGetAllUseCase;
        this.taskGetObjectUseCase = taskGetObjectUseCase;
        this.taskDeleteUseCase = taskDeleteUseCase;
        this.taskInactiveUseCase = taskInactiveUseCase;
        this.taskActiveUseCase = taskActiveUseCase;
        this.taskChangeBoardUseCase = taskChangeBoardUseCase;
        this.taskUpdateUseCase = taskUpdateUseCase;
    }

    @Operation(summary = "Save Task")
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestHttpResponseModel> save(@RequestBody TaskSaveInputDto input) {
        this.taskSaveUseCase.execute(input);
        return RestHttpResponse.response(HttpStatus.OK,"Record saved with success");
    }

    @Operation(summary = "Update Task")
    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestHttpResponseModel> update(@RequestBody TaskUpdateInputDto input) throws Exception {
        this.taskUpdateUseCase.execute(input);
        return RestHttpResponse.response(HttpStatus.OK,"Record updated with success");
    }

    @Operation(summary = "Delete Task")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<RestHttpResponseModel> delete(@PathVariable Long id) {
        this.taskDeleteUseCase.execute(id);
        return RestHttpResponse.response(HttpStatus.OK,"Record deleted with success");
    }

    @Operation(summary = "Inactive Task")
    @PatchMapping(value = "/inactive/{id}")
    public ResponseEntity<RestHttpResponseModel> inactive(@PathVariable Long id) throws Exception {
        this.taskInactiveUseCase.execute(id);
        return RestHttpResponse.response(HttpStatus.OK,"Record inactive with success");

    }

    @Operation(summary = "Active Task")
    @PatchMapping(value = "/active/{id}")
    public ResponseEntity<RestHttpResponseModel> active(@PathVariable Long id) throws Exception {
        this.taskActiveUseCase.execute(id);
        return RestHttpResponse.response(HttpStatus.OK,"Record active with success");
    }

    @Operation(summary = "Update Board of Task")
    @PatchMapping(value = "/change-board/{id}")
    public ResponseEntity<RestHttpResponseModel> changeBoard(@PathVariable Long idTask, @RequestParam(name = "board") Long idBoard) throws Exception {
        this.taskChangeBoardUseCase.execute(idTask,idBoard);
        return RestHttpResponse.response(HttpStatus.OK,"Board updated with success");
    }

    @Operation(summary = "Get all Task")
    @GetMapping(value = "/all")
    public ResponseEntity<List<TaskGetAllOutputDto>> getAll() {
        return ResponseEntity.ok(this.taskGetAllUseCase.execute());
    }

    @Operation(summary = "Get specific Task")
    @GetMapping(value = "/get/{id}")
    public ResponseEntity<TaskGetObjectOutputDto> getObject(@PathVariable Long id) {
        final TaskGetObjectOutputDto taskGetObjectOutputDto = this.taskGetObjectUseCase.execute(id);

        if (taskGetObjectOutputDto == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(taskGetObjectOutputDto);
    }
}
