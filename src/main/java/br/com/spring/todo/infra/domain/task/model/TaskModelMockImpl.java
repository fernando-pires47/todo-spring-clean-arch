package br.com.spring.todo.infra.domain.task.model;

import br.com.spring.todo.core.domain.task.enumerator.TaskStatus;
import br.com.spring.todo.core.domain.task.model.TaskModel;
import br.com.spring.todo.infra.base.BaseModelImpl;
import br.com.spring.todo.infra.domain.board.model.BoardModelImpl;
import br.com.spring.todo.core.domain.board.model.BoardModel;

import java.util.Date;

public class TaskModelMockImpl extends BaseModelImpl implements TaskModel {

    private String title;
    private String description;
    private TaskStatus status;
    private BoardModelImpl board;
    private Date date_start;
    private Date date_end;
    private Date date_create;
    private Date date_update;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public BoardModelImpl getBoard() {
        return board;
    }

    public Date getDate_start() {
        return date_start;
    }

    public Date getDate_end() {
        return date_end;
    }

    public Date getDate_create() {
        return date_create;
    }

    public Date getDate_update() {
        return date_update;
    }

    public TaskModelMockImpl(Long id, String title, String description, BoardModel board, Date date_start, Date date_end, Date date_create, Date date_update, TaskStatus status){
        this.id = id;
        this.title = title;
        this.description = description;
        this.board = (BoardModelImpl) board;
        this.date_start = date_start;
        this.date_end = date_end;
        this.date_create = date_create;
        this.date_update = date_update;
        this.status = status;
    }
}
