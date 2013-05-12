package service;

import java.util.List;

import bean.Profile;

public interface ProfileService {

    public abstract List<Profile> getProfile(String userName);

    public abstract void createProfile(Profile profile);

    public abstract void deleteProfile(Profile profile);

    public abstract List<Profile> listProfile();

    public abstract boolean isProfileExists(String profileName);

}