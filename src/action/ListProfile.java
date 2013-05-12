package action;

import java.util.List;

import service.ProfileService;
import service.ProfileServiceImpl;
import bean.Profile;

import com.opensymphony.xwork2.Action;

public class ListProfile implements Action {

    List<Profile> profiles;

    private ProfileService profileService;

    @Override
    public String execute() throws Exception {

        // injected by spring
        profiles = profileService.listProfile();

        return SUCCESS;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public ProfileService getProfileService() {
        return profileService;
    }

    public void setProfileService(ProfileService profileService) {
        this.profileService = profileService;
    }



}
