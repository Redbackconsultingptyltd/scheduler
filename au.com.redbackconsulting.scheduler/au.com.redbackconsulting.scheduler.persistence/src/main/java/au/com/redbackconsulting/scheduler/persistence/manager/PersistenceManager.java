package au.com.redbackconsulting.scheduler.persistence.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import au.com.redbackconsulting.scheduler.persistence.manager.impl.DataSourceProvider;
import au.com.redbackconsulting.scheduler.persistence.manager.impl.EntityManagerFactoryProvider;
import au.com.redbackconsulting.scheduler.persistence.manager.impl.EntityManagerProviderImpl;

public class PersistenceManager {

    private static PersistenceManager instance = null;

    private EntityManagerFactory factory = null;
    private EntityManagerProviderImpl emProvider = null;

    public synchronized static PersistenceManager getInstance() {
        if (instance == null) {
            final DataSource dataSource = DataSourceProvider.getInstance().get();
            final EntityManagerFactory emFactory = EntityManagerFactoryProvider.getInstance().createEntityManagerFactory(dataSource);
            instance = new PersistenceManager(emFactory, new EntityManagerProviderImpl());
        }

        return instance;
    }

    private PersistenceManager(EntityManagerFactory emFactory, EntityManagerProviderImpl provider) {
        factory = emFactory;
        emProvider = provider;
    }

    public EntityManagerProvider getEntityManagerProvider() {
        return emProvider;
    }

    public synchronized void initEntityManagerProvider() {
        emProvider.set(factory.createEntityManager());
    }

    public synchronized void closeEntityManager() {
        final EntityManager em = emProvider.get();
        if (em != null) {
            em.close();
        }
        emProvider.remove();
    }

    public synchronized void closeAll() {
        closeEntityManager();
        if (factory != null) {
            factory.close();
        }
        instance = null;
    }

}
