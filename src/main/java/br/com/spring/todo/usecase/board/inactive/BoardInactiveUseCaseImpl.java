package br.com.spring.todo.usecase.board.inactive;

import br.com.spring.todo.core.domain.board.gateway.BoardGateway;
import br.com.spring.todo.core.domain.board.entity.Board;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public non-sealed class BoardInactiveUseCaseImpl implements BoardInactiveUseCase {
    private final BoardGateway boardGateway;

    @Autowired
    public BoardInactiveUseCaseImpl(BoardGateway boardGateway) {
        this.boardGateway = boardGateway;
    }

    @Transactional
    public void execute(Long id) throws Exception {
        Board board = this.boardGateway.getObject(id);
        if(board == null){
            throw new Exception("Board not exist");
        }
        board.inactive();
        this.boardGateway.save(board);
    }
}
