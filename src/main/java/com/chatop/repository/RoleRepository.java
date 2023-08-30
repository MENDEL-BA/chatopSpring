package com.chatop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chatop.entities.ERole;
import com.chatop.entities.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
      Optional<Role> findByName(ERole name);

}
