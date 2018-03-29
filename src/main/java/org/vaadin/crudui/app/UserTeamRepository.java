package org.vaadin.crudui.app;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserTeamRepository {

    public static List<UserTeam> findAll() {
        return JPATeamService.runInTransaction(em ->
                em.createQuery("select u from UserTeam u").getResultList()
        );
    }

    public static UserTeam save(UserTeam user) {
        return JPATeamService.runInTransaction(em -> em.merge(user));
    }

    public static void delete(UserTeam user) {
        JPATeamService.runInTransaction(em -> {
            em.remove(getById(Long.parseLong(String.valueOf(user.getIdUser())), em));
            return null;
        });
    }

    private static UserTeam getById(Long id, EntityManager em) {
        Query query = em.createQuery("select u from UserTeam u where u.id_user=:id_user");
        query.setParameter("id_user", id);

        return (UserTeam) query.getResultList().stream().findFirst().orElse(null);
    }
}
