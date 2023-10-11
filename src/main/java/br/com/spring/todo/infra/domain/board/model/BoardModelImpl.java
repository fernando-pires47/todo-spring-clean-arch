package br.com.spring.todo.infra.domain.board.model;

import br.com.spring.todo.infra.base.BaseModelImpl;
import br.com.spring.todo.core.domain.board.builder.BoardBuilder;
import br.com.spring.todo.core.domain.board.entity.Board;
import br.com.spring.todo.core.domain.board.enumerator.BoardStatus;
import br.com.spring.todo.core.domain.board.model.BoardModel;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "board")
public class BoardModelImpl extends BaseModelImpl implements BoardModel {
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    private BoardStatus status;

    @Column(name = "date_create", nullable = false)
    private Date date_create;

    @Column(name = "date_update")
    private Date date_update;

    public String getName() {
        return name;
    }

    public BoardStatus getStatus() {
        return status;
    }

    public Date getDate_create() {
        return date_create;
    }

    public Date getDate_update() {
        return date_update;
    }

    private BoardModelImpl(){
    }

    public BoardModelImpl(Board board){
        this.id = board.getId();
        this.name = board.getName();
        this.date_create = board.getDate_create();
        this.date_update = board.getDate_update();
        this.status = board.getStatus();
    }
    public Board getBoard(){
        return new BoardBuilder().set(this).build();
    }
}
