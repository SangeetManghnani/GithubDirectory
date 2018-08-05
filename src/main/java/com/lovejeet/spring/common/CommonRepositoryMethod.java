package com.lovejeet.spring.common;

/** This is the common Repository method interface which extends the crudRepository which includes th crud methods and
 * we can also include any method required common to all the dao implementation in the tool.<br>
 * @author Lovejeet
 * @param <T> the domain type the repository manages
 * @param <ID> the type of the id of the object the repository manages */
public interface CommonRepositoryMethod<T, ID> extends CrudRepository<T, ID> {


}
