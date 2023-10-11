package br.com.spring.todo.infra.domain.task.model;

import br.com.spring.todo.core.domain.task.model.TaskModel;
import br.com.spring.todo.infra.base.BaseModelImpl;
import br.com.spring.todo.infra.domain.board.model.BoardModelImpl;
import br.com.spring.todo.core.domain.task.builder.TaskBuilder;
import br.com.spring.todo.core.domain.task.entity.Task;
import br.com.spring.todo.core.domain.task.enumerator.TaskStatus;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "task")
public class TaskModelImpl extends BaseModelImpl implements TaskModel {
    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Column(name = "description", nullable = false, length = 5000)
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @JoinColumn(name = "board",nullable = false)
    @ManyToOne
    private BoardModelImpl board;

    @Column(name = "date_start")
    private Date date_start;

    @Column(name = "date_end")
    private Date date_end;

    @Column(name = "date_create", nullable = false)
    private Date date_create;

    @Column(name = "date_update")
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

    private TaskModelImpl(){
    }

    public TaskModelImpl(Task task){
        this.id = task.getId();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.board = new BoardModelImpl(task.getBoard());
        this.date_start = task.getDate_start();
        this.date_end = task.getDate_end();
        this.date_create = task.getDate_create();
        this.date_update = task.getDate_update();
        this.status = task.getStatus();
    }
    public Task getTask(){
        return new TaskBuilder().set(this).build();
    }
}
