package repository;

import domain.Entity;

import java.util.HashMap;
import java.util.Map;

public class RepoInMemory<ID, E extends Entity<ID>> implements Repository<ID,E> {
    Map<ID,E> entities;

    public RepoInMemory() {
        entities = new HashMap<ID,E>();
    }

    @Override
    public E findOne(ID id){
        if (id == null)
            throw new IllegalArgumentException("id must be not null");
        return entities.get(id);
    }

    @Override
    public Iterable<E> findAll() {
        return entities.values();
    }

    @Override
    public E save(E entity) {
        if (entity == null)
            throw new IllegalArgumentException("entity must be not null");
        if(entities.get(entity.getId()) != null)
            return entity;
        else entities.put(entity.getId(),entity);
        return null;
    }

    @Override
    public E delete(ID id) {
        if (id == null)
            throw new IllegalArgumentException("id must be not null");
        if(entities.get(id) == null)
            return entities.get(id);
        else entities.remove(id);
        return null;
    }
}
