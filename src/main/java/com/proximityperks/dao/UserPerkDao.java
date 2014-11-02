package com.proximityperks.dao;

import java.util.List;

import com.proximityperks.data.User;
import com.proximityperks.data.UserPerk;

public interface UserPerkDao {

	public List<UserPerk> getUserPerks();

	public UserPerk saveOrUpdate(UserPerk userPerk);

	public boolean deleteUserPerk(UserPerk userPerk);

	public UserPerk getUserPerkById(Long userPerkId);

	public List<UserPerk> getUserPerks(final User user);

}
