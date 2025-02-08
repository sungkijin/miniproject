package com.test.miniproject.ctr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;

import com.test.miniproject.ctr.dto.SaveUserDto;
import com.test.miniproject.entity.UserEntity;
import com.test.miniproject.svc.member.MemberService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;


// import com.test.miniproject.entity.UserEntity;
// import com.test.miniproject.svc.member.MemberService;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @GetMapping("/membertest")
    public String getTest() {
        return "test";
        // return memberService.getMember();
    }
    @Autowired
    private MemberService memberService;

    @GetMapping("/membersearch")
    public List<UserEntity> getMember() {
        return memberService.getMember();
    }

    @PostMapping("/join")
    public String memberJoin (@RequestBody SaveUserDto saveUserDto) {
        //TODO: process POST request
        System.out.println("연결됨"  + saveUserDto);
        return "연결성공 " + saveUserDto;
    }
    
}
