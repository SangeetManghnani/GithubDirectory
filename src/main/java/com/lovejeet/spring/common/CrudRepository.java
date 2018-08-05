package com.lovejeet.spring.common;

import java.util.List;

/** Interface for generic CRUD operations on a repository for a specific type.
 * @author Lovejeet */
public interface CrudRepository<T, ID> extends Repository<T, ID> {

    /** Saves a given entity. Use the returned instance for further operations as the save operation might have changed
     * the entity instance completely.
     * @param object
     * @return the newly saved object */
    T save(T object);

    /** Retrieves an object by its id.
     * @param id must not be {@literal null}.
     * @return the entity with the given id or {@literal null} if none found
     * @throws IllegalArgumentException if {@code id} is {@literal null} */
    T getById(ID id);

    /** Returns all instances of the type.
     * @return all entities */
    List<T> fetchAll();

    /** Returns all instances of the type with the given IDs.
     * @param ids
     * @return */
    List<T> fetchAll(Integer... ids);

    /** Returns the number of objects available.
     * @return the number of entities */
    int count();

    /** Update the given object
     * @param object */
    void update(T object);

    /** Deletes a given object.
     * @param entity
     * @throws IllegalArgumentException in case the given entity is {@literal null}. */
    void delete(T obj);
}
