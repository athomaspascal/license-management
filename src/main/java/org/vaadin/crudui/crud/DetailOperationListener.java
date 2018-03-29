package org.vaadin.crudui.crud;


import java.io.Serializable;

@FunctionalInterface
public interface DetailOperationListener<T> extends Serializable {

    T perform(T domainObject);

}
