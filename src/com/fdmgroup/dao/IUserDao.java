package com.fdmgroup.dao;

import com.fdmgroup.model.MBUser;

public interface IUserDao extends ICreatable<MBUser>, IReadable<MBUser>, IDeletable<MBUser>, IUpdatable<MBUser> {
	public MBUser readByUsername(String username);
}
