package br.com.spring.todo.usecase.board.getAll;
import br.com.spring.todo.usecase.board.getAll.dto.BoardGetAllOutputDto;
import br.com.spring.todo.core.domain.board.entity.Board;
import br.com.spring.todo.core.domain.board.gateway.BoardGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public non-sealed class BoardGetAllUseCaseImpl implements BoardGetAllUseCase {
    private final BoardGateway boardGateway;

    @Autowired
    public BoardGetAllUseCaseImpl(BoardGateway boardGateway) {
        this.boardGateway = boardGateway;
    }

    public List<BoardGetAllOutputDto> execute() {
        List<Board> boards =  this.boardGateway.getAll();
        return boards.stream().map(p -> new BoardGetAllOutputDto(p.getName(),p.getStatus())).toList();
    }
}
