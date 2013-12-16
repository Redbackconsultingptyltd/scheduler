package au.com.redbackconsulting.scheduler.persistence.model;

import static au.com.redbackconsulting.scheduler.persistence.model.DBQueries.GET_ORG_BY_ACCOUNT_ID;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "ORGANIZATION", uniqueConstraints = { @UniqueConstraint(columnNames = { "ACCOUNT_ID" }) })
@NamedQueries({ @NamedQuery(name = GET_ORG_BY_ACCOUNT_ID, query = "select o from Org o where o.accountId = :accountId") })
public class Org implements Serializable,IDBEntity {

	private static final long serialVersionUID = 1L;

	public Org() {
	}

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Basic
	@Column(name = "ACCOUNT_ID")
	private String accountId;
	
	@Basic
	@Column(name = "NAME")
	private String name;

	@Basic
	@Column(name = "ACTIVE")
	private boolean active;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="Org",targetEntity=BreakSchedule.class,fetch=FetchType.EAGER)
	private Collection<BreakSchedule> breakSchedules;
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

}