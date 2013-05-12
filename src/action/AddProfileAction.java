package action;

import java.util.Collection;

import service.ProfileService;
import bean.Profile;

public class AddProfileAction  { //implements Preparable

    private Collection lists1;

    private Profile profile;

    private ProfileService profileService;

    public String execute() {

        //service class injected by spring
        profileService.createProfile(profile);

        return "success";

    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Collection getLists1() {
        return lists1;
    }

    public void setLists1(Collection lists1) {
        this.lists1 = lists1;
    }

    public ProfileService getProfileService() {
        return profileService;
    }

    public void setProfileService(ProfileService profileService) {
        this.profileService = profileService;
    }
/*
    @Override
    public void prepare() throws Exception {
         profile = profileService.find(id);
    }
*/

}
