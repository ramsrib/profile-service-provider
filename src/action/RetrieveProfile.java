package action;

import java.util.List;

import service.ProfileService;
import service.ProfileServiceImpl;
import bean.Profile;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class RetrieveProfile extends ActionSupport {

    private String username;

    private Object jsonModel;

    private ProfileService profileService;

    public Object getJsonModel() {
        return jsonModel;
    }

    public void setJsonModel(Object jsonModel) {
        this.jsonModel = jsonModel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String execute() {

        // injected by spring
        List<Profile> profile = profileService.getProfile(getUsername());
        setJsonModel(profile);

        return SUCCESS;
    }

    public ProfileService getProfileService() {
        return profileService;
    }

    public void setProfileService(ProfileService profileService) {
        this.profileService = profileService;
    }



}
