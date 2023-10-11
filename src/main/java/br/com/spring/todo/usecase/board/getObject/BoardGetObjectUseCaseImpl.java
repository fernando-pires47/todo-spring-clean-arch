package br.com.spring.todo.usecase.board.getObject;

import br.com.spring.todo.core.domain.board.entity.Board;
import br.com.spring.todo.core.domain.board.gateway.BoardGateway;
import br.com.spring.todo.usecase.board.getObject.dto.BoardGetObjectOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public non-sealed class BoardGetObjectUseCaseImpl implements BoardGetObjectUseCase {
    private final BoardGateway boardGateway;

    @Autowired
    public BoardGetObjectUseCaseImpl(BoardGateway boardGateway) {
        this.boardGateway = boardGateway;
    }

    public BoardGetObjectOutputDto execute(Long id) {
        Board board = this.boardGateway.getObject(id);
        return board == null ? null : new BoardGetObjectOutputDto(board.getName(),board.getStatus());
    }
}
