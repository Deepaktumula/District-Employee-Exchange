package com.techm.project.dee.repository;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.techm.project.dee.entity.Employer;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {
	Optional<Employer> findByEmail(String email);

	Optional<Employer> findByEmailAndPassword(String email, String password);

	// updating lastLogin
	@Modifying
	@Query("UPDATE Employer L SET L.lastLogin = :lastLogin WHERE L.email = :email")
	void updateLastLoginDate(@Param("email") String email, @Param("lastLogin") Timestamp lastLogin);

	// updating password
	@Modifying
	@Query("UPDATE Employer L SET L.password = :newPassword, L.lastPasswordUpdate = :lastPasswordUpdate WHERE L.email = :email AND L.password = :oldPassword")
	int updatePassword(@Param("newPassword") String newPassword,
			@Param("lastPasswordUpdate") Timestamp lastPasswordUpdate, @Param("email") String email,
			@Param("oldPassword") String oldPassword);
}
