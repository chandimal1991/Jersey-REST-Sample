package com.nss.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.nss.database.Database;
import com.nss.model.Message;
import com.nss.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles = Database.getProfiles();
	
	
	
	public ProfileService() {
		profiles.put("Rasika", new Profile(1L,"Rasika Chandimal","Rasika","Chandimal"));
	}

	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty()) {
			return null;
		}
		
		profiles.put(profile.getProfileName(), profile);
		return profile;
		
	}
	
	public void removeProfile(String profileName){
		profiles.remove(profileName);
		
	}

}
