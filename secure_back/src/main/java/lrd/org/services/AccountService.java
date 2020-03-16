package lrd.org.services;

import lrd.org.entities.AppRole;
import lrd.org.entities.AppUser;

public interface AccountService {
	public AppUser addUser(AppUser appUser);
	public AppRole addRole(AppRole appRole);
	public AppRole findRoleByRoleName(String roleName);
	public AppUser findUserByUsername(String username);
	public void addRoleToYUser(String username, String rolename);
}
