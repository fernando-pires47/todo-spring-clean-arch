package br.com.spring.todo.infra.domain.board.model;

import br.com.spring.todo.core.domain.board.enumerator.BoardStatus;
import br.com.spring.todo.infra.base.BaseModelImpl;
import br.com.spring.todo.core.domain.board.model.BoardModel;

import java.util.Date;

public class BoardModelMockImpl extends BaseModelImpl implements BoardModel {

    private String name;
    private Date date_create;
    private Date date_update;

    private BoardStatus status;


    @Override
    public Date getDate_create() {
        return this.date_create;
    }

    @Override
    public Date getDate_update() {
        return this.date_update;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public BoardStatus getStatus() {
        return this.status;
    }

    public BoardModelMockImpl(Long id, String name, Date date_create, Date date_update, BoardStatus status){
        this.id = id;
        this.name = name;
        this.date_create = date_create;
        this.date_update = date_update;
        this.status = status;
    }
}
