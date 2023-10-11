package br.com.spring.todo.core.domain.task.gateway;

import br.com.spring.todo.core.domain.task.entity.Task;

import java.util.List;

public interface TaskGateway {
    void save(Task task);
    void delete(Long id);
    List<Task> getAll();
    Task getObject(Long id);
}
