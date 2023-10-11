package br.com.spring.todo.infra.domain.board.web.controller;

import br.com.spring.todo.infra.configuration.restHttpResponse.RestHttpResponse;
import br.com.spring.todo.infra.configuration.restHttpResponse.RestHttpResponseModel;
import br.com.spring.todo.usecase.board.active.BoardActiveUseCase;
import br.com.spring.todo.usecase.board.delete.BoardDeleteUseCase;
import br.com.spring.todo.usecase.board.getAll.BoardGetAllUseCase;
import br.com.spring.todo.usecase.board.getAll.dto.BoardGetAllOutputDto;
import br.com.spring.todo.usecase.board.getObject.BoardGetObjectUseCase;
import br.com.spring.todo.usecase.board.getObject.dto.BoardGetObjectOutputDto;
import br.com.spring.todo.usecase.board.inactive.BoardInactiveUseCase;
import br.com.spring.todo.usecase.board.save.BoardSaveUseCase;
import br.com.spring.todo.usecase.board.save.dto.BoardSaveInputDto;
import br.com.spring.todo.usecase.board.update.BoardUpdateUseCase;
import br.com.spring.todo.usecase.board.update.dto.BoardUpdateInputDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/board")
@Tag(name = "Board")
public final class BoardWebRestController implements BoardWebController {

    private final BoardSaveUseCase boardSaveUseCase;
    private final BoardGetAllUseCase boardGetAllUseCase;
    private final BoardGetObjectUseCase boardGetObjectUseCase;
    private final BoardDeleteUseCase boardDeleteUseCase;
    private final BoardInactiveUseCase boardInactiveUseCase;

    private final BoardActiveUseCase boardActiveUseCase;

    private final BoardUpdateUseCase boardUpdateUseCase;

    @Autowired
    public BoardWebRestController(
            BoardSaveUseCase boardSaveUseCase,
            BoardGetAllUseCase boardGetAllUseCase,
            BoardGetObjectUseCase boardGetObjectUseCase,
            BoardDeleteUseCase boardDeleteUseCase,
            BoardInactiveUseCase boardInactiveUseCase,
            BoardActiveUseCase boardActiveUseCase,
            BoardUpdateUseCase boardUpdateUseCase
            ) {
        this.boardSaveUseCase = boardSaveUseCase;
        this.boardGetAllUseCase = boardGetAllUseCase;
        this.boardGetObjectUseCase = boardGetObjectUseCase;
        this.boardDeleteUseCase = boardDeleteUseCase;
        this.boardInactiveUseCase = boardInactiveUseCase;
        this.boardActiveUseCase = boardActiveUseCase;
        this.boardUpdateUseCase = boardUpdateUseCase;
    }

    @Operation(summary = "Save Board")
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestHttpResponseModel> save(@RequestBody BoardSaveInputDto boardSaveInputDto) {
        this.boardSaveUseCase.execute(boardSaveInputDto);
        return RestHttpResponse.response(HttpStatus.OK,"Record saved with success");
    }

    @Operation(summary = "Update Board")
    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestHttpResponseModel> update(@RequestBody BoardUpdateInputDto input) throws Exception {
        this.boardUpdateUseCase.execute(input);
        return RestHttpResponse.response(HttpStatus.OK,"Record updated with success");
    }

    @Operation(summary = "Delete Board")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<RestHttpResponseModel> delete(@PathVariable Long id) {
        this.boardDeleteUseCase.execute(id);
        return RestHttpResponse.response(HttpStatus.OK,"Record deleted with success");
    }

    @Operation(summary = "Inactive Board")
    @PatchMapping(value = "/inactive/{id}")
    public ResponseEntity<RestHttpResponseModel> inactive(@PathVariable Long id) throws Exception {
        this.boardInactiveUseCase.execute(id);
        return RestHttpResponse.response(HttpStatus.OK,"Record inactive with success");
    }

    @Operation(summary = "Active Board")
    @PatchMapping(value = "/active/{id}")
    public ResponseEntity<RestHttpResponseModel> active(@PathVariable Long id) throws Exception {
        this.boardActiveUseCase.execute(id);
        return RestHttpResponse.response(HttpStatus.OK,"Record active with success");
    }

    @Operation(summary = "Get all Boards")
    @GetMapping(value = "/all",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BoardGetAllOutputDto>> getAll() {
        return ResponseEntity.ok(this.boardGetAllUseCase.execute());
    }

    @Operation(summary = "Get specific Board")
    @GetMapping(value = "/get/{id}")
    public ResponseEntity<BoardGetObjectOutputDto> getObject(@PathVariable Long id) {
        final BoardGetObjectOutputDto boardGetObjectOutputDto = this.boardGetObjectUseCase.execute(id);

        if (boardGetObjectOutputDto == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(boardGetObjectOutputDto);
    }
}
