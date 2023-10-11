package br.com.spring.todo.core.domain.board.model;

import br.com.spring.todo.core.domain.board.enumerator.BoardStatus;
import br.com.spring.todo.core.base.BaseEntityModel;

import java.util.Date;

public interface BoardModel extends BaseEntityModel {

    Date getDate_create();
    Date getDate_update();
    String getName();
    BoardStatus getStatus();
}
