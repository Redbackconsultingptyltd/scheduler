package au.com.redbackconsulting.scheduler.persistence;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import au.com.redbackconsulting.scheduler.persistence.manager.PersistenceManager;
import au.com.redbackconsulting.scheduler.persistence.model.DBQueries;
import au.com.redbackconsulting.scheduler.persistence.model.Org;

public class OrgDAO extends BasicDAO<Org> {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public OrgDAO() {
		super(PersistenceManager.getInstance().getEntityManagerProvider());
	}

	public Org getByAccountId(String accountId) {
		final EntityManager em = emProvider.get();
		try {
			final TypedQuery<Org> query = em.createNamedQuery(DBQueries.GET_ORG_BY_ACCOUNT_ID, Org.class);
			query.setParameter("accountId", accountId);
			Org org = query.getSingleResult();
			return org;
		} catch (NoResultException x) {
			logger.error("Could not retrieve entity for orgId {} from table {}.", accountId, "Org");
		} catch (NonUniqueResultException e) {
			logger.error("More than one entity for orgId {} from table {}.", accountId, "Org");
		}

		return null;
	}

	public Org getOrCreateOrg(String accountId) {
		Org org = getByAccountId(accountId);
		if (org == null) {
			org = new Org();
			org.setAccountId(accountId);
			saveNew(org);
		}
		return org;
	}

}
