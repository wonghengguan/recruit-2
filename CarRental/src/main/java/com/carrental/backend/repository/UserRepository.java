package com.carrental.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.carrental.backend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query("select user from User user "
            + "where user.id = :userID")
    User getUserByID(
            @Param("userID") Long userID
    );
	
	@Query("select user from User user "
            + "where user.username = :username "
			+ "and user.password = :password")
    User getUserByUsernameAndPassword(
    		@Param("username") String username,
    		@Param("password") String password
    );
	

}
