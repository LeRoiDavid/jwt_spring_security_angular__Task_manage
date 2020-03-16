package lrd.org.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lrd.org.entities.AppRole;
import lrd.org.entities.AppUser;
import lrd.org.repository.AppRoleRepository;
import lrd.org.repository.AppUserRepository;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AppUserRepository appUserRepository;
	@Autowired
	private AppRoleRepository appRoleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public AppUser addUser(AppUser appUser) {
		appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
		return appUserRepository.save(appUser);
	}

	@Override
	public AppRole addRole(AppRole appRole) {
		return appRoleRepository.save(appRole);
	}

	@Override
	public AppRole findRoleByRoleName(String roleName) {
		return appRoleRepository.findByRoleName(roleName);
	}

	@Override
	public AppUser findUserByUsername(String username) {
		return appUserRepository.findByUsername(username);
	}

	@Override
	public void addRoleToYUser(String username, String roleName) {
		AppUser appUser = findUserByUsername(username);
		AppRole appRole = findRoleByRoleName(roleName);
	
		appUser.getRoles().add(appRole);
	}

}
