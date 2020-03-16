package lrd.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lrd.org.entities.AppRole;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
	public AppRole findByRoleName(String roleName);
}
