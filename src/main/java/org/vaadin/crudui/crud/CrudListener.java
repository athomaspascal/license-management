package org.vaadin.crudui.crud;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author Alejandro Duarte
 */
public interface CrudListener<T> extends Serializable {

    Collection<T> findAll();

    Collection<T> findAllFilter(String filtre);

    T add(T domainObjectToAdd);

    T update(T domainObjectToUpdate);

    T detail(T domainObjectToUpdate);

    void delete(T domainObjectToDelete);

}

