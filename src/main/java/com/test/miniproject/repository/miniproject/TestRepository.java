package com.test.miniproject.repository.miniproject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.miniproject.entity.TestEntity;


@Repository
public interface TestRepository extends JpaRepository<TestEntity, String> {

    @Query(value = "SELECT * FROM login_inf", nativeQuery = true)
    public List<TestEntity> selectAllSQL();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO login_inf (email, password, regdate) VALUES (:email, :password, current_timestamp())", nativeQuery = true)
    public int insertSQL(@Param("email") String email, @Param("password") String password);
    
}
