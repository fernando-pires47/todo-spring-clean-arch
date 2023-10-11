package br.com.spring.todo.core.domain.board.builder;

import br.com.spring.todo.core.domain.board.enumerator.BoardStatus;
import br.com.spring.todo.core.base.BaseEntityImpl;
import br.com.spring.todo.core.domain.board.entity.Board;
import br.com.spring.todo.core.domain.board.model.BoardModel;

import java.util.Date;

public class BoardBuilder extends BaseEntityImpl {

    private String name;

    private BoardStatus status;

    private Date date_create;

    private Date date_update;


    public String getName() {
        return name;
    }

    public Date getDate_create() {
        return date_create;
    }

    public BoardStatus getStatus() {
        return status;
    }

    public Date getDate_update() {
        return date_update;
    }

    public BoardBuilder create(String name){
        this.name = name;
        this.status = BoardStatus.ACTIVE;
        this.date_create = new Date();
        return this;
    }

    public BoardBuilder set(BoardModel boardModel){
        this.id = boardModel.getId();
        this.date_create = boardModel.getDate_create();
        this.status = boardModel.getStatus();
        this.date_update = boardModel.getDate_update();
        this.name = boardModel.getName();
        return this;
    }

    public Board build(){
        return new Board(this);
    }
}
