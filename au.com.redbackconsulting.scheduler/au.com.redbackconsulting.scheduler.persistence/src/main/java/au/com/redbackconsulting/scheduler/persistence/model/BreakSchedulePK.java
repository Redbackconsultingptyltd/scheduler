package au.com.redbackconsulting.scheduler.persistence.model;

import java.io.Serializable;
import java.lang.Long;

/**
 * ID class for entity: BreakSchedule
 *
 */ 
public class BreakSchedulePK  implements Serializable {   
   
	         
	private String accountId;         
	private Long id;
	private static final long serialVersionUID = 1L;

	public BreakSchedulePK() {}

	


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
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof BreakSchedulePK)) {
			return false;
		}
		BreakSchedulePK other = (BreakSchedulePK) o;
		return true
			&& (getAccountId() == null ? other.getAccountId() == null : getAccountId().equals(other.getAccountId()))
			&& (getId() == null ? other.getId() == null : getId().equals(other.getId()));
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getAccountId() == null ? 0 : getAccountId().hashCode());
		result = prime * result + (getId() == null ? 0 : getId().hashCode());
		return result;
	}
   
   
}
