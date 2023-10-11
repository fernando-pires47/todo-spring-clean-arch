package br.com.spring.todo.usecase.board.update;

import br.com.spring.todo.core.domain.board.entity.Board;
import br.com.spring.todo.core.domain.board.gateway.BoardGateway;
import br.com.spring.todo.usecase.board.update.dto.BoardUpdateInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public non-sealed class BoardUpdateUseCaseImpl implements BoardUpdateUseCase {

    private final BoardGateway boardGateway;

    @Autowired
    public BoardUpdateUseCaseImpl(BoardGateway boardGateway) {
        this.boardGateway = boardGateway;
    }

    @Transactional()
    public void execute(BoardUpdateInputDto input) throws Exception {
        Board board = this.boardGateway.getObject(input.id());
        if(board == null){
            throw new Exception("Record not found");
        }
        board.update(input.name());
        this.boardGateway.save(board);
    }
}
