package br.com.spring.todo.core.domain.board.entity;
import br.com.spring.todo.core.domain.board.builder.BoardBuilder;
import br.com.spring.todo.core.domain.board.enumerator.BoardStatus;
import br.com.spring.todo.core.base.BaseEntityImpl;

import java.util.Date;

public class Board extends BaseEntityImpl {
    private String name;

    private BoardStatus status;

    private Date date_create;

    private Date date_update;

    public Date getDate_create() {
        return date_create;
    }

    public Date getDate_update() {
        return date_update;
    }

    public String getName() {
        return name;
    }

    public BoardStatus getStatus() {
        return status;
    }

    private Board(){}

    public Board(BoardBuilder builder){
        this.id = builder.getId();
        this.name = builder.getName();
        this.date_create = builder.getDate_create();
        this.date_update = builder.getDate_update();
        this.status = builder.getStatus();
    }

    public void inactive(){
        this.status = BoardStatus.INACTIVE;
    }

    public void active(){
        this.status = BoardStatus.ACTIVE;
    }

    public void update(String name){
        this.name = name;
        this.date_update = new Date();
    }
}
