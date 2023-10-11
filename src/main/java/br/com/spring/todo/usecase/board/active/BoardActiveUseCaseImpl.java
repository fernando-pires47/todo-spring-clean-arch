package br.com.spring.todo.usecase.board.active;

import br.com.spring.todo.core.domain.board.entity.Board;
import br.com.spring.todo.core.domain.board.gateway.BoardGateway;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public non-sealed class BoardActiveUseCaseImpl implements BoardActiveUseCase {
    private final BoardGateway boardGateway;

    @Autowired
    public BoardActiveUseCaseImpl(BoardGateway boardGateway) {
        this.boardGateway = boardGateway;
    }

    @Transactional
    public void execute(Long id) throws Exception {
        Board board = this.boardGateway.getObject(id);
        if(board == null){
            throw new Exception("Board not exist");
        }
        board.active();
        this.boardGateway.save(board);
    }
}
