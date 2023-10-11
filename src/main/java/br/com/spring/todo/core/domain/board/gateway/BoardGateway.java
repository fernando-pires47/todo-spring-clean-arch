package br.com.spring.todo.core.domain.board.gateway;

import br.com.spring.todo.core.domain.board.entity.Board;

import java.util.List;

public interface BoardGateway {
    void save(Board board);
    void delete(Long id);
    List<Board> getAll();
    Board getObject(Long id);
}
