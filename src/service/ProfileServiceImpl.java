package service;

import java.util.ArrayList;
import java.util.List;

import bean.Profile;

public class ProfileServiceImpl implements ProfileService {
    private static ProfileService instance = new ProfileServiceImpl();

    protected ProfileServiceImpl() {

    }

    private List<Profile> profiles = new ArrayList<Profile> ();



    public static ProfileService getInstance() {
        return instance;
    }

    /* (non-Javadoc)
     * @see service.ProfileService#getProfile(java.lang.String)
     */
    @Override
    public List<Profile> getProfile(String username) {

        List<Profile> userProfile = new ArrayList<Profile>();

        for (Profile profile : profiles) {
            if (profile.getUsername().equals(username)) {
                userProfile.add(profile);
            }
        }
        return userProfile;


    }

    /* (non-Javadoc)
     * @see service.ProfileService#createProfile(bean.Profile)
     */
    @Override
    public void createProfile(Profile Profile) {
        profiles.add(Profile);
    }

    /* (non-Javadoc)
     * @see service.ProfileService#deleteProfile(bean.Profile)
     */
    @Override
    public void deleteProfile(Profile Profile) {
        profiles.remove(Profile);
    }

    /* (non-Javadoc)
     * @see service.ProfileService#listProfile()
     */
    @Override
    public List<Profile> listProfile() {
        return profiles;
    }

    /* (non-Javadoc)
     * @see service.ProfileService#isProfileExists(java.lang.String)
     */
    @Override
    public boolean isProfileExists(String Profilename) {

        for (Profile profile : profiles) {

            if (profile.getProfilename().equals(Profilename)) {
                return true;
            }
        }
        return false;
    }

}
