package au.com.redbackconsulting.scheduler.persistence.model;

import static au.com.redbackconsulting.scheduler.persistence.model.DBQueries.GET_ACTIVE_BREAKS_BY_ACCOUNT;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Date; 

import javax.persistence.*;

/**
 * Entity implementation class for Entity: BreakSchedule
 *
 */
@Entity
@Table(name="BREAK_SCHEDULE")
@NamedQueries({ @NamedQuery(name = GET_ACTIVE_BREAKS_BY_ACCOUNT, query = "select bs from BreakSchedule bs where bs.active = 1 and bs.accountId = :accountId") })
@IdClass(BreakSchedulePK.class)
public class BreakSchedule implements Serializable,IDBEntity {

	private static final long serialVersionUID = 1L;
	   
	@Id
	@Column(name = "ACCOUNT_ID")
	private String accountId;
	
	@Id
	@Column(name = "ID") 
	private Long id;
	
	@Basic
	@Column(name = "NAME")
	private String name;

	@Basic
	@Column(name = "SEQNO")
	private String seqno;
	
	@Basic
	@Column(name = "START")	
	@Temporal(TemporalType.TIME)
	private Date start;
	
	@Basic
	@Column(name = "END")	
	@Temporal(TemporalType.TIME)
	private Date end;

	@Basic
	@Column(name = "ACTIVE")	
	private boolean active;

	@ManyToOne
	@JoinColumn(name="ACCOUNT_ID",referencedColumnName="ACCOUNT_ID")
	private Org Org;
	
	public String getSeqno() {
		return seqno;
	}
	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public BreakSchedule() {
		super();
	}   

	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Org getOrg() {
		return Org;
	}
	public void setOrg(Org org) {
		Org = org;
	}
}
