package au.com.redbackconsulting.scheduler.persistence.manager;

import javax.persistence.EntityManager;

public interface EntityManagerProvider {

    EntityManager get();

}
