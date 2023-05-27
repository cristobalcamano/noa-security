package com.noa.es.security.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.noa.es.security.model.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long>{

	@Query(value = "select u.* from users u where u.users = ?1 limit 1", nativeQuery = true)
	Optional<Users> findUsersByName(String users);
	
}
