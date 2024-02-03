package Repositorios;

import java.util.ArrayList;

public interface CrudRepository<T, ID> {
    void create(T entity);
    T read(ID id);
    ArrayList<T> readAll();
    void update(T entity);
    void delete(ID id);
}