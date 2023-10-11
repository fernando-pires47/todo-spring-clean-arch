package br.com.spring.todo.infra.domain.board.gateway;

import br.com.spring.todo.infra.domain.board.model.BoardModelImpl;
import br.com.spring.todo.core.domain.board.entity.Board;
import br.com.spring.todo.core.domain.board.gateway.BoardGateway;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDatabaseGateway implements BoardGateway {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Board object) {
        if(object.getId() != null){
            entityManager.merge(new BoardModelImpl(object));
        }else{
            entityManager.persist(new BoardModelImpl(object));
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "delete from BoardModelImpl where id = :id";
        Query query = entityManager.createQuery(sql);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public List<Board> getAll() {
        String sql = "from BoardModelImpl";
        Query query = entityManager.createQuery(sql);
        List<BoardModelImpl> entity = query.getResultList();
        return entity.stream().map(BoardModelImpl::getBoard).toList();
    }

    @Override
    public Board getObject(Long id) {
        String sql = " from BoardModelImpl o where o.id = :id ";
        Query query = entityManager.createQuery(sql);
        query.setParameter("id", id);
        try {
            BoardModelImpl taskEntity = (BoardModelImpl) query.getSingleResult();
            return taskEntity.getBoard();
        } catch (NoResultException ex) {
            return null;
        }
    }
}
