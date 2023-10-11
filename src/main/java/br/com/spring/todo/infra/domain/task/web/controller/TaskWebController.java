package br.com.spring.todo.infra.domain.task.web.controller;

import br.com.spring.todo.infra.configuration.restHttpResponse.RestHttpResponseModel;
import br.com.spring.todo.usecase.task.getAll.dto.TaskGetAllOutputDto;
import br.com.spring.todo.usecase.task.getObject.dto.TaskGetObjectOutputDto;
import br.com.spring.todo.usecase.task.save.dto.TaskSaveInputDto;
import br.com.spring.todo.usecase.task.update.dto.TaskUpdateInputDto;
import org.springframework.http.ResponseEntity;
import java.util.List;

public sealed interface TaskWebController permits TaskWebRestController {
    ResponseEntity<RestHttpResponseModel> save(TaskSaveInputDto input);

    ResponseEntity<RestHttpResponseModel> update(TaskUpdateInputDto input) throws Exception;

    ResponseEntity<RestHttpResponseModel> delete(Long id);

    ResponseEntity<RestHttpResponseModel> inactive(Long id) throws Exception;
    ResponseEntity<RestHttpResponseModel> active(Long id) throws Exception;

    ResponseEntity<List<TaskGetAllOutputDto>> getAll();
    ResponseEntity<TaskGetObjectOutputDto> getObject(Long id);

    ResponseEntity<RestHttpResponseModel> changeBoard(Long idTask, Long idBoard) throws Exception;

}
