package au.com.redbackconsulting.scheduler.api;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import au.com.redbackconsulting.scheduler.api.bean.ConfigBean;
import au.com.redbackconsulting.scheduler.persistence.*;

@Path("/system")
public class SystemService extends BaseService {

    private final Logger logger = LoggerFactory.getLogger(SystemService.class);

 /*
    @POST
    @Path("reset-db")
    public Response resetDatabase() {
        cleanDB();
        final BenefitsDataImporter benefitImporter = new BenefitsDataImporter();
        try {
        
            benefitImporter.importData("/benefits.csv");
        } catch (IOException e) {
            logger.error("Could not insert beneits data into DB", e);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.ok().build();
    }

*/
    @GET
    @Path("ui-config")
    @Produces(MediaType.APPLICATION_JSON)
    public ConfigBean getUIConfigurationData() {
        final ConfigBean config = new ConfigBean();
        if (request.isUserInRole(ADMIN_ROLE)) {
            config.initAdminConfiguration();
        } else {
            config.initEmployeeConfiguration();
        }

        return config;
    }

    private void cleanDB() {
        final UserDAO userDAO = new UserDAO();

        userDAO.deleteAll();
    }

}