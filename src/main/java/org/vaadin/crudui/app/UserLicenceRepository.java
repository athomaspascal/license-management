package org.vaadin.crudui.app;

import org.vaadin.crudui.entity.UserLicence;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserLicenceRepository {

    public static List<UserLicence> findAll() {
        return JpaUserLicence.runInTransaction(em ->
                em.createQuery("select u from UserLicence u").getResultList()
        );
    }

    public static List<UserLicence> findAllFilter(String filtre) {
        System.out.println("Filtre=" + filtre);
        return JpaUserLicence.runInTransaction(em ->
                em.createQuery("select u " +
                        "from UserLicence u " +
                        "where u.team='" + filtre + "'").getResultList()
        );
    }

    public static UserLicence save(UserLicence userLicence) {
        return JpaUserLicence.runInTransaction(em -> em.merge(userLicence));
    }

    public static void delete(UserLicence userLicence) {
        JpaUserLicence.runInTransaction(em -> {
            em.remove(getById(Long.parseLong(String.valueOf(userLicence.getIdUser())), em));
            return null;
        });
    }

    private static UserLicence getById(Long id, EntityManager em) {
        Query query = em.createQuery("select u from UserLicence u " +
                "where u.id_userLicence=:id_userLicence");
        query.setParameter("id_userLicence", id);

        return (UserLicence) query.getResultList().stream().findFirst().orElse(null);
    }

}
