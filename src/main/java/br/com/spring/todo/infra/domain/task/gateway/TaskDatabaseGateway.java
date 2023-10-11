package br.com.spring.todo.infra.domain.task.gateway;

import br.com.spring.todo.core.domain.task.entity.Task;
import br.com.spring.todo.core.domain.task.gateway.TaskGateway;
import br.com.spring.todo.infra.domain.task.model.TaskModelImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskDatabaseGateway implements TaskGateway {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Task object) {
        if(object.getId() != null){
            entityManager.merge(new TaskModelImpl(object));
        }else{
            entityManager.persist(new TaskModelImpl(object));
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "delete from TaskModelImpl where id = :id";
        Query query = entityManager.createQuery(sql);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public List<Task> getAll() {
        String sql = "from TaskModelImpl";
        Query query = entityManager.createQuery(sql);
        List<TaskModelImpl> entity = query.getResultList();
        return entity.stream().map(TaskModelImpl::getTask).toList();
    }

    @Override
    public Task getObject(Long id) {
        String sql = "from TaskModelImpl where id = :id ";
        Query query = entityManager.createQuery(sql);
        query.setParameter("id", id);
        try {
            TaskModelImpl taskEntity = (TaskModelImpl) query.getSingleResult();
            return taskEntity.getTask();
        } catch (NoResultException ex) {
            return null;
        }
    }
}
