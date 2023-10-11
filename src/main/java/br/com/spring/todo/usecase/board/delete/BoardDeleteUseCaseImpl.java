package br.com.spring.todo.usecase.board.delete;

import br.com.spring.todo.core.domain.board.gateway.BoardGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public non-sealed class BoardDeleteUseCaseImpl implements BoardDeleteUseCase {
    private final BoardGateway boardGateway;

    @Autowired
    public BoardDeleteUseCaseImpl(BoardGateway boardGateway) {
        this.boardGateway = boardGateway;
    }

    @Transactional
    public void execute(Long id) {
        this.boardGateway.delete(id);
    }
}
