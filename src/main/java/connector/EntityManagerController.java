package connector;

import jakarta.persistence.EntityManager;
import utils.HibernateUtil;

public class EntityManagerController {
    private static final ThreadLocal<EntityManager> threadLocal = new ThreadLocal<>();

    public static EntityManager getEntityManager() {
        EntityManager em = threadLocal.get();
        if (em == null || !em.isOpen()) {
            // Берем фабрику из вашего HibernateUtil
            em = HibernateUtil.entityManagerFactory.createEntityManager();
            threadLocal.set(em);
        }
        return em;
    }

    public static void closeEntityManager() {
        EntityManager em = threadLocal.get();
        if (em != null) {
            if (em.isOpen()) {
                em.close();
            }
            threadLocal.remove();
        }
    }
}
