package br.com.spring.todo.core.domain.task.entity;
import br.com.spring.todo.core.domain.board.entity.Board;
import br.com.spring.todo.core.domain.task.enumerator.TaskStatus;
import br.com.spring.todo.core.base.BaseEntityImpl;
import br.com.spring.todo.core.domain.task.builder.TaskBuilder;

import java.util.Date;

public class Task extends BaseEntityImpl {
    private String title;

    private String description;

    private TaskStatus status;

    private Board board;

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

    public Date getDate_update() {
        return date_update;
    }

    private Task(){}

    public Task(TaskBuilder builder){
        this.id = builder.getId();
        this.title = builder.getTitle();
        this.description = builder.getDescription();
        this.board = builder.getBoard();
        this.date_start = builder.getDate_start();
        this.date_end = builder.getDate_end();
        this.status = builder.getStatus();
        this.date_create = builder.getDate_create();
        this.date_update = builder.getDate_update();
    }

    public void inactive(){
        this.status = TaskStatus.INACTIVE;
    }

    public void active(){
        this.status = TaskStatus.ACTIVE;
    }

    public void changeBoard(Board board){
        this.board = board;
    }

    public void update(String title, String description, Date date_start, Date date_end){
        this.title = title;
        this.description = description;
        this.date_start = date_start;
        this.date_end = date_end;
        this.date_update = new Date();
    }
}
