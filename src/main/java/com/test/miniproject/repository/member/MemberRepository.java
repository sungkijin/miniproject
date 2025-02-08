package com.test.miniproject.repository.member;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.miniproject.entity.UserEntity;

@Repository
public interface MemberRepository extends JpaRepository<UserEntity, Integer> {

    @Query(value = "SELECT * FROM user", nativeQuery = true)
    public List<UserEntity> getMember();

}
                                                              