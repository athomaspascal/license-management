package org.vaadin.crudui.crud;

import java.io.Serializable;
import java.util.Collection;

@FunctionalInterface
public interface FindallFiltercrudoperationlistener<T> extends Serializable {

    Collection<T> findAllFilter(String filter);

}
