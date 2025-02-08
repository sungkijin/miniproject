package com.test.miniproject.svc.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.miniproject.entity.UserEntity;
import com.test.miniproject.repository.member.MemberRepository;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<UserEntity> getMember() {
        List<UserEntity> result = memberRepository.getMember();
        return result;
    }
}
