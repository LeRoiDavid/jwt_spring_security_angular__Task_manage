package lrd.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lrd.org.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	public AppUser findByUsername(String username);
}
