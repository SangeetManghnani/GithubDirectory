/** This package will contain all the common interface which can be implemented in any of the class <br>
 * Helps in reducing the code.<br>
 * This package has the common methods and interfaces which can be used to extend/implement in other classes. <br>
 * @CommonClassForMapping - This class should be extended in every Mapping class, wherever required. This class will
 *                        have the common fields required for every mapping class like id.<br>
 * @CrudRepository - It is an interface which will include CRUD methods for the Dao classes<br>
 * @CommonRepositoryMethod - It is an interface, which extends CrudRepository and has its own methods also, which user
 *                         wants to have in common for all the Dao classes. This will be extended by all the Dao
 *                         Interface(do not include where not required)<br>
 * @CommonRepositoryMethodImpl - This is implementation for CommonRepositoryMerthod interface, all the methods are
 *                             implemented here, so that user will not have to implemnt these common methods in all the
 *                             Dao Implementation. This class should be extended in all the daoImplementation classes to
 *                             have these methods available there.<br>
 * @SessionUtility - This Class has session related methods.<br>
 *                 This is included in the commomRepositoryMethodImpl class, so it should be included in the Dao class
 *                 where commonRepositoryMethodImpl is not being extended.<br>
 * @author Lovejeet */
package com.lovejeet.spring.common;