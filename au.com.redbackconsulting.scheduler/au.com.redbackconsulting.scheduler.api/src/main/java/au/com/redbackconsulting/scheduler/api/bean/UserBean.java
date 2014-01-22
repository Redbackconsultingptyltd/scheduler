package au.com.redbackconsulting.scheduler.api.bean;

import java.text.MessageFormat;

import au.com.redbackconsulting.scheduler.persistence.model.User;

import com.google.gson.annotations.Expose;


public class UserBean {

	@Expose
	public String firstName;

	@Expose
	public String lastName;

	@Expose
	public String fullName;

	@Expose
	public String userId;

	@Expose
	public String email;

	@Expose
	public String location;

	@Expose
	public String businessPhone;

	@Expose
	public String cellPhone;

	@Expose
	public String division;

	@Expose
	public String title;

	@Expose
	public String department;

	@Expose
	public UserBean hr;

	public void init(User user) {
		this.email = user.getEmail();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.fullName = MessageFormat.format("{0} {1}", user.getFirstName(), user.getLastName());
		this.userId = user.getUserId();

	}

	public static UserBean get(User user) {
		UserBean result = new UserBean();
		result.init(user);
		return result;
	}
}
