package br.com.spring.todo.core.domain.task.builder;

import br.com.spring.todo.core.domain.board.builder.BoardBuilder;
import br.com.spring.todo.core.domain.board.entity.Board;
import br.com.spring.todo.core.domain.task.entity.Task;
import br.com.spring.todo.core.domain.task.enumerator.TaskStatus;
import br.com.spring.todo.infra.domain.task.model.TaskModelImpl;
import br.com.spring.todo.core.base.BaseEntityImpl;

import java.util.Date;

public class TaskBuilder extends BaseEntityImpl {
    private String title;

    private String description;

    private Board board;

    private Date date_start;

    private Date date_end;

    private Date date_create;

    private Date date_update;

    private TaskStatus status;


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Board getBoard() {
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

    public TaskStatus getStatus() {
        return status;
    }

    public Date getDate_update() {
        return date_update;
    }

    public TaskBuilder create(String title, String description, Board board, Date date_start, Date date_end){
        this.title = title;
        this.description = description;
        this.board = board;
        this.date_start = date_start;
        this.date_end = date_end;
        this.status = TaskStatus.ACTIVE;
        this.date_create = new Date();
        return this;
    }

    public TaskBuilder set(TaskModelImpl entity){
        this.id = entity.getId();
        this.status = entity.getStatus();
        this.title = entity.getTitle();
        this.description = entity.getDescription();
        this.board = new BoardBuilder().set(entity.getBoard()).build();
        this.date_start = entity.getDate_start();
        this.date_end = entity.getDate_end();
        this.date_create = entity.getDate_create();
        this.date_update = entity.getDate_update();
        return this;
    }

    public Task build(){
        return new Task(this);
    }

}
