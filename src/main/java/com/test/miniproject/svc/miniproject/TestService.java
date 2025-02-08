package com.test.miniproject.svc.miniproject;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.miniproject.ctr.dto.SaveUserDto;
import com.test.miniproject.entity.SaveUserEntity;
import com.test.miniproject.entity.TestEntity;
import com.test.miniproject.repository.miniproject.TestRepository;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    public List<TestEntity> getTest() {
        List<TestEntity> result = testRepository.selectAllSQL();
        return result;
    }

    public String saveUser(SaveUserDto saveUserDto) {
        
        // if (saveUserDto == null) {
        //     return "fail";
        // }else if(saveUserDto.getEmail() == null || saveUserDto.getEmail().equals("")) {
        //     return "fail";
        // }else if (saveUserDto.getPassword() == null || saveUserDto.getPassword().equals("")) {
        //     return "fail";
        // }

        String result = "";
        // SaveUserEntity saveUser = new SaveUserEntity(saveUserDto.getEmail(), saveUserDto.getPassword());
        // int dbResult = testRepository.insertSQL(saveUser.getEmail(), saveUser.getPassword());

        // if (dbResult == 1) {
        //     result = "success";
        // } else {
        //     result = "fail";
        // }
        return result;
    }
}
