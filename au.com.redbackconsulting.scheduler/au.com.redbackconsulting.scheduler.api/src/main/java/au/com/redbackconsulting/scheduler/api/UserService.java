package au.com.redbackconsulting.scheduler.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import au.com.redbackconsulting.scheduler.api.bean.UserBean;
import au.com.redbackconsulting.scheduler.connectivity.CoreODataConnector;
import au.com.redbackconsulting.scheduler.persistence.model.User;

@Path("/user")
public class UserService extends BaseService {

/*
	@GET
	@Path("/orders/{campain_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public BenefitsOrderBean getUserBenefitsOrderForLoggedUser(@PathParam("campain_id") long campaign_id) throws IOException {
		final OrderService orderService = new OrderService();
		return orderService.getUserBenefitsOrder(campaign_id, getLoggedInUserId());
	}
*/
	@GET
	@Path("/profile")
	@Produces(MediaType.APPLICATION_JSON)
	public UserBean getUserProfile() {
		User currentUser = getLoggedInUser();
		return UserBean.get(currentUser);
	}

/*	
	@GET
	@Path("/info")
	@Produces(MediaType.APPLICATION_JSON)
	public UserBean getInfoProfile() {
		User currentUser = getLoggedInUser();
		UserBean ubean = null;
		try {
			ubean = CoreODataConnector.getInstance().getInfoProfile(currentUser.getUserId());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ubean;
	}

*/
	
/*	
	@GET
	@Path("/managed")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserBean> getManagedUsers() throws IOException {
		User currentUser = getLoggedInUser();
		Campaign activeCampaign = campaignDAO.getActiveCampaign(currentUser);
		List<UserBean> result = new ArrayList<>();
		for (User employee : currentUser.getEmployees()) {
			UserBean userInfo = UserBean.get(employee);
			if (activeCampaign != null) {
				userInfo.setActiveCampaignBalance(getUserPoints(employee, activeCampaign));
			}
			result.add(userInfo);
		}
		return result;
	}

	@GET
	@Path("/campaigns")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CampaignBean> getUserCampaigns() throws IOException {
		final User user = getLoggedInUser();
		return CampaignBean.getList(user.getHrManager().getCampaigns());
	}

	private UserPoints getUserPoints(User employee, Campaign campaign) {
		UserPointsPrimaryKey primaryKey = new UserPointsPrimaryKey(employee.getId(), campaign.getId());
		return userPontsDAO.getByPrimaryKey(primaryKey);
	}
*/	
}
