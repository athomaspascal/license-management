package org.vaadin.crudui.app;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PlateformRepository {

    public static List<Plateform> findAll() {
        return JPAPlateform.runInTransaction(em ->
                em.createQuery("select u from Plateform u").getResultList()
        );
    }

    public static List<Plateform> findAllFilter(String filtre) {
        System.out.println("Filtre=" + filtre);
        return JPAPlateform.runInTransaction(em ->
                em.createQuery("select u " +
                        "from Plateform u " +
                        "where u.env='" + filtre + "'").getResultList()
        );
    }

    public static Plateform save(Plateform plateform) {
        return JPAPlateform.runInTransaction(em -> em.merge(plateform));
    }

    public static void delete(Plateform plateform) {
        JPAPlateform.runInTransaction(em -> {
            em.remove(getById(Long.parseLong(String.valueOf(plateform.getIdPlateform())), em));
            return null;
        });
    }

    private static Plateform getById(Long id, EntityManager em) {
        Query query = em.createQuery("select u from Plateform u " +
                "where u.id_plateform=:id_plateform");
        query.setParameter("id_plateform", id);

        return (Plateform) query.getResultList().stream().findFirst().orElse(null);
    }

}
