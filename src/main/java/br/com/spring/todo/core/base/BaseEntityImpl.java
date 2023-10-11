package br.com.spring.todo.core.base;

public class BaseEntityImpl implements BaseEntityModel {
    protected Long id;

    @Override
    public Long getId() {
        return this.id;
    }
}
