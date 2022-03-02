package com.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.projet.model.Role;


@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role, Long> {
public Role findByRoleName(String rolename);
}
