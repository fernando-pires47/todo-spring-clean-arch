package br.com.spring.todo.usecase.board.save;

import br.com.spring.todo.usecase.board.save.dto.BoardSaveInputDto;
import br.com.spring.todo.core.domain.board.builder.BoardBuilder;
import br.com.spring.todo.core.domain.board.entity.Board;
import br.com.spring.todo.core.domain.board.gateway.BoardGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public non-sealed class BoardSaveUseCaseImpl implements BoardSaveUseCase {

    private final BoardGateway boardGateway;

    @Autowired
    public BoardSaveUseCaseImpl(BoardGateway boardGateway) {
        this.boardGateway = boardGateway;
    }

    @Transactional()
    public void execute(BoardSaveInputDto input) {
        Board board = new BoardBuilder().create(input.name()).build();
        this.boardGateway.save(board);
    }
}
