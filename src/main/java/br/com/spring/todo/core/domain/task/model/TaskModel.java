package br.com.spring.todo.core.domain.task.model;

import br.com.spring.todo.core.domain.board.model.BoardModel;
import br.com.spring.todo.core.domain.task.enumerator.TaskStatus;

import java.util.Date;

public interface TaskModel {
    String getTitle();
    TaskStatus getStatus();
    BoardModel getBoard();
    Date getDate_start();
    Date getDate_end();
    Date getDate_create();
    Date getDate_update();
}
