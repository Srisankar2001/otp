package com.project.OTP.Repo;

import com.project.OTP.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<UserEntity,String> {
//    @Query("SELECT u FROM UserEntity u WHERE u.email=?1")
//    Optional<UserEntity> checkEmail(String email);
//
//    @Query("DELETE FROM UserEntity u WHERE u.email=?1")
//    int deleteEmail(String email);

    Optional<UserEntity> findByEmail(String email);
    int deleteByEmail(String email);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO otp(email,otp) VALUES(?1,?2)",nativeQuery = true)
    int addNewMail(String email,int otp);

}
