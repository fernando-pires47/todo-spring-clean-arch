package br.com.spring.todo.infra.base;

import br.com.spring.todo.core.base.BaseEntityModel;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseModelImpl implements BaseEntityModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Override
    public Long getId() {
        return this.id;
    }
}
