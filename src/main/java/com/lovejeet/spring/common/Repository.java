package com.lovejeet.spring.common; 

/** Central repository marker interface. Captures the domain type to manage as well as the domain type's id type.
 * General purpose is to hold type information as well as being able to discover interfaces that extend this one during
 * classpath scanning.
 * <p>
 * Domain repositories extending this interface can selectively expose CRUD methods by simply declaring methods of the
 * same signature as those declared in {@link CrudRepository}.
 * @see CrudRepository
 * @param <T> the domain type the repository manages
 * @param <ID> the type of the id of the object the repository manages
 * @author Lovejeet */
public interface Repository<T, ID> {

}
