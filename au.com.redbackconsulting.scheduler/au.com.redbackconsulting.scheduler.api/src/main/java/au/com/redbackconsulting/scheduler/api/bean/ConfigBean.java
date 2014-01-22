package au.com.redbackconsulting.scheduler.api.bean;

import com.google.gson.annotations.Expose;

public class ConfigBean {

    @Expose
    public boolean showEmployeesTile;

    @Expose
    public boolean showBenefitsTile;

    @Expose
    public boolean showCampaignTile;

    @Expose
    public boolean showOrderTile;
    
    @Expose
    public boolean showInfoTile;

    public void initAdminConfiguration() {
        init(true, true, true, true, true);
    }

    public void initEmployeeConfiguration() {
        init(false, true, false, true, true);
    }

    private void init(boolean employeesTile, boolean benefitsTile, boolean campaignTile, boolean orderTile, boolean infoTile ) {
        this.showBenefitsTile = benefitsTile;
        this.showEmployeesTile = employeesTile;
        this.showCampaignTile = campaignTile;
        this.showOrderTile = orderTile;
        this.showInfoTile = infoTile; 
    }

}
