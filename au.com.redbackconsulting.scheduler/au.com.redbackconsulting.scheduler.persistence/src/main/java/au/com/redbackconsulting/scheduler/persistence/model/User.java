package au.com.redbackconsulting.scheduler.persistence.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "USERS", uniqueConstraints = { @UniqueConstraint(columnNames = { "USER_ID" }) })
@NamedQueries({ @NamedQuery(name = DBQueries.GET_USER_BY_USER_ID, query = "select u from User u where u.userId = :userId") })
public class User implements Serializable,IDBEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8129499475178666334L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Basic
	@Column(name = "FIRST_NAME")
	private String firstName;

	@Basic
	@Column(name = "LAST_NAME")
	private String lastName;

	@Basic
	@Column(name = "USER_ID")
	private String userId;

	@Basic
	private String email;

	@ManyToOne
	@JoinColumn(name = "HR_USER_ID")
	private User hrManager;

	@OneToMany(mappedBy = "hrManager", fetch = FetchType.LAZY, targetEntity = User.class)
	private Collection<User> employees;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public User getHrManager() {
		return hrManager;
	}

	public void setHrManager(User hrManager) {
		this.hrManager = hrManager;
		if (!hrManager.getEmployees().contains(this)) {
			hrManager.addEmployee(this);
		}
	}

	public Collection<User> getEmployees() {
		if (this.employees == null) {
			this.employees = new ArrayList<>();
		}
		return employees;
	}

	public void addEmployee(User employee) {
		getEmployees().add(employee);
		if (employee.getHrManager() != this) {
			employee.setHrManager(this);
		}
	}

	public void setEmployees(Collection<User> employees) {
		this.employees = employees;
	}

}
