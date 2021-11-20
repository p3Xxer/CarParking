package com.carparking.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<Users, Integer>{
		public List<Users> findByEmail(String email);
		@Query("select u from Users u where u.email = :email")
		public Users getUserByUserName(@Param("email") String email);
}
