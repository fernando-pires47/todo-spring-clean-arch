package br.com.spring.todo.infra.domain.board.web.controller;

import br.com.spring.todo.infra.configuration.restHttpResponse.RestHttpResponseModel;
import br.com.spring.todo.usecase.board.getAll.dto.BoardGetAllOutputDto;
import br.com.spring.todo.usecase.board.getObject.dto.BoardGetObjectOutputDto;
import br.com.spring.todo.usecase.board.save.dto.BoardSaveInputDto;
import br.com.spring.todo.usecase.board.update.dto.BoardUpdateInputDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public sealed interface BoardWebController permits BoardWebRestController {
    ResponseEntity<RestHttpResponseModel> save(BoardSaveInputDto boardSaveInputDto);

    ResponseEntity<RestHttpResponseModel> update(BoardUpdateInputDto boardSaveInputDto) throws Exception;

    ResponseEntity<RestHttpResponseModel> delete(Long id);

    ResponseEntity<RestHttpResponseModel> inactive(Long id) throws Exception;
    ResponseEntity<RestHttpResponseModel> active(Long id) throws Exception;

    ResponseEntity<List<BoardGetAllOutputDto>> getAll();
    ResponseEntity<BoardGetObjectOutputDto> getObject(Long id);
}
