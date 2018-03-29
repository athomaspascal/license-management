package org.vaadin.crudui.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JPATeamService {


    private static EntityManagerFactory factory;

    public static void init() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("demo");
            createTestData();
        }
    }

    private static void createTestData() {
        for (int i = 1; i < 5; i++) {
            Group group = new Group();
            group.setName("Group " + i);
            group.setAdmin(false);
            GroupRepository.save(group);
        }

        Set<Group> groups = GroupRepository.findAll().stream()
                .filter(r -> r.getId() <= 2)
                .collect(Collectors.toSet());

        for (int i = 1; i <= 50; i++) {
            UserTeam user = new UserTeam();
            user.setUserName("User " + i);
            user.setUserPassword(user.getUserName());
            user.setDateCreation(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));

            UserTeamRepository.save(user);
        }
    }

    public static void close() {
        factory.close();
    }

    public static EntityManagerFactory getFactory() {
        return factory;
    }

    public static <T> T runInTransaction(Function<EntityManager, T> function) {
        EntityManager entityManager = null;

        try {
            entityManager = JPATeamService.getFactory().createEntityManager();
            entityManager.getTransaction().begin();

            T result = function.apply(entityManager);

            entityManager.getTransaction().commit();
            return result;

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

}
