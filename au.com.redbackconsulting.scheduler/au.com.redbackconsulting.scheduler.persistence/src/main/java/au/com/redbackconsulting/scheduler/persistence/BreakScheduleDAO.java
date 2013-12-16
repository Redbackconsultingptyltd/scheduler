package au.com.redbackconsulting.scheduler.persistence;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import au.com.redbackconsulting.scheduler.persistence.manager.PersistenceManager;
import au.com.redbackconsulting.scheduler.persistence.model.BreakSchedule;
import au.com.redbackconsulting.scheduler.persistence.model.DBQueries;
import au.com.redbackconsulting.scheduler.persistence.model.Org;


public class BreakScheduleDAO extends BasicDAO<BreakSchedule> {

    public BreakScheduleDAO() {
        super(PersistenceManager.getInstance().getEntityManagerProvider());
    }

    public BreakSchedule createBreakScheduleForOrg(Org org) {
        final BreakSchedule BreakSchedule = new BreakSchedule();
        BreakSchedule.setOrg(org);
        saveNew(BreakSchedule);
        return BreakSchedule;
    }

    public Collection<BreakSchedule> getBreakSchedulesForOrg(Org org) {
        final EntityManager em = emProvider.get();
        final TypedQuery<BreakSchedule> query = em.createNamedQuery(DBQueries.GET_ACTIVE_BREAKS_BY_ACCOUNT, BreakSchedule.class);
        query.setParameter("accountId", org.getAccountId());
        return query.getResultList();
    }
}
